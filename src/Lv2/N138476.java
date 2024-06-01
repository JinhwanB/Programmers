package Lv2;

import java.util.Arrays;
import java.util.PriorityQueue;

// 귤 고르기
public class N138476 {
    public static int solution(int k, int[] tangerine) {
        if (k == 1) { // 1개만 담는 경우 귤은 무조건 1가지 이상은 있으므로 1을 리턴
            return 1;
        }

        // 귤의 종류별 갯수를 저장하고 가장 많은 갯수의 귤부터 담는다. -> 가장 적은 종류로 담는 방법
        Arrays.sort(tangerine);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        int cur = tangerine[0];
        int count = 1;
        for (int i = 1; i < tangerine.length; i++) {
            int value = tangerine[i];
            if (cur != value) {
                pq.offer(new int[]{cur, count});
                cur = value;
                count = 1;

                if (i == tangerine.length - 1) {
                    pq.offer(new int[]{cur, count});
                }

                continue;
            }

            count++;

            if (i == tangerine.length - 1) {
                pq.offer(new int[]{cur, count});
            }
        }

        int result = 0;
        while (k > 0 && !pq.isEmpty()) {
            int[] poll = pq.poll();
            int sizeCount = poll[1];

            result++;
            k -= sizeCount;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
        System.out.println(solution(2, new int[]{1000, 2000, 2000, 1000}));
    }
}
