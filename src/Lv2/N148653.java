package Lv2;

import java.util.LinkedList;
import java.util.Queue;

// 마법의 엘리베이터
public class N148653 {
    static boolean isPlus = false; // 자릿수를 올림해야 하는 경우

    public static int solution(int storey) {
        char[] number = String.valueOf(storey).toCharArray();
        Queue<Character> q = new LinkedList<>();
        for (int i = number.length - 1; i >= 0; i--) {
            char c = number[i];
            q.add(c);
        }

        int count = 0;
        while (!q.isEmpty()) {
            char c = q.poll();
            if (isPlus) {
                if (c == '9') {
                    c = '0';
                } else {
                    c += 1;
                }
            }

            if (c == '0') {
                continue;
            }

            int minus = minus(c); // 뻬는 경우
            int plus = plus(c); // 더하는 경우

            isPlus = minus > plus; // 더하는 경우의 cost가 적다면 다음 자릿수를 올림해야 한다.
            if (minus == plus && !q.isEmpty()) { // 5의 경우 다음 자릿수를 올림하는 것이 더 좋은 판단인지 확인
                char next = q.peek();
                if (next >= '5') { // 다음 자릿수가 5 이상이라면 올림하는 것이 더 좋다.
                    isPlus = true;
                }
            }

            count += Math.min(minus, plus);
        }

        if (isPlus) { // 반복문 탈출 후 isPlus가 true라면 첫 자릿수에 1이 남아있다는 뜻(예: 90 -> 100이 되므로 -100을 한 번 더 진행해야 함)
            count += 1;
        }

        return count;
    }

    // 빼는 경우의 cost
    private static int minus(char c) {
        int count = 0;
        while (c != '0') {
            c--;
            count++;
        }

        return count;
    }

    // 더하는 경우의 cost
    private static int plus(char c) {
        int count = 0;
        while (c <= '9') {
            c++;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(16));
        System.out.println(solution(2554));
        System.out.println(solution(485));
    }
}
