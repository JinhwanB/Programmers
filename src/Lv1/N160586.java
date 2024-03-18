package Lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 대충 만든 자판
public class N160586 {
    public static int[] solution(String[] keymap, String[] targets) {
        int[] result = new int[targets.length];
        Map<String, Integer> map = new HashMap<>(); // 각 키별로 최소 눌러야 하는 수를 저장

        for (String s : keymap) {
            for (int i = 0; i < s.length(); i++) {
                int touchKey = map.getOrDefault(String.valueOf(s.charAt(i)), Integer.MAX_VALUE); // 현재 map 에 키가 있으면 가져오고 없으면 Integer 최대값을 가져온다.
                map.put(String.valueOf(s.charAt(i)), Math.min(i + 1, touchKey)); // 최소 눌러야하는 수를 구해야하므로 최솟값을 저장
            }
        }


        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int sum = 0;

            for (int j = 0; j < target.length(); j++) {
                String s = String.valueOf(target.charAt(j));
                int cur = map.getOrDefault(s, 0); // 해당 키가 있으면 가져오고 없으면 0을 가져온다.
                if (cur == 0) {
                    sum = -1;
                    break;
                }

                sum += cur;
            }

            result[i] = sum;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD", "AABB"})));
        System.out.println(Arrays.toString(solution(new String[]{"AA"}, new String[]{"B"})));
        System.out.println(Arrays.toString(solution(new String[]{"AGZ", "BSSS"}, new String[]{"ASA", "BGZ"})));
    }
}
