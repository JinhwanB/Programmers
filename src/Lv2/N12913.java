package Lv2;

import java.util.Arrays;

// 땅따먹기
public class N12913 {
    public static int solution(int[][] land) {
        int[][] dp = new int[land.length][land[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0) {
                    dp[i][j] = land[i][j];
                    continue;
                }

                /*
                전 행에서 올 수 있는 경우 중 가장 최댓값을 저장해나간다.
                 */
                int cur = land[i][j]; // 현재 땅의 점수
                for (int k = 0; k < 4; k++) {
                    if (k != j) { // 같은 열은 제외
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + cur); // 전 행의 땅의 점수와 현재 땅의 점수를 합한 경우의 max 값을 찾는다.
                    }
                }
            }
        }

        return Arrays.stream(dp[land.length - 1]).max().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}}));
    }
}
