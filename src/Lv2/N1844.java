package Lv2;

import java.util.LinkedList;
import java.util.Queue;

// 게임 맵 최단거리
public class N1844 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        solve(0, 0, maps, visited);

        return maps[maps.length - 1][maps[0].length - 1] == 1 ? -1 : maps[maps.length - 1][maps[0].length - 1]; // 최종 목적지가 1인 경우 목적지에 도달 x, 아닌 경우 이동 횟수 출력
    }

    private static void solve(int y, int x, int[][] maps, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for (int i = 0; i < dx.length; i++) {
                int curY = poll[0] + dy[i];
                int curX = poll[1] + dx[i];
                if (curY >= 0 && curY < maps.length && curX >= 0 && curX < maps[0].length && maps[curY][curX] == 1 && !visited[curY][curX]) { // 이동 가능한 경우
                    q.add(new int[]{curY, curX}); // 큐에 저장
                    maps[curY][curX] = maps[poll[0]][poll[1]] + 1; // 이동 횟수를 이동한 칸에 저장
                    visited[curY][curX] = true; // 이미 이동한 칸에 대한 처리
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
        System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}));
    }
}
