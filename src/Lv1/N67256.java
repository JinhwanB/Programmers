package Lv1;

import java.util.HashMap;
import java.util.Map;

// 키패드 누르기
public class N67256 {
    static class Node {
        int y; // 키패드의 y 인덱스
        int x; // 키패드의 x 인덱스

        public Node(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        // 키패드를 2차원 배열로 생각하고 인덱스 설정
        Map<Integer, Node> map = new HashMap<>(); // 각 키패드별 인덱스를 저장
        int[] left = {3, 0}; // 왼손 시작 위치
        int[] right = {3, 2}; // 오른손 시작 위치
        int y = 0;
        int x = 0;
        for (int i = 0; i <= 9; i++) { // 각 키패드별 인덱스 저장
            if (i == 0) { // 0의 위치는 맨 아래에 있으므로 따로 저장한다.
                map.put(i, new Node(3, 1));
                continue;
            }

            if (x == 3) {
                y++;
                x = 0;
            }

            map.put(i, new Node(y, x++));
        }

        for (int number : numbers) {
            Node cur = map.get(number);
            if (number == 1 || number == 4 || number == 7) {
                left[0] = cur.y;
                left[1] = cur.x;
                sb.append("L");
            }

            if (number == 3 || number == 6 || number == 9) {
                right[0] = cur.y;
                right[1] = cur.x;
                sb.append("R");
            }

            if (number == 2 || number == 5 || number == 8 || number == 0) {
                int diffLeft = Math.abs(left[0] - cur.y) + Math.abs(left[1] - cur.x); // 왼손과 현재 키패드 위치의 차이
                int diffRight = Math.abs(right[0] - cur.y) + Math.abs(right[1] - cur.x); // 오른손과 현재 키패드 위치의 차이

                if (diffLeft == diffRight) { // 현재 키패드와 거리가 두 손 모두 같은 때
                    if (hand.equals("right")) { // 왼손잡이인지 오른손잡이인지 구별 후 이동
                        right[0] = cur.y;
                        right[1] = cur.x;
                        sb.append("R");
                    } else {
                        left[0] = cur.y;
                        left[1] = cur.x;
                        sb.append("L");
                    }
                } else if (Math.min(diffLeft, diffRight) == diffLeft) { // 왼손이 가까울 때
                    left[0] = cur.y;
                    left[1] = cur.x;
                    sb.append("L");
                } else { // 오른손이 가까울 때
                    right[0] = cur.y;
                    right[1] = cur.x;
                    sb.append("R");
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        System.out.println(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }
}
