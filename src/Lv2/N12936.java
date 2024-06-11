package Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 줄 서는 방법
public class N12936 {
    public static int[] solution(int n, long k) {
        List<Integer> list = new ArrayList<>();
        long factorial = 1; // 줄을 세우는 전체 경우의 수
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            list.add(i);
        }

        int[] result = new int[n];
        k--; // 인덱스 계산을 위함
        int idx = 0;
        while (n > 0) {
            factorial /= n; // 현재 자릿수가 바뀌는 turn = 다음 자릿수의 경우의 수
            int index = (int) (k / factorial); // 현재 자릿수의 인덱스
            result[idx++] = list.remove(index);

            k %= factorial; // 다음 자릿수의 k
            n--;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 5)));
    }
}
