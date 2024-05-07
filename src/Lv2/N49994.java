package Lv2;

import java.util.HashSet;
import java.util.Set;

// 방문 길이
public class N49994 {
    public static int solution(String dirs) {
        Set<String> set = new HashSet<>(); // 중복 처리를 하여 이미 지나간 길은 다시 가지 않도록 처리
        int prevY = 0; // 움직이기 전 y
        int prevX = 0; // 움직이기 전 x
        int curY = 0; // 움직이고 난 후 y
        int curX = 0; // 움직이고 난 후 x
        for (int i = 0; i < dirs.length(); i++) {
            char command = dirs.charAt(i);
            if (command == 'U') {
                curY++;
                if (curY > 5) {
                    curY--;
                    continue;
                }
            } else if (command == 'D') {
                curY--;
                if (curY < -5) {
                    curY++;
                    continue;
                }
            } else if (command == 'L') {
                curX--;
                if (curX < -5) {
                    curX++;
                    continue;
                }
            } else {
                curX++;
                if (curX > 5) {
                    curX--;
                    continue;
                }
            }

            set.add(String.valueOf(prevY) + prevX + curY + curX); // 현재 이동("0010" -> {0, 0}에서 {1, 0}으로 이동함)
            set.add(String.valueOf(curY) + curX + prevY + prevX); // 반대의 경우도 이동한 경로는 같음 즉, {0, 0}에서 {1, 0}으로 간 경우와 {1, 0}에서 {0, 0}으로 이동한 것은 같은 경우로 카운팅이 되면 안됨
            prevY = curY;
            prevX = curX;
        }

        return set.size() / 2; // 위에서 반대의 경우까지 모두 넣어줬으므로 2로 나눠준다.
    }

    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
        System.out.println(solution("LULLLLLLU"));
        System.out.println(solution("UDLRDURL"));
    }
}
