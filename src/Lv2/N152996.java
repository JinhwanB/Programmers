package Lv2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 시소 짝꿍
public class N152996 {

    /*
    weights를 정렬해놓았기 때문에 weight는 다음 사람의 무게보다 작거나 같다.
    a -> 전 무게, b -> 다음 무게
    1. a * 1 = b * 1 의 경우 (a와 b가 같은 경우)
    2. a * 2 = b * 1 -> a = b * (1 / 2)
    3. a * 3 = b * 2 -> a = b * (2 / 3)
    4-1. a * 4 = b * 2 -> a = b * (2 / 4) -> a = b * (1 / 2)
    4-2. a * 4 = b * 3 -> a = b * (3 / 4)
    따라서 아래 dist 배열의 경우가 있음
     */
    static double[] dist = {1.0, 2.0 / 3, 1.0 / 2, 3.0 / 4};

    public static long solution(int[] weights) {
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        long count = 0;
        for (int weight : weights) {
            for (double v : dist) {
                if (map.containsKey(weight * v)) {
                    count += map.get(weight * v);
                }
            }

            map.put((double) weight, map.getOrDefault((double) weight, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{100, 180, 360, 100, 270}));
    }
}
