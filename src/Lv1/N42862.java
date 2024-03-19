package Lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 체육복
public class N42862 {
    public static int solution(int n, int[] lost, int[] reserve) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : reserve) {
            map.put(i, 2);
        }

        Arrays.sort(lost);

        // 먼저 여벌 체육복이 있는 학생이 잃어버린 경우를 체크해준다.
        for (int i : lost) {
            map.put(i, map.getOrDefault(i, 1) - 1);
        }

        // 위에서 sort 하는 이유
        // 총 6명이고, 잃어버린 사람 5, 3 / 여벌이 있는 사람 6, 4 일 때
        // 5번을 먼저 확인하면 4번이 빌려주게 되고 3번은 체육복을 받지 못하는 상황이 온다.
        for (int i : lost) {
            if (map.get(i) == 1) { // 이미 체육복이 있다면 패스 -> 잃어버렸지만 여벌 체육복이 있던 경우
                continue;
            }

            if (i - 1 > 0 && map.getOrDefault(i - 1, 1) == 2) {
                map.put(i - 1, 1);
                map.put(i, 1);
            } else if (i + 1 <= n && map.getOrDefault(i + 1, 1) == 2) {
                map.put(i + 1, 1);
                map.put(i, 1);
            }
        }

        int total = n;
        for (Integer integer : map.keySet()) {
            if (map.get(integer) == 0) total--;
        }

        return total;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
        System.out.println(solution(5, new int[]{2, 4}, new int[]{3}));
        System.out.println(solution(5, new int[]{2, 3}, new int[]{3, 4}));
    }
}
