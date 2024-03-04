package Lv1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 명예의 전당 (1)
// 주어진 배열은 각 회차별 노래를 부른 참가자의 점수
// 각 회차별로 k 번째 순위까지 점수가 높은 순으로 명예의 전당에 기록
// 각 회차별 가장 낮은 점수를 담고 있는 배열 리턴
public class N138477 {
    public static int[] solution(int k, int[] score){
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }); // 우선순위 큐를 이용하여 오름차순으로 정렬

        int[] result = new int[score.length];

        int idx = 0;
        for (int i : score) {
            if(queue.size() == k && queue.peek() < i){ // k 번째 순위까지 모두 차있을 때 제일 낮은 점수가 현재 점수보다 작다면
                queue.poll(); // 큐의 가장 낮은 점수를 제거
                queue.add(i); // 현재 점수 추가
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
