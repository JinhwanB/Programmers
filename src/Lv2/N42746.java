package Lv2;

import java.util.PriorityQueue;

// 가장 큰 수
public class N42746 {
    public static String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            String s1 = String.valueOf(o1);
            String s2 = String.valueOf(o2);
            return Integer.parseInt(s2 + s1) - Integer.parseInt(s1 + s2); // 두 수를 문자열로 합한 결과와 거꾸로 문자열로 합한 결과 중 큰 결과를 우선순위로 갖는다.
        });
        for (int number : numbers) {
            pq.add(number);
        }

        int zeroCount = 0;
        while (!pq.isEmpty()) {
            if (pq.peek() == 0) {
                zeroCount++;
            }

            sb.append(pq.poll());
        }

        // numbers에 모두 0이 들어있는 경우 "0"을 반환
        return zeroCount == numbers.length ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 10, 2}));
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));
    }
}
