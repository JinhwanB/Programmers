package Lv2;

// 피로도
public class N87946 {
    static int max = 0;

    public static int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited);
        return max;
    }

    // 모든 경우를 탐색한다.
    public static void dfs(int k, int[][] dungeons, boolean[] visited) {
        int count = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                count++;
            }
        }

        if (count > max) {
            max = count;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                if (k >= dungeons[i][0]) {
                    k -= dungeons[i][1];
                    visited[i] = true;
                    dfs(k, dungeons, visited);
                    k += dungeons[i][1];
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }
}
