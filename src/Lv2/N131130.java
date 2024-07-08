package Lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 혼자 놀기의 달인
public class N131130 {

    static PriorityQueue<Integer> result; // 가장 상자가 많은 경우가 1번과 2번 그룹에 있어야 하므로 우선순위 큐를 이용
    static boolean[] visited; // 이미 열어본 상자 체크 배열

    public static int solution(int[] cards) {
        result = new PriorityQueue<>((o1, o2) -> o2 - o1);
        visited = new boolean[cards.length];

        for (int i = 0; i < cards.length; i++) {
            findGroup(i, cards, new ArrayList<>());
        }

        return result.size() <= 1 ? 0 : result.poll() * result.poll();
    }

    private static void findGroup(int s, int[] cards, List<Integer> list) {
        if (visited[s]) { // 이미 열어본 상자라면 종료
            result.add(list.size());
            return;
        }

        list.add(cards[s]);
        visited[s] = true;
        findGroup(cards[s] - 1, cards, list);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{8, 6, 3, 7, 2, 5, 1, 4}));
    }
}
