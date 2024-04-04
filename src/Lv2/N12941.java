package Lv2;

import java.util.Arrays;

// 최솟값 만들기
public class N12941 {
    public static int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int idx = B.length - 1;
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            result += (A[i] * B[idx--]);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
        System.out.println(solution(new int[]{1, 2}, new int[]{3, 4}));
    }
}
