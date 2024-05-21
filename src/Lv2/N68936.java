package Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 쿼드압축 후 개수 세기
public class N68936 {
    public static int[] solution(int[][] arr) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;
        solve(0, n, 0, n, arr, result);
        int zeroCount = 0;
        int oneCount = 0;
        for (Integer i : result) {
            if (i == 0) {
                zeroCount++;
            }

            if (i == 1) {
                oneCount++;
            }
        }

        return new int[]{zeroCount, oneCount};
    }

    // 1. 현재 정사각형 범위가 전부 같은 수인지 확인
    // 2. 같다면 해당 수를 result에 넣고 return
    // 3. 다르다면 현재 정사각형 범위에서 좌상단, 우상단, 좌하단, 우하단 범위를 나눠서 다시 탐색
    // 4. 위 과정 반복
    private static void solve(int x1, int x2, int y1, int y2, int[][] arr, List<Integer> result) {
        int num = arr[y1][x1]; // 현재 사각형 범위의 첫 수
        for (int i = y1; i < y2; i++) {
            for (int j = x1; j < x2; j++) {
                int cur = arr[i][j]; // 현재 수
                if (cur != num) { // 다를 시 4등분하여 탐색
                    solve(x1, x1 + (x2 - x1) / 2, y1, y1 + (y2 - y1) / 2, arr, result); // 좌상단
                    solve(x1 + (x2 - x1) / 2, x2, y1, y1 + (y2 - y1) / 2, arr, result); // 우상단
                    solve(x1, x1 + (x2 - x1) / 2, y1 + (y2 - y1) / 2, y2, arr, result); // 좌하단
                    solve(x1 + (x2 - x1) / 2, x2, y1 + (y2 - y1) / 2, y2, arr, result); // 우하단
                    return;
                }
            }
        }

        result.add(num);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})));
        System.out.println(Arrays.toString(solution(new int[][]{{1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1}})));
    }
}
