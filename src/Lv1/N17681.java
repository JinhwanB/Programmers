package Lv1;

import java.util.Arrays;

// [1차] 비밀지도
// 비트연산자 문제
// 두 배열의 각 원소를 2진수로 변환하여 1은 벽("#"), 0은 빈칸(" ")
// 두 배열의 같은 위치의 수를 비교하여 각 자릿수를 비교
// 자릿수가 1이거나 0으로 같을 때 비밀지도의 해당 위치는 벽 또는 빈칸
// 다를 때는 무조건 벽
public class N17681 {
    public static String[] solution(int n, int[] arr1, int[] arr2){
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            String s = Integer.toBinaryString(arr1[i] | arr2[i]); // or연산자를 통해 1이 포함된 곳을 확인
            if(s.length() != n){
                s = String.format("%" + n + "s", s); // 자릿수 맞추기
            }

            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == '1') sb.append("#"); // 둘 중 하나라도 1이 나온 경우는 무조건 벽
                else sb.append(" "); // 0이라면 빈칸
            }

            result[i] = sb.toString();
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};
        System.out.println(Arrays.toString(solution(n, arr1, arr2)));
    }
}
