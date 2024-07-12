package Lv2;

import java.util.Comparator;
import java.util.PriorityQueue;

// 요격 시스템
public class N181188 {

    public static int solution(int[][] targets) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(o -> o[1])); // 끝 점을 기준으로 정렬한다.
        for (int[] target : targets) {
            pq.offer(target);
        }

        int fire = 0; // 요격할 미사일의 위치
        int count = 0; // 요격 미사일 발사 횟수
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int s = poll[0], e = poll[1];

            if (s >= fire) { // 현재 위치에서 요격할 수 없는 경우
                count++;
                fire = e;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(
            solution(new int[][]{{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}}));
    }
}
