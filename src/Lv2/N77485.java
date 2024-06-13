package Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 행렬 테두리 회전하기
public class N77485 {
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[][] board = new int[rows + 1][columns + 1];
        int num = 1;
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                board[i][j] = num++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int[] query : queries) {
            solve(query, board, result);
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static void solve(int[] query, int[][] board, List<Integer> result) {
        int y1 = query[0], x1 = query[1], y2 = query[2], x2 = query[3];

        int nextNum = board[y1][x1];
        int min = nextNum;
        // 직사각형 테두리의 ㄱ 자 부분과 ㄴ 자 부분으로 나누어 순환하며 숫자를 바꾼다.
        for (int i = y1; i < y2; i++) {
            if (i == y1) { // ㄱ 자 부분의 맨 윗줄 부분
                for (int j = x1; j < x2; j++) {
                    int tmp = nextNum;
                    nextNum = board[i][j + 1];
                    board[i][j + 1] = tmp;
                    min = Math.min(min, nextNum);
                }

                continue;
            }

            // ㄱ 자 부분의 맨 윗줄을 제외한 부분
            int tmp = nextNum;
            nextNum = board[i][x2];
            board[i][x2] = tmp;
            min = Math.min(min, nextNum);
        }

        for (int i = y2; i >= y1; i--) {
            if (i == y2) { // ㄴ 자 부분의 맨 아랫줄
                for (int j = x2; j >= x1; j--) {
                    int tmp = nextNum;
                    nextNum = board[i][j];
                    board[i][j] = tmp;
                    min = Math.min(min, nextNum);
                }

                continue;
            }

            // ㄴ 자 부분의 아랫줄을 제외한 부분
            // ㄱ 자 부분의 윗줄 처음 숫자는 바뀌어있지 않은 상태이므로 그 부분까지 진행해야함
            int tmp = nextNum;
            nextNum = board[i][x1];
            board[i][x1] = tmp;
            min = Math.min(min, nextNum);
        }

        result.add(min);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}})));
        System.out.println(Arrays.toString(solution(3, 3, new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}})));
        System.out.println(Arrays.toString(solution(100, 97, new int[][]{{1, 1, 100, 97}})));
    }
}
