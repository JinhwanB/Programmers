package Lv1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// 숫자 짝꿍
public class N131128 {
    public static String solution(String X, String Y) {
        int[] arrX = new int[10];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> queue0 = new LinkedList<>();

        for (int i = 0; i < X.length(); i++) {
            char c = X.charAt(i);
            arrX[c - '0']++;
        }

        for (int i = 0; i < Y.length(); i++) {
            char c = Y.charAt(i);

            if (c - '0' == 0 && arrX[0] > 0) {
                queue0.add(0);
                arrX[0]--;
            } else if (arrX[c - '0'] > 0) {
                pq.add(c - '0');
                arrX[c - '0']--;
            }
        }

        StringBuffer sb = new StringBuffer();

        if (pq.isEmpty() && queue0.isEmpty()) {
            return "-1";
        } else if (pq.isEmpty() && !queue0.isEmpty()) {
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
