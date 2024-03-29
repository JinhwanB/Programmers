package Lv1;

import java.util.Arrays;

// 바탕화면 정리
public class N161990 {
    public static int[] solution(String[] wallpaper) {
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = 0;
        int y2 = 0;
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                char c = wallpaper[i].charAt(j);
                if (c == '#') {
                    y1 = Math.min(i, y1);
                    x1 = Math.min(j, x1);
                    y2 = Math.max(i, y2);
                    x2 = Math.max(j, x2);
                }
            }
        }

        return new int[]{y1, x1, y2 + 1, x2 + 1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{".#...", "..#..", "...#."})));
        System.out.println(Arrays.toString(solution(new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."})));
        System.out.println(Arrays.toString(solution(new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."})));
        System.out.println(Arrays.toString(solution(new String[]{"..", "#."})));
    }
}
