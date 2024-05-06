package Lv2;

import java.util.PriorityQueue;

// 더 맵게
public class N42626 {
    public static int solution(int[] scoville, int K) {
        PriorityQueue<Long> pq = new PriorityQueue<>(); // 우선순위 큐를 이용하여 가장 작은 수와 두번째로 작은 수를 뽑는다.
        for (int i = 0; i < scoville.length; i++) {
            pq.add((long) scoville[i]);
        }

        int count = 0;
        while (pq.peek() < K) { // 가장 작은 수가 K보다 크거나 같을 때까지 반복(가장 작은 수가 K보다 크거나 같아진다면 나머지는 자연스럽게 K보다 크거나 같아진다.)
            if (pq.size() == 1) { // 1개 남았다면 이후에 더 진행이 불가하다.
                return -1;
            }

            long cur = pq.poll();
            long next = pq.poll();
            if (cur == 0 && next == 0 && K > 0) { // 둘 다 0이라면 공식을 통해 아무리 진행해도 0을 넘지 못한다.
                return -1;
            }

            long newNum = cur + next * 2;
            pq.add(newNum);
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }
}
