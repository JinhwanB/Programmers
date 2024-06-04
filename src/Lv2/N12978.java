package Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// 배달
public class N12978 {
    public static int solution(int N, int[][] road, int K) {
        List<int[]>[] adjList = new ArrayList[N + 1]; // 인접리스트
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] ints : road) { // 양방향 그래프
            int s = ints[0], e = ints[1], cost = ints[2];
            adjList[s].add(new int[]{e, cost});
            adjList[e].add(new int[]{s, cost});
        }

        // 다익스트라
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int curNode = poll[0], curCost = poll[1];

            for (int[] ints : adjList[curNode]) { // 각 노드로 갈 수 있는 최소 시간을 구하여 업데이트
                int nextNode = ints[0], nextCost = ints[1];

                if (dist[nextNode] <= curCost + nextCost) { // 이미 현재 노드의 최소 시간이 최소인 경우
                    continue;
                }

                dist[nextNode] = curCost + nextCost;
                pq.offer(new int[]{nextNode, curCost + nextCost});
            }
        }

        return (int) Arrays.stream(dist)
                .filter(x -> x <= K)
                .count();
    }

    public static void main(String[] args) {
        System.out.println(solution(5, new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3));
        System.out.println(solution(6, new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}, 4));
    }
}
