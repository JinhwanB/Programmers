package Lv2;

import java.util.*;

// 기능 개발
public class N42586 {
    public static int[] solution(int[] progresses, int[] speeds) {
        Map<Integer, List<Integer>> map = new HashMap<>(); // key: 배포되는 날짜, value: 배포된 기능 리스트
        int idx = 0;
        int day = 0; // 맨 앞 기능이 배포되기까지 걸리는 날짜
        while (idx != progresses.length) {
            int cur = progresses[idx] + speeds[idx] * day; // 현재 기능의 진행도
            if (cur < 100) { // 현재 기능이 100%가 아니라면
                day = (100 - progresses[idx]) % speeds[idx] != 0 ? (100 - progresses[idx]) / speeds[idx] + 1 : (100 - progresses[idx]) / speeds[idx];
            }

            List<Integer> dayList = map.getOrDefault(day, new ArrayList<>());
            dayList.add(idx);
            map.put(day, dayList);

            idx++;
        }

        List<Integer> keyList = new ArrayList<>(map.keySet());
        int[] result = new int[keyList.size()];
        keyList.sort(Comparator.naturalOrder()); // map의 keySet을 오름차순으로 정렬
        for (int i = 0; i < result.length; i++) {
            result[i] = map.get(keyList.get(i)).size();
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
        System.out.println(Arrays.toString(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
        System.out.println(Arrays.toString(solution(new int[]{1, 95, 95, 95}, new int[]{99, 1, 1, 1})));
    }
}
