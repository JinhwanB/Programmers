package Lv2;

import java.util.Arrays;

// N개의 최소공배수
public class N12953 {
    public static int solution(int[] arr) {
        Arrays.sort(arr);
        int maxNum = arr[arr.length - 1]; // arr배열 안의 수들의 최소공배수는 가장 큰 수의 배수 중 하나
        int value = 2;
        boolean flag = false; // 최소공배수가 되는지 판별
        while (true) {
            for (int i = 0; i < arr.length - 1; i++) { // 가장 큰 수를 제외한 나머지 수들로 가장 큰 수의 배수를 나눌 때
                if (maxNum % arr[i] == 0) { // 나누어 떨어진다면 공배수
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }

            if (!flag) {
                maxNum = arr[arr.length - 1] * value++;
            } else {
                break;
            }
        }

        return maxNum;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 6, 8, 14}));
        System.out.println(solution(new int[]{1, 2, 3}));
    }
}
