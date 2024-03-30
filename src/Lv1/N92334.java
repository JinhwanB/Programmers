package Lv1;

import java.util.*;

// 신고 결과 받기
public class N92334 {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] result = new int[id_list.length];
        Map<String, Set<String>> map = new HashMap<>(); // 신고자와 신고 받은 사람을 중복 제거하여 저장
        Arrays.stream(report).forEach(s -> {
            String[] cur = s.split(" ");
            Set<String> set = map.getOrDefault(cur[0], new HashSet<>());
            set.add(cur[1]);
            map.put(cur[0], set);
        });

        Set<String> set = new HashSet<>(); // 이용 정지된 사람 저장
        Map<String, Integer> reportNumSet = new HashMap<>(); // 신고 받은 수 저장
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            for (String name : entry.getValue()) {
                reportNumSet.put(name, reportNumSet.getOrDefault(name, 0) + 1);
                if (reportNumSet.get(name) >= k) {
                    set.add(name);
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            Set<String> cur = map.getOrDefault(name, new HashSet<>());
            if (cur.size() > 0) {
                for (String s : set) {
                    if (cur.contains(s)) {
                        result[i]++;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2)));
        System.out.println(Arrays.toString(solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3)));
    }
}
