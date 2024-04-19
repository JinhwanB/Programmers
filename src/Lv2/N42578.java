package Lv2;

import java.util.HashMap;
import java.util.Map;

// 의상
public class N42578 {
    public static int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        if (map.size() == 1) { // 의상이 1종류인 경우
            return map.get(clothes[0][1]);
        }

        // 2종류 이상인 경우
        int result = 1;
        for (Integer value : map.values()) {
            result *= (value + 1); // 각 종류별 갯수 + 1한 값을 곱한 값에 -1한 값이 조합의 갯수
        }

        return result - 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
    }
}
