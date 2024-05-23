package Lv2;

import java.util.Stack;

// 큰 수 만들기
public class N42883 {
    public static String solution(String number, int k) {
        int length = number.length() - k; // 최종 만들어야 하는 문자열 길이
        Stack<Character> stack = new Stack<>();
        /*
        현재 수가 스택의 맨 위의 수보다 크다면 스택의 맨 위를 제거한다.
        스택에 넣는다.
        k개 만큼 모두 제거했다면 나머지 수를 모두 넣는다.
         */
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() < c) {
                stack.pop();
                k--;
            }

            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().substring(0, length);
    }

    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));
    }
}
