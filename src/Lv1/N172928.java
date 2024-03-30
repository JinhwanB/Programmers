package Lv1;

import java.util.Arrays;

// 공원 산책
public class N172928 {
    public static int[] solution(String[] park, String[] routes) {
        // 시작 위치 구하기
        int[] start = new int[2];
        loop:
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    start = new int[]{i, j};
                    break loop;
                }
            }
        }

        // 이동
        for (String route : routes) {
            String[] cur = route.split(" ");
            String arrow = cur[0];
            int move = Integer.parseInt(cur[1]);

            if (arrow.equals("E")) {
                if (start[1] + move >= park[0].length()) {
                    continue;
                }

                int newIdx = -1;
                for (int i = 1; i <= move; i++) {
                    newIdx = start[1] + i;
                    if (park[start[0]].charAt(newIdx) == 'X') {
                        newIdx = -1;
                        break;
                    }
                }

                if (newIdx != -1) {
                    start = new int[]{start[0], newIdx};
                }
            }

            if (arrow.equals("W")) {
                if (start[1] - move < 0) {
                    continue;
                }

                int newIdx = -1;
                for (int i = 1; i <= move; i++) {
                    newIdx = start[1] - i;
                    if (park[start[0]].charAt(newIdx) == 'X') {
                        newIdx = -1;
                        break;
                    }
                }

                if (newIdx != -1) {
                    start = new int[]{start[0], newIdx};
                }
            }

            if (arrow.equals("N")) {
                if (start[0] - move < 0) {
                    continue;
                }

                int newIdx = -1;
                for (int i = 1; i <= move; i++) {
                    newIdx = start[0] - i;
                    if (park[newIdx].charAt(start[1]) == 'X') {
                        newIdx = -1;
                        break;
                    }
                }

                if (newIdx != -1) {
                    start = new int[]{newIdx, start[1]};
                }
            }

            if (arrow.equals("S")) {
                if (start[0] + move >= park[0].length()) {
                    continue;
                }

                int newIdx = -1;
                for (int i = 1; i <= move; i++) {
                    newIdx = start[0] + i;
                    if (park[newIdx].charAt(start[1]) == 'X') {
                        newIdx = -1;
                        break;
                    }
                }

                if (newIdx != -1) {
                    start = new int[]{newIdx, start[1]};
                }
            }
        }

        return start;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"SOO", "OOO", "OOO"}, new String[]{"E 2", "S 2", "W 1"})));
        System.out.println(Arrays.toString(solution(new String[]{"SOO", "OXX", "OOO"}, new String[]{"E 2", "S 2", "W 1"})));
        System.out.println(Arrays.toString(solution(new String[]{"OSO", "OOO", "OXO", "OOO"}, new String[]{"E 2", "S 3", "W 1"})));
    }
}
