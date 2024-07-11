package Lv2;

import java.util.Arrays;

// 혼자서 하는 틱택토
public class N160585 {

    public static int solution(String[] board) {
        long oCnt = Arrays.stream(board)
            .flatMapToInt(String::chars).filter(c -> c == 'O').count(); // O의 갯수
        long xCnt = Arrays.stream(board).flatMapToInt(String::chars).filter(c -> c == 'X')
            .count(); // X의 갯수

        if (xCnt > oCnt) { // X가 O보다 많은 경우
            return 0;
        }
        if (oCnt - xCnt > 1) { // O가 X보다 2개 이상 많은 경우
            return 0;
        }

        // O가 이기고 O와 X의 갯수가 같은 경우
        if (isWin(board, 'O') && oCnt == xCnt) {
            return 0;
        }

        // X가 이기고 O가 X보다 많은 경우
        if (isWin(board, 'X') && oCnt > xCnt) {
            return 0;
        }

        return 1;
    }

    private static boolean isWin(String[] board, char c) {
        for (String s : board) { // 가로 검사
            if (s.charAt(0) == c && s.charAt(1) == c && s.charAt(2) == c) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) { // 세로 검사
            if (board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c) {
                return true;
            }
        }

        // 대각선 검사
        if (board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) {
            return true;
        }

        if (board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"O.X", ".O.", "..X"}));
        System.out.println(solution(new String[]{"OOO", "...", "XXX"}));
        System.out.println(solution(new String[]{"...", ".X.", "..."}));
        System.out.println(solution(new String[]{"...", "...", "..."}));
        System.out.println(solution(new String[]{"XXO", ".OX", "O.."}));
    }
}
