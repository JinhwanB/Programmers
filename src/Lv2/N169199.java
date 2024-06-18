package Lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 리코쳇 로봇
public class N169199 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static int solution(String[] board) {
        int[][] visited = new int[board.length][board[0].length()];
        for (int[] ints : visited) {
            Arrays.fill(ints, -1);
        }

        Queue<int[]> q = new LinkedList<>();
        loop:
        for (int i = 0; i < board.length; i++) {
            String s = board[i];
            for (int j = 0; j < s.length(); j++) {
                char cur = s.charAt(j);
                if (cur == 'R') {
                    q.offer(new int[]{i, j});
                    visited[i][j] = 0;
                    break loop;
                }
            }
        }

        int result = 0;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int y = poll[0], x = poll[1];
            if (board[y].charAt(x) == 'G') { // 도착지점에 도착한 경우
                result = visited[y][x];
                break;
            }

            for (int i = 0; i < dy.length; i++) {
                int Y = y + dy[i], X = x + dx[i];
                while (Y >= 0 && Y < board.length && X >= 0 && X < board[0].length() && board[Y].charAt(X) != 'D') { // 진행한 방향으로 쭉 미끄러진다.
                    Y += dy[i];
                    X += dx[i];
                    if (Y < 0 || Y >= board.length || X < 0 || X >= board[0].length() || board[Y].charAt(X) == 'D') { // 현재 board 범위를 벗어났거나 장애물인 경우 이전으로 이동시킨다.
                        Y -= dy[i];
                        X -= dx[i];
                        break;
                    }
                }

                if (Y < 0 || Y >= board.length || X < 0 || X >= board[0].length() || visited[Y][X] != -1 || board[Y].charAt(X) == 'D') {
                    // 최종 좌표가 board범위 밖이거나 이미 도착했던 지점이거나 장애물인 경우 넘긴다.
                    continue;
                }

                visited[Y][X] = visited[y][x] + 1;
                q.offer(new int[]{Y, X});
            }
        }

        return result == 0 ? -1 : result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
        System.out.println(solution(new String[]{".D.R", "....", ".G..", "...D"}));
    }
}
