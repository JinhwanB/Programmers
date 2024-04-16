package Lv2;

import java.util.Arrays;

// 행렬의 곱셈
public class N12949 {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] result = new int[arr1.length][arr2[0].length];
        // result[i][j]는 arr1의 i행과 arr2의 j열의 곱의 합이다.
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                int sum = 0;
                for (int k = 0; k < arr1[0].length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                result[i][j] = sum;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arr = solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}});
        for (int[] ints : arr) {
            System.out.print(Arrays.toString(ints) + " ");
        }
        System.out.println();

        arr = solution(new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}, new int[][]{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}});
        for (int[] ints : arr) {
            System.out.print(Arrays.toString(ints) + " ");
        }
        System.out.println();

        arr = solution(new int[][]{{1, 2}, {2, 1}}, new int[][]{{1, 1, 1, 1}, {2, 2, 2, 2}});
        for (int[] ints : arr) {
            System.out.print(Arrays.toString(ints) + " ");
        }
        System.out.println();

        arr = solution(new int[][]{{1, 2, 3}, {3, 2, 1}}, new int[][]{{1, 2}, {2, 1}, {1, 2}});
        for (int[] ints : arr) {
            System.out.print(Arrays.toString(ints) + " ");
        }
    }
}
