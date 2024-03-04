package Lv1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 명예의 전당 (1)
public class N138477 {
    public static int[] solution(int k, int[] score){
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        int[] result = new int[score.length];

        int idx = 0;
        for (int i : score) {
            if(queue.size() == k && queue.peek() < i){
                queue.poll();
                queue.add(i);
            }

            if(queue.size() < k){
                queue.add(i);
            }

            result[idx++] = queue.peek();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] score = {10, 100, 20, 150, 1, 100, 200};
        System.out.println(Arrays.toString(solution(3, score)));
    }
}
