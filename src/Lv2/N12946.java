package Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 하노이의 탑
public class N12946 {

    static List<int[]> list;

    public static int[][] solution(int n) {
        list = new ArrayList<>();
        solve(1, 3, 2, n);
        int[][] result = new int[list.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    private static void solve(int s, int e, int mid, int n) {
        if (n == 1) {
            list.add(new int[]{s, e});
            return;
        }

        solve(s, mid, e, n - 1); // n-1개의 원판을 s 기둥에서 mid 기둥으로 e 를 통해 이동
        list.add(new int[]{s, e}); // 가장 작은 원판을 첫 기둥에서 e로 이동
        solve(mid, e, s, n - 1); // n-1개의 원판을 mid 기둥에서 e 기둥으로 s 를 통해 이동
    }

    public static void main(String[] args) {
        int[][] solution = solution(2);
        for (int[] ints : solution) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
