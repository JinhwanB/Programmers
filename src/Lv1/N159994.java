package Lv1;

import java.util.LinkedList;
import java.util.Queue;

// 카드 뭉치
public class N159994 {
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> queue1 = new LinkedList<>(); // card1
        Queue<String> queue2 = new LinkedList<>(); // card2

        for (String s : cards1) {
            queue1.offer(s);
        }

        for (String s : cards2) {
            queue2.offer(s);
        }

        int idx = 0;
        while ((!queue1.isEmpty() || !queue2.isEmpty()) && idx < goal.length) {
            String peek = "";
            if (queue1.isEmpty()) { // card1의 단어를 모두 사용한 경우
                peek = queue2.peek();
                if (peek.equals(goal[idx])) {
                    queue2.poll();
                    idx++;
                } else {
                    return "No";
                }
            } else if (queue2.isEmpty()) { // card2의 단어를 모두 사용한 경우
                peek = queue1.peek();
                if (peek.equals(goal[idx])) {
                    queue1.poll();
                    idx++;
                } else {
                    return "No";
                }
            } else { // card1과 card2를 모두 사용할 수 있는 경우
                peek = queue1.peek(); // 먼저 card1에서 비교하고
                if (peek.equals(goal[idx])) {
                    queue1.poll();
                    idx++;
                    continue;
                } else { // card1의 단어가 맞지 않는 단어라면 card1에서 비교
                    peek = queue2.peek();
                    if (peek.equals(goal[idx])) {
                        queue2.poll();
                        idx++;
                        continue;
                    }
                }
                return "No";
            }
        }

        return "Yes";
    }

    public static void main(String[] args) {
        String[] cards1 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        String[] cards2 = {"string", "or", "integer"};
        String[] goal = {"string", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        System.out.println(solution(cards1, cards2, goal));
    }
}
