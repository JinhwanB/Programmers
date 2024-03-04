package Lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 추억 점수
public class N176963 {
    public static int[] solution(String[] name, int[] yearning, String[][] photo){
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        int[] result = new int[photo.length];
        int idx = 0;
        for (String[] strings : photo) {
            int cnt = 0;
            for (String item : strings) {
                if(map.containsKey(item)){
                    cnt += map.get(item);
                }
            }

            result[idx++] = cnt;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
        System.out.println(Arrays.toString(solution(name, yearning, photo)));
    }
}
