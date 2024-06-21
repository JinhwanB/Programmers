package Lv2;

import java.util.PriorityQueue;

// 디펜스 게임
public class N142085 {

    public static int solution(int n, int k, int[] enemy) {
        if (k >= enemy.length) { // 무적권이 라운드와 같거나 라운드보다 많은 경우
            return enemy.length;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) { // 먼저 무적권을 모두 사용한다.
            pq.add(enemy[i]);
        }

        // 그리디
        int fight = 0;
        for (int i = k; i < enemy.length; i++) {
            int curE = enemy[i]; // 현재 라운드의 적 수
            int min = pq.peek(); // 무적권 사용한 적 수 중 가장 작은 수
            if (curE > min) { // 현재 적이 무적권 사용한 최소의 적 수보다 많은 경우 현재 라운드를 무적권 사용하는 것으로 변경
                if (n - min < 0) { // 만약 현재 남은 병사로 무적권 사용한 최소의 적 처치가 안될 경우는 게임 종료
                    break;
                }

                int poll = pq.poll();
                pq.add((curE)); // 현재 적 무적권 사용
                n -= poll; // 이전에 무적권 사용했던 적을 처치
                fight++;
                continue;
            }

            if (n >= curE) { // 현재 적 수가 무적권 사용한 적 수보다 적은 경우이고 처치가 가능한 경우
                n -= curE;
                fight++;
                continue;
            }

            break; // 현재 적 수가 무적권 사용한 적 수보다 적은 경우이지만 처치가 불가능한 경우
        }

        return pq.size() + fight;
    }

    public static void main(String[] args) {
        System.out.println(solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1}));
        System.out.println(solution(2, 4, new int[]{3, 3, 3, 3}));
    }
}
