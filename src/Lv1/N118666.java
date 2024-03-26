package Lv1;

import java.util.HashMap;
import java.util.Map;

// 성격 유형 검사하기
public class N118666 {
    public static String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>(); // 성격 유형별 점수 저장
        Map<Integer, Integer> score = new HashMap<>(); // 동의, 비동의 각각 점수 저장
        int num = 3;
        for (int i = 1; i <= 7; i++) {
            if (i < 4) {
                score.put(i, num--); // 1, 2, 3번 선택 시 3, 2, 1의 점수를 얻음
            } else if (i > 4) {
                score.put(i, i % 4); // 5, 6, 7번 선택 시 1, 2, 3의 점수를 얻음
            } else {
                score.put(i, 0); // 4번 선택 시 0점
            }
        }

        for (int i = 0; i < choices.length; i++) {
            char c1 = survey[i].charAt(0);
            char c2 = survey[i].charAt(1);
            if (choices[i] < 4) {
                map.put(c1, map.getOrDefault(c1, 0) + score.get(choices[i]));
            } else if (choices[i] > 4) {
                map.put(c2, map.getOrDefault(c2, 0) + score.get(choices[i]));
            }
        }

        StringBuilder sb = new StringBuilder();
        String[] list = {"RT", "CF", "JM", "AN"};
        for (String s : list) {
            char c1 = s.charAt(0);
            char c2 = s.charAt(1);
            int leftNum = map.getOrDefault(c1, 0);
            int rightNum = map.getOrDefault(c2, 0);
            if (leftNum > rightNum) {
                sb.append(c1);
            } else if (leftNum < rightNum) {
                sb.append(c2);
            } else {
                sb.append(c1 < c2 ? c1 : c2);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
        System.out.println(solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3}));
    }
}
