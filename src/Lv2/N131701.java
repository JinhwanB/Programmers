package Lv2;

import java.util.HashSet;
import java.util.Set;

// 연속 부분 수열 합의 개수
public class N131701 {
    public static int solution(int[] elements){
        Set<Integer> set = new HashSet<>(); // 중복 수 제거
        for (int i = 1; i <= elements.length; i++) { // 길이가 1인 연속 수열부터 elements 크기만큼의 연속 수열
            for (int j = 0; j < elements.length; j++) {
                int sum = 0;
                for (int k = 0; k < i; k++) {
                    sum += elements[(j + k) % elements.length];
                }
                set.add(sum);
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{7,9,1,1,4}));
    }
}
