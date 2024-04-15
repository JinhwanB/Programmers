package Lv2;

import java.util.Arrays;

// n^2 배열 자르기
public class N873390 {
    public static int[] solution(int n, long left, long right) {
        int[] arr = new int[(int) (right - left) + 1];
        int idx = 0;
        for (long i = left; i <= right; i++) {
            long firstNum = i / n + 1; // 해당 행의 첫 숫자
            long last = i % n; // 나머지
            if (firstNum > last) {
                arr[idx++] = (int) firstNum;
            } else {
                arr[idx++] = (int) (firstNum + (last - firstNum + 1));
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 2, 5)));
        System.out.println(Arrays.toString(solution(4, 7, 14)));
    }
}
