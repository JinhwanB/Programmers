package Lv2;

import java.util.*;

// [3차] 압축
public class N17684 {
    public static int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>(); // 사전
        List<Integer> result = new ArrayList<>();
        int lastNum = 0; // 맨 마지막에 등록된 사전 단어의 번호
        for (char i = 'A'; i <= 'Z'; i++) { // 사전 초기화
            map.put(String.valueOf(i), i - 64);
            if (i == 'Z') {
                lastNum = i - 64;
            }
        }

        int start = 0;
        int end = 1;
        while (end <= msg.length()) {
            String cur = msg.substring(start, end);
            int curNum = map.getOrDefault(cur, 0);
            if (curNum == 0) { // 현재 단어가 사전에 없다면
                result.add(map.get(msg.substring(start, end - 1))); // 그 전까지의 단어의 사전 번호를 result에 추가
                map.put(cur, ++lastNum); // 현재 단어를 사전에 추가
                start = end - 1;
                end = start + 1; // 다음 단어부터 확인
                continue;
            }
            end++; // 사전에 있는 단어라면 사전에 없는 단어가 나올 때까지 확인
        }
        result.add(map.get(msg.substring(start))); // 마지막 단어에 대한 처리

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("KAKAO")));
        System.out.println(Arrays.toString(solution("TOBEORNOTTOBEORTOBEORNOT")));
        System.out.println(Arrays.toString(solution("ABABABABABABABAB")));
    }
}
