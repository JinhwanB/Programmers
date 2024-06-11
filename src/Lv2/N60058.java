package Lv2;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

// 괄호 변환
public class N60058 {

    static Set<String> set;

    public static String solution(String p) {
        set = new HashSet<>();
        set.add("");

        if (isRight(p)) {
            return p;
        }

        return solve(p);
    }

    // u와 v 두 개의 문자열로 나누어 푸는 과정
    private static String solve(String s) {
        String u = "";
        String v = "";
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') count1++;
            if (c == ')') count2++;

            // u 와 v를 분리한다. 괄호의 갯수가 같아지는 시점부터 두 단어로 나누면 된다.
            if ((count1 != 0 && count2 != 0) && count1 == count2) {
                u = s.substring(0, i + 1);
                v = s.substring(i + 1);
                break;
            }
        }

        if ((set.contains(u) || isRight(u)) && (set.contains(v) || isRight(v))) { // 전부 올바른 괄호 문자열인 경우
            return u + v;
        } else if (set.contains(u) || isRight(u)) { // u가 올바른 문자열인 경우
            v = solve(v);
        } else { // u가 올바른 문자열이 아닌 경우
            StringBuilder sb = new StringBuilder();
            sb.append("(");

            if (!(set.contains(v) || isRight(v))) { // v를 처음부터 다시 재귀적으로 확인
                v = solve(v);
            }

            u = reverse(u.substring(1, u.length() - 1)); // u의 처음 문자와 마지막 문자 제거 -> 문자열 괄호 뒤집기

            sb.append(v).append(")").append(u);

            return sb.toString();
        }

        return u + v;
    }

    // 문자열의 괄호 뒤집기
    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                sb.append(")");
            } else sb.append("(");
        }

        return sb.toString();
    }

    // 올바른 괄호 문자열 판별
    private static boolean isRight(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!stack.isEmpty() && c == ')') {
                stack.pop();
                continue;
            }

            if (c == ')') {
                return false;
            }

            stack.push(c);
        }

        set.add(s);
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(solution("(()())()"));
        System.out.println(solution(")("));
        System.out.println(solution("()))((()"));
    }
}
