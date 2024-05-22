package Lv2;

import java.util.LinkedList;
import java.util.Queue;

// 두 큐 합 같게 만들기
public class N118667 {
    public static int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int i : queue1) {
            q1.add(i);
            sum1 += i;
        }

        for (int i : queue2) {
            q2.add(i);
            sum2 += i;
        }

        if ((sum1 + sum2) % 2 == 1) { // 모든 수의 합이 홀수라면 두 큐의 합이 같을 수가 없음
            return -1;
        }

        if (sum1 == sum2) { // 이미 두 큐의 합이 같다면 작업 불필요
            return 0;
        }

        int count = 0;
        while (sum1 != sum2) {
            if (q1.isEmpty() || q2.isEmpty()) { // 두 큐의 합이 같아질 수 없는 경우
                return -1;
            }

            if (count > queue1.length * 3) { // 무한루프 방지
                return -1;
            }

            // 큐의 합이 큰 쪽에서 빼서 작은 쪽에 넣는다.
            if (sum1 > sum2) {
                int poll = q1.poll();
                q2.add(poll);
                sum1 -= poll;
                sum2 += poll;
            } else {
                int poll = q2.poll();
                q1.add(poll);
                sum1 += poll;
                sum2 -= poll;
            }

            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
        System.out.println(solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2}));
        System.out.println(solution(new int[]{1, 1}, new int[]{1, 5}));
    }
}
