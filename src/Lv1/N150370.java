package Lv1;

import java.util.*;

// 개인정보 수집 유효기간
public class N150370 {
    public static int[] solution(String today, String[] terms, String[] privacies) {
        // 현재 날짜를 년 월 일을 28일 기준으로 총 몇일인지 구한다.
        String[] todayArr = today.split("\\.");
        int todayDate = Integer.parseInt(todayArr[0]) * 12 * 28 + Integer.parseInt(todayArr[1]) * 28 + Integer.parseInt(todayArr[2]);

        // 알파벳별 보관기간을 map에 저장
        Map<String, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            String[] cur = term.split(" ");
            termsMap.put(cur[0], Integer.parseInt(cur[1]));
        }

        // privacies의 정보 또한 년월일을 28일 기준으로 몇일인지 구해서 현재 날짜와 비교
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] cur = privacies[i].split(" ");
            String[] curArr = cur[0].split("\\.");
            Integer term = termsMap.get(cur[1]); // 보관기간을 가져옴
            int curDate = Integer.parseInt(curArr[0]) * 12 * 28 + Integer.parseInt(curArr[1]) * 28 + Integer.parseInt(curArr[2]) + term * 28;

            if (todayDate >= curDate) {
                list.add(i + 1);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"})));
        System.out.println(Arrays.toString(solution("2020.01.01", new String[]{"Z 3", "D 5"}, new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"})));
    }
}
