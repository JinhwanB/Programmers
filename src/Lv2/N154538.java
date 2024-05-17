package Lv2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// 숫자 변환하기
public class N154538 {
    public static int solution(int x, int y, int n) {
        if (x == y) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        set.add(x);
        int count = 0;
        boolean flag = false;
        loop:
        while (!q.isEmpty()) {
            int length = q.size();
            for (int i = 0; i < length; i++) {
                int cur = q.poll();
                if (cur == y) {
                    flag = true;
                    break loop;
                }

                if (cur > y) {
                    continue;
                }

                // 한 번 나왔던 수를 다시 계산하는 경우 방지
                if (set.add(cur * 3)) {
                    q.add(cur * 3);
                }

                if (set.add(cur * 2)) {
                    q.add(cur * 2);
                }

                if (set.add(cur + n)) {
                    q.add(cur + n);
                }
            }

            count++;
        }

        return !flag ? -1 : count;
    }

    public static void main(String[] args) {
        System.out.println(solution(10, 40, 5));
        System.out.println(solution(10, 40, 30));
        System.out.println(solution(2, 5, 4));
    }
}
