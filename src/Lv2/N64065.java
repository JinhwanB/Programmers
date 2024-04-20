package Lv2;

import java.util.*;

// 튜플
public class N64065 {
    public static int[] solution(String s) {
        String[] split = s.split("\\},"); // "},"를 기준으로 자른다.
        List<List<Integer>> list = new ArrayList<>(); // 튜플 배열 리스트
        for (String string : split) {
            List<Integer> list1 = new ArrayList<>();
            String[] split1 = string.replaceAll("[\\{\\}]", "").split(","); // "{"와 "}"를 모두 제거 후 ","를 기준으로 배열로 바꾼다.
            for (String s1 : split1) {
                list1.add(Integer.parseInt(s1)); // 각 튜플 배열의 숫자를 리스트로 저장한다.
            }
            list.add(list1);
        }

        // 가장 작은 크기의 튜플 배열에서 이미 뽑은 수를 제외하며 수를 찾아간다.
        // [1, 2, 3], [2, 1], [1, 2, 4, 3], [2]
        // [2] -> [2]
        // [2, 1] -> 2는 이미 뽑은 수이므로 1을 가져온다. [2, 1]
        // [1, 2, 3] -> [2, 1, 3]
        // [1, 2, 4, 3] -> [2, 1, 3, 4]
        list.sort(((o1, o2) -> o1.size() - o2.size())); // 길이가 작은 튜플 배열 순으로 정렬
        Map<Integer, Integer> map = new HashMap<>(); // key: 뽑은 수, value: 이미 뽑았다면 1, 뽑지 않은 경우 0
        int max = list.get(list.size() - 1).size();
        int[] result = new int[max];
        for (int i = 0; i < result.length; i++) {
            List<Integer> cur = list.get(i);
            for (Integer integer : cur) {
                int num = map.getOrDefault(integer, 0);
                if (num == 0) { // 0인 경우가 뽑지 않은 수이므로
                    map.put(integer, 1);
                    result[i] = integer;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
        System.out.println(Arrays.toString(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
        System.out.println(Arrays.toString(solution("{{20,111},{111}}")));
        System.out.println(Arrays.toString(solution("{{123}}")));
        System.out.println(Arrays.toString(solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
    }
}
