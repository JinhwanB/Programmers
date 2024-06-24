package Lv2;

import java.util.Arrays;
import java.util.PriorityQueue;

// 광물 캐기
public class N172927 {

    static int result = Integer.MAX_VALUE;

    public static int solution(int[] picks, String[] minerals) {
        int pickCnt = Arrays.stream(picks).sum(); // 곡괭이 갯수
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                if (o1[1] == o2[1]) {
                    return o1[2] - o2[2];
                }

                return o1[1] - o2[1];
            }

            return o1[0] - o2[0];
        });
        int idx = 0; // 광물을 캐기 시작할 minerals 의 인덱스
        // 곡괭이 갯수만큼 광물을 캐는 경우를 각각 구해서 우선순위 큐에 넣는다.
        // 5개씩 순서대로 캔다.(문제 조건)
        for (int i = 0; i < pickCnt; i++) {
            if (idx >= minerals.length) { // 이미 광물을 다 캔 경우
                break;
            }

            int[] tired = new int[3];
            int sum1 = 0, sum2 = 0, sum3 = 0;
            for (int j = idx; j < Math.min(idx + 5, minerals.length); j++) {
                String cur = minerals[j];
                if (cur.equals("diamond")) {
                    sum1++;
                    sum2 += 5;
                    sum3 += 25;
                } else if (cur.equals("iron")) {
                    sum1++;
                    sum2++;
                    sum3 += 5;
                } else {
                    sum1++;
                    sum2++;
                    sum3++;
                }
            }

            idx += 5;
            tired[0] = sum1; // 다이아몬드 곡괭이로 캐는 경우
            tired[1] = sum2; // 철 곡괭이로 캐는 경우
            tired[2] = sum3; // 돌 곡괭이로 캐는 경우
            pq.offer(tired);
        }

        findMin(picks, pq, 0);

        return result;
    }

    // 재귀적으로 어느 곡괭이로 먼저 사용하는 것이 더 최소의 피로도를 가지는지 구한다.
    private static void findMin(int[] picks, PriorityQueue<int[]> pq, int tired) {
        if (pq.isEmpty()) {
            result = Math.min(result, tired);
            return;
        }

        for (int i = 0; i < picks.length; i++) {
            int cur = picks[i];
            if (cur == 0) { // 현재 곡괭이가 없는 경우
                continue;
            }

            int[] poll = pq.poll();
            picks[i] -= 1;
            findMin(picks, pq, tired + poll[i]);
            picks[i] += 1;
            pq.offer(poll);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 2},
            new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron",
                "stone"}));
        result = Integer.MAX_VALUE;
        System.out.println(solution(new int[]{0, 1, 1},
            new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron",
                "iron", "iron", "iron", "diamond"}));
        result = Integer.MAX_VALUE;
        System.out.println(solution(new int[]{1, 1, 0},
            new String[]{"iron", "iron", "iron", "iron", "diamond", "diamond", "diamond", "diamond",
                "diamond", "diamond"}));
    }
}
