package Lv1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// 숫자 짝꿍
public class N131128 {
    public static String solution(String X, String Y) {
        int[] arrX = new int[10]; // X 에 인덱스와 동일한 문자 확인 후 갯수 저장
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 숫자 저장 (큰 수부터 빼와야 함)
        Queue<Integer> queue0 = new LinkedList<>(); // 0 을 저장

        for (int i = 0; i < X.length(); i++) {
            char c = X.charAt(i);
            arrX[c - '0']++;
        }

        for (int i = 0; i < Y.length(); i++) {
            char c = Y.charAt(i);

            if (c - '0' == 0 && arrX[0] > 0) { // Y 의 문자가 0 이고 X 에도 0 이 있는 경우
                queue0.add(0);
                arrX[0]--; // 짝이 지어졌기 때문에 1 씩 빼준다.
            } else if (arrX[c - '0'] > 0) { // 0 이 아닌 다른 수인 경우
                pq.add(c - '0');
                arrX[c - '0']--; // 마찬가지로 짝이 지어졌기 때문에 1 씩 빼준다.
            }
        }

        StringBuffer sb = new StringBuffer();

        if (pq.isEmpty() && queue0.isEmpty()) { // 짝이 없는 경우
            return "-1";
        } else if (pq.isEmpty() && !queue0.isEmpty()) { // 숫자 0 만 짝이 존재하는 경우
            return "0";
        }

        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }

        while (!queue0.isEmpty()) {
            sb.append(queue0.poll());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("100", "2345"));
        System.out.println(solution("100", "203045"));
        System.out.println(solution("100", "123450"));
        System.out.println(solution("12321", "42531"));
        System.out.println(solution("5525", "1255"));
    }
}
