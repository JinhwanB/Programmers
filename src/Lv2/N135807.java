package Lv2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 숫자 카드 나누기
public class N135807 {
    public static int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        PriorityQueue<Integer> result = new PriorityQueue<>(Comparator.reverseOrder()); // 문제에 부합하는 결과를 저장하고 가장 큰 수가 먼저 나온다.

        solve(arrayA, arrayB, new PriorityQueue<>(Comparator.reverseOrder()), result); // A배열을 모두 나눌 수 있고 B배열을 나눌 수 없는 경우 구함
        solve(arrayB, arrayA, new PriorityQueue<>(Comparator.reverseOrder()), result); // B배열을 모두 나눌 수 있고 A배열을 나눌 수 없는 경우 구함

        if (result.isEmpty()) { // result가 비어있을 때
            return 0;
        }

        return result.poll();
    }

    private static void solve(int[] arrayA, int[] arrayB, PriorityQueue<Integer> pq, PriorityQueue<Integer> result) {
        loop:
        for (int i = arrayA[0]; i > 1; i--) {
            if (!result.isEmpty() && result.peek() > i) { // result에 저장된 값이 있고 가장 큰 값보다 이미 현재 비교할 값이 작은 경우는 반복문 탈출
                break;
            }

            for (int a : arrayA) {
                if (a % i != 0) { // 나누어지지 않는 경우 continue
                    continue loop;
                }
            }

            pq.add(i);
        }

        while (!pq.isEmpty()) {
            int cur = pq.poll();

            boolean isSuccess = true;
            for (int i : arrayB) {
                if (i % cur == 0) { // 나누어지지 않는지 확인
                    isSuccess = false;
                    break;
                }
            }

            if (isSuccess) { // 나누어지지 않았다면 result에 저장
                result.add(cur);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 17}, new int[]{5, 20}));
        System.out.println(solution(new int[]{10, 20}, new int[]{5, 17}));
        System.out.println(solution(new int[]{14, 35, 119}, new int[]{18, 30, 102}));
    }
}
