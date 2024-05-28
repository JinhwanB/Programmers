package Lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 전력망을 둘로 나누기
public class N8697 {
    static List<Integer>[] adjList;

    public static int solution(int n, int[][] wires) {
        adjList = new ArrayList[n + 1]; // 인접 리스트
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int s = wire[0], e = wire[1];
            adjList[s].add(e);
            adjList[e].add(s);
        }

        int result = Integer.MAX_VALUE;

        for (int[] wire : wires) { // 하나씩 연결을 끊어 본다. (완전탐색)
            boolean[] visited = new boolean[n + 1];

            int a = wire[0], b = wire[1]; // a와 b의 연결을 끊는다.
            visited[a] = true;
            visited[b] = true;

            int aNode = countNode(a, visited); // a노드부터 시작하는 노드의 수
            int bNode = countNode(b, visited); // b노드부터 시작하는 노드의 수
            int diff = Math.abs(aNode - bNode);

            result = Math.min(result, diff);
        }

        return result;
    }

    // bfs
    private static int countNode(int start, boolean[] visited) {
        int count = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int poll = q.poll();
            for (Integer i : adjList[poll]) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
        System.out.println(solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        System.out.println(solution(7, new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}));
    }
}
