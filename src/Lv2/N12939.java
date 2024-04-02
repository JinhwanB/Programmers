package Lv2;

import java.util.Arrays;

// 최댓값과 최솟값
public class N12939 {
    public static String solution(String s) {
        int[] split = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder sb = new StringBuilder();
        int max = Arrays.stream(split).max().getAsInt();
        int min = Arrays.stream(split).min().getAsInt();
        sb.append(min).append(" ").append(max);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("1 2 3 4"));
        System.out.println(solution("-1 -2 -3 -4"));
        System.out.println(solution("-1 -1"));
    }
}
