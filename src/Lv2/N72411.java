package Lv2;

import java.util.*;
import java.util.stream.Collectors;

// 메뉴 리뉴얼
public class N72411 {

    static int courseMax;

    public static String[] solution(String[] orders, int[] course) {
        courseMax = course[course.length - 1]; // 코스 메뉴가 될 수 있는 최대 길이

        List<Integer> courseList = Arrays.stream(course)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        Map<Integer, Map<String, Integer>> map = new HashMap<>(); // course 의 값을 키로 가지고, 그 안에 메뉴 조합들을 value로 가지는 map
        for (Integer i : courseList) {
            map.put(i, new HashMap<>());
        }

        List<String> result = new ArrayList<>();
        for (String order : orders) {
            char[] charArray = order.toCharArray();
            Arrays.sort(charArray);
            String newOrder = new String(charArray); // 먼저 order를 정렬

            StringBuilder sb = new StringBuilder();
            boolean[] visited = new boolean[order.length()];
            solve(newOrder, sb, visited, 0, map, courseList); // 모든 조합을 확인하고 map에 저장
        }

        for (Integer i : courseList) {
            int max = 0;
            Map<String, Integer> orderMap = map.get(i);
            for (Integer value : orderMap.values()) { // course 별로 max값을 찾음
                max = Math.max(max, value);
            }

            if (max < 2) { // 무조건 1번 보다 많은 주문만 코스요리로 하므로 2보다 작다면 continue
                continue;
            }

            for (String s : orderMap.keySet()) { // max 값에 해당하는 값 result에 저장
                Integer cnt = orderMap.get(s);

                if (cnt == max) {
                    result.add(s);
                }
            }
        }

        return result.stream()
                .sorted()
                .toArray(String[]::new);
    }

    private static void solve(String order, StringBuilder sb, boolean[] visited, int idx, Map<Integer, Map<String, Integer>> map, List<Integer> courseList) {
        int len = sb.length();
        if (courseList.contains(len)) { // course에 해당하는 길이일 때 map에 저장
            String str = sb.toString();
            int cnt = map.get(len).getOrDefault(str, 0) + 1;

            map.get(len).put(str, cnt);
            if (sb.length() == courseMax) return;
        }

        for (int i = idx; i < order.length(); i++) {
            if (visited[i]) continue;
            sb.append(order.charAt(i));
            visited[i] = true;
            solve(order, sb, visited, i + 1, map, courseList);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4})));
        System.out.println(Arrays.toString(solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5})));
        System.out.println(Arrays.toString(solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4})));
    }
}
