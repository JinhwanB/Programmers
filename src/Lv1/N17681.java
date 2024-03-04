package Lv1;

import java.util.Arrays;

// [1차] 비밀지도
public class N17681 {
    public static String[] solution(int n, int[] arr1, int[] arr2){
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            String s = Integer.toBinaryString(arr1[i] | arr2[i]);
            if(s.length() != n){
                s = String.format("%" + n + "s", s);
            }

            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == '1') sb.append("#");
                else sb.append(" ");
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
