package Lv2;

import java.util.Arrays;

// 가장 큰 정사각형 찾기
public class N12905 {

    public static int solution(int[][] board) {
        if (board.length == 1) { // board의 길이가 1인 경우
            int i = Arrays.stream(board[0]) // 1 인 수를 찾고 없으면 0
                .filter(x -> x == 1)
                .findFirst()
                .orElse(0);

            return i != 0 ? 1 : 0;
        }

        int max = 0;
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                int cur = board[i][j];
                if (cur == 1) {
                    board[i][j] =
                        Math.min(board[i][j - 1], Math.min(board[i - 1][j - 1], board[i - 1][j]))
                            + 1;
                    max = Math.max(max, board[i][j]);
                }
            }
        }

        return max * max;
    }

    public static void main(String[] args) {
        System.out.println(
            solution(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}}));
        System.out.println(solution(new int[][]{{0, 0, 1, 1}, {1, 1, 1, 1}}));
        System.out.println(solution(new int[][]{{0, 1}}));
    }
}
