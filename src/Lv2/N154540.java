package Lv2;

import java.util.*;

// 무인도 여행
public class N154540 {
    public static int[] solution(String[] maps) {
        char[][] charMaps = new char[maps.length][];
        for (int i = 0; i < maps.length; i++) {
            String map = maps[i];
            charMaps[i] = map.toCharArray();
        }

        boolean[][] visited = new boolean[charMaps.length][charMaps[0].length]; // 방문 체크 배열
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < charMaps.length; i++) {
            for (int j = 0; j < charMaps[i].length; j++) {
                char c = charMaps[i][j];

                if (!visited[i][j] && c != 'X') { // 방문하지 않은 곳이고 X가 아닌 경우
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    int count = solve(q, visited, charMaps); // 섬 주변 탐색하여 총 머물 수 있는 날짜 수 구함
                    result.add(count);
                    continue;
                }

                visited[i][j] = true;
            }
        }

        return result.isEmpty() ? new int[]{-1} : result.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    private static int solve(Queue<int[]> q, boolean[][] visited, char[][] charMaps) {
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        int count = 0;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int y = poll[0], x = poll[1];
            count += charMaps[y][x] - 48; // 해당 섬에 머물 수 있는 날짜 수 더함

            for (int i = 0; i < dy.length; i++) {
                int Y = y + dy[i];
                int X = x + dx[i];

                if (Y < 0 || Y >= charMaps.length || X < 0 || X >= charMaps[0].length) { // 상하좌우 이동하면서 범위 벗어나는 경우
                    continue;
                }

                if (!visited[Y][X] && charMaps[Y][X] != 'X') { // 방문하지 않은 곳이고 X가 아닌 경우
                    q.offer(new int[]{Y, X});
                    visited[Y][X] = true;
                    continue;
                }

                visited[Y][X] = true;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"})));
        System.out.println(Arrays.toString(solution(new String[]{"XXX", "XXX", "XXX"})));
    }
}
