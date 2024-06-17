package Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 테이블 해시 함수
public class N147354 {
    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        List<int[]> list = new ArrayList<>(Arrays.asList(data));
        list.sort((o1, o2) -> {
            int idx = col - 1;
            if (o1[idx] == o2[idx]) {
                return o2[0] - o1[0];
            }

            return o1[idx] - o2[idx];
        });

        int result = 0;
        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int[] cur = list.get(i);
            int num = 0;
            for (int val : cur) {
                num += val % (i + 1);
            }

            result ^= num;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}}, 2, 2, 3));
    }
}
