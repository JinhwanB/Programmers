package Lv1;

import java.util.HashMap;
import java.util.Map;

// 완주하지 못한 선수
public class N42576 {
    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            String s = participant[i];
            map.put(s, map.getOrDefault(s, 0) + 1);

            if (i <= participant.length - 2) { // completion 은 participant 보다 항상 크기가 1 작다.
                String str = completion[i];
                map.put(str, map.getOrDefault(str, 0) - 1);
            }
        }

        String result = "";
        for (Map.Entry<String, Integer> s : map.entrySet()) {
            if (s.getValue() == 1) {
                result = s.getKey();
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }
}
