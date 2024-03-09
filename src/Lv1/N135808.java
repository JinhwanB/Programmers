package Lv1;

import java.util.Arrays;

// 과일 장수
public class N135808 {
    public static int solution(int k, int m, int[] score) {
        if (score.length < m) {
            return 0;
        }

        Arrays.sort(score);

        int idx = score.length - 1;
        int income = 0;
        while (true) {
            if (idx < m - 1) { // m개 만큼 담을 수가 없다.
                break;
            }

            income += score[idx - m + 1] * m;
            idx -= m;
        }

        return income;
    }

    public static void main(String[] args) {
        int[] score = {1, 2, 3, 1, 2, 3, 1};
        System.out.println(solution(3, 4, score));
    }
}
