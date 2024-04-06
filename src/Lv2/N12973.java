package Lv2;

import java.util.Stack;

// 짝지어 제거하기
public class N12973 {
    public static int solution(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(!stack.isEmpty()){ // 스택이 비어있지 않을 때
                if(stack.peek() == s.charAt(i)){ // 같은 단어가 이미 들어가 있다면 제거
                    stack.pop();
                }else{ // 없다면 추가
                    stack.push(s.charAt(i));
                }
            }else{ // 스택이 비어있다면 추가
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));
    }
}
