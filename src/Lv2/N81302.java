package Lv2;

import java.util.Arrays;

// 거리두기 확인하기
public class N81302 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static int[] solution(String[][] places) {
        int[] result = new int[places.length];

        loop:
        for (int i = 0; i < places.length; i++) {
            String[] place = places[i];
            char[][] board = new char[place.length][place[0].length()];
            boolean[][] visited = new boolean[board.length][board[0].length];
            for (int j = 0; j < place.length; j++) {
                for (int k = 0; k < place[j].length(); k++) {
                    board[j][k] = place[j].charAt(k);
                }
            }

            for (int j = 0; j < board.length; j++) {
                for (int k = 0; k < board[j].length; k++) {
                    char c = board[j][k];
                    if (c == 'P' && !visited[j][k]) { // 현재 확인하지 않은 P인 경우
                        visited[j][k] = true;

                        for (int l = 0; l < dy.length; l++) { // 상하좌우에 'O'가 있는 경우만 확인한다.
                            int y = j + dy[l];
                            int x = k + dx[l];
                            if (y < 0 || y >= board.length || x < 0 || x >= board[0].length || board[y][x] == 'X' || visited[y][x]) {
                                continue;
                            }

                            if (board[y][x] == 'P') { // 만약 P라면 거리두기 x
                                result[i] = 0;
                                continue loop;
                            }

                            if (isNearP(y, x, board, visited)) { // 'O'인 경우 해당 좌표에서 상하좌우에 P가 있는지 확인해서 있으면 거리두기 x
                                result[i] = 0;
                                continue loop;
                            }
                        }
                    }
                }
            }

            result[i] = 1;
        }

        return result;
    }

    // 좌표의 상하좌우에서 P가 존재하는지 확인
    private static boolean isNearP(int y, int x, char[][] board, boolean[][] visited) {
        for (int i = 0; i < dy.length; i++) {
            int Y = y + dy[i];
            int X = x + dx[i];

            if (Y < 0 || Y >= board.length || X < 0 || X >= board[0].length || visited[Y][X]) {
                continue;
            }

            if (board[Y][X] == 'P') {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}})));
    }
}
