package Lv1;

import java.util.Stack;

// 올바른 괄호
public class N12909 {
    public static boolean solution(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty() && s.charAt(i) == ')'){
                return false;
            }

            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }else{
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
    }
}
