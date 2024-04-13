package Lv2;

import java.util.Stack;

// 괄호 회전하기
public class N76502 {
    public static int solution(String s) {
        String[] split = s.split("");
        int cnt = 0; // 올바른 괄호 수
        boolean flag = false;
        for (int i = 0; i < split.length; i++) { // 문자열 회전 횟수
            Stack<String> stack = new Stack<>(); // 올바른 괄호 판별
            for (int j = 0; j < split.length; j++) {
                String cur = split[(j + i) % split.length];
                if (cur.equals("{") || cur.equals("(") || cur.equals("[")) {
                    if (cur.equals("{")) stack.add("}");
                    else if (cur.equals("(")) stack.add(")");
                    else stack.add("]");
                } else {
                    if (stack.isEmpty() || !stack.peek().equals(cur)) {
                        flag = false;
                        break;
                    }

                    stack.pop();
                    flag = true;
                }
            }

            if (stack.isEmpty() && flag) { // 스택이 비어있다고 무조건 올바른 괄호는 아님(때문에 boolean변수를 사용)
                cnt++;
                flag = false;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
        System.out.println(solution("}]()[{"));
        System.out.println(solution("[)(]"));
        System.out.println(solution("}}}"));
    }
}
