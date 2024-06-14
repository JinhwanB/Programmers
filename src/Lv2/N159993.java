package Lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 미로 탈출
public class N159993 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static int solution(String[] maps) {
        char[][] board = new char[maps.length][maps[0].length()];
        int[] start = new int[2]; // 시작점
        int[] lever = new int[2]; // 레버 위치
        for (int i = 0; i < maps.length; i++) {
            String cur = maps[i];
            for (int j = 0; j < cur.length(); j++) {
                board[i][j] = cur.charAt(j);

                if (cur.charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                }

                if (cur.charAt(j) == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(start);

        int[][] visited = new int[board.length][board[0].length];
        for (int[] ints : visited) {
            Arrays.fill(ints, -1);
        }
        visited[start[0]][start[1]] = 0;

        int dL = bfs(q, board, visited, 'L'); // 레버까지의 최소 거리

        if (dL == 0) { // 레버에 도착하지 못했을 경우
            return -1;
        }

        q.clear();
        q.offer(lever);

        for (int[] ints : visited) {
            Arrays.fill(ints, -1);
        }

        visited[lever[0]][lever[1]] = 0;

        int dS = bfs(q, board, visited, 'E'); // 도착까지의 최소 거리

        return dS == 0 ? -1 : dL + dS; // 도착점에 도달하지 못하면 -1 리턴
    }

    // bfs로 target까지의 최소 거리를 구한다.
    private static int bfs(Queue<int[]> q, char[][] board, int[][] visited, char target) {
        int dist = 0;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int y = poll[0], x = poll[1];

            if (board[y][x] == target) {
                dist = visited[y][x];
                break;
            }

            for (int i = 0; i < dy.length; i++) {
                int Y = y + dy[i];
                int X = x + dx[i];

                if (Y < 0 || Y >= board.length || X < 0 || X >= board[0].length || board[Y][X] == 'X' || visited[Y][X] != -1) {
                    continue;
                }

                q.offer(new int[]{Y, X});
                visited[Y][X] = visited[y][x] + 1;
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"}));
        System.out.println(solution(new String[]{"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"}));
    }
}
