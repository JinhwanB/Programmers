package Lv2;

import java.util.LinkedList;
import java.util.Queue;

// 예상 대진표
public class N12985 {
    public static int solution(int n, int a, int b) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        int cnt = 0; // 경기 수
        int total = n / 2; // 한 라운드의 경기 수
        int round = 1; // 라운드 수
        while (!q.isEmpty()) {
            if (cnt == total) { // 한 라운드에 진행할 경기 수를 만족한 경우
                cnt = 0; // 경기 수 초기화
                total = q.size() / 2; // 다음 라운드의 경기 수
                round++; // 라운드 증가
            }

            int cur = q.poll();
            int next = q.peek();
            if ((cur == a || cur == b) && (next == a || next == b)) { // a와 b가 만나는 경우
                break;
            }

            if (cur == a || cur == b) {
                q.add(cur);
                q.poll();
            } else if (next == a || next == b) { // a또는 b라면 무조건 승리
                q.add(q.poll());
            } else { // 아닌 경우
                q.add(cur);
                q.poll();
            }

            cnt++;
        }

        return round;
    }

    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7));
    }
}
