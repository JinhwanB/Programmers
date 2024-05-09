package Lv2;

import java.util.Arrays;
import java.util.Stack;

// 뒤에 있는 큰 수 찾기
public class N154539 {
    public static int[] solution(int[] numbers) {
        int[] result = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(result, -1);
        for (int i = numbers.length - 1; i >= 0; i--) {
            int cur = numbers[i];
            while (!stack.isEmpty() && stack.peek() <= cur) { // 뒷 수들 중 현재보다 작거나 같은 수는 찾음 없다면 pop
                stack.pop();
            }

            if (!stack.isEmpty()) { // 스택이 비어있지 않다면 큰 수를 찾은 경우이므로 result배열에 추가
                result[i] = stack.peek();
            }

            stack.add(cur); // 뒷 수들을 스택에 저장
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 3, 3, 5})));
        System.out.println(Arrays.toString(solution(new int[]{9, 1, 5, 3, 6, 2})));
        System.out.println(Arrays.toString(solution(new int[]{8, 1, 2, 9})));
    }
}
