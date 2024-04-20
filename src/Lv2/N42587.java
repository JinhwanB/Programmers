package Lv2;

import java.util.*;

// 프로세스
public class N42587 {
    static class Process {
        int idx;
        int priority;

        public Process(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }

    public static int solution(int[] priorities, int location) {
        List<Integer> list = new ArrayList<>(); // 우선순위를 담을 리스트
        Map<Integer, Integer> map = new HashMap<>(); // key: 우선순위, value: 작업할 갯수
        Queue<Process> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            int priority = priorities[i];
            q.offer(new Process(i, priority));
            map.put(priority, map.getOrDefault(priority, 0) + 1);

            if (!list.contains(priority)) { // 우선순위를 중복을 제거하고 담는다.
                list.add(priority);
            }
        }
        list.sort(Comparator.reverseOrder()); // 우선순위가 큰 순으로 나열한다.

        int index = 0; // 현재 가장 먼저 처리되어야할 우선순위의 인덱스
        int curPriority = 1; // 현재 처리 순서
        while (!q.isEmpty()) {
            Process cur = q.poll();
            if (cur.priority == list.get(index)) { // 현재 우선순위가 먼저 처리해야할 순위일 때
                if (cur.idx == location) { // 문제에서 찾고하는 위치라면 break
                    break;
                }

                if (map.get(list.get(index)) == 1) { // map에 해당 우선순위가 1이라면 이 우선순위가 끝난뒤에는 다른 우선순위를 확인해야 하므로 지운다.
                    map.remove(list.get(index));
                    index++;
                } else { // 1이 아니라면 1씩 뺀다.
                    map.put(list.get(index), map.get(list.get(index)) - 1);
                }
                curPriority++;
            } else { // 먼저 처리해야할 우선순위가 아니라면 다시 큐에 넣는다.
                q.offer(cur);
            }
        }

        return curPriority;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }
}
