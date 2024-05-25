package Lv2;

import java.util.Arrays;

// 연속된 부분 수열의 합
public class N178870 {
    public static int[] solution(int[] sequence, int k) {
        int[] result = new int[2];
        int s = 0, e = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        /*
        1. 합이 k가 될때까지 더해간다.
        2. 만약 합이 k를 넘어간다면 맨 앞 인덱스 수를 빼고 그 이후 수부터의 합으로 k가 될때까지 구한다.
        3. 합이 k와 같을 때 가장 짧은 길이의 부분 수열을 업데이트한다.
         */
        for (; s < sequence.length; s++) {
            while (e < sequence.length && sum < k) { // 합이 k 이상이 될 때까지 반복
                sum += sequence[e++];
            }

            if (sum == k) { // 합이 k와 같을 때
                int curLen = e - s; // 현재 부분수열의 길이
                if (curLen < len) { // 가장 작은 길이의 부분수열이라면 업데이트한다.
                    len = curLen;
                    result[0] = s;
                    result[1] = e - 1;
                }
            }

            sum -= sequence[s]; // 맨 앞 인덱스의 수를 뺀다.
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5)));
        System.out.println(Arrays.toString(solution(new int[]{2, 2, 2, 2, 2}, 6)));
    }
}
