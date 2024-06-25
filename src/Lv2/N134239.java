package Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 우박수열 정적분
public class N134239 {

    public static double[] solution(int k, int[][] ranges) {
        List<Double> list = new ArrayList<>(); // 각 구간별 넓이
        int n = 0;
        while (k > 1) { // 우박수열을 구하면서 넓이도 함께 저장
            int p = k;
            if (k % 2 == 0) {
                k /= 2;
                double area = k + ((double) (p - k) / 2);
                list.add(area);
                n++;
                continue;
            }

            k = k * 3 + 1;
            double area = p + ((double) (k - p) / 2);
            list.add(area);
            n++;
        }

        double[] sum = sumOfArea(list); // 넓이의 누적합
        double[] result = new double[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            int[] cur = ranges[i];
            int a = cur[0], b = cur[1] + n;
            if (a > b) { // 시작 구간이 끝나는 구간보다 큰 경우
                result[i] = -1;
                continue;
            }

            if (a == 0) {
                result[i] = sum[b];
            } else {
                result[i] = sum[b] - sum[a];
            }
        }

        return result;
    }

    private static double[] sumOfArea(List<Double> list) {
        double[] answer = new double[list.size() + 1];
        answer[1] = list.get(0);
        for (int i = 2; i < answer.length; i++) {
            answer[i] += answer[i - 1] + list.get(i - 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(
            Arrays.toString(solution(5, new int[][]{{0, 0}, {0, -1}, {2, -3}, {3, -3}})));
        System.out.println(Arrays.toString(solution(3, new int[][]{{0, 0}, {1, -2}, {3, -3}})));
    }
}
