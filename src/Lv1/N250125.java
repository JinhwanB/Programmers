package Lv1;

// 이웃한 칸
public class N250125 {
    public static int solution(String[][] board, int h, int w) {
        int[] dx = {-1, 0, 1, 0}; // row 이동
        int[] dy = {0, -1, 0, 1}; // col 이동
        String color = board[h][w];

        int result = 0;
        for (int k = 0; k < dx.length; k++) {
            if (h + dy[k] >= 0 && w + dx[k] >= 0 && h + dy[k] < board.length && w + dx[k] < board[h].length && color.equals(board[h + dy[k]][w + dx[k]])) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}}, 1, 1));
        System.out.println(solution(new String[][]{{"yellow", "green", "blue"}, {"blue", "green", "yellow"}, {"yellow", "blue", "blue"}}, 0, 1));
    }
}
