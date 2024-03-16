package Lv1;

import java.util.*;

// 실패율
public class N42889 {
    public static int[] solution(int N, int[] stages) {
        int[] result = new int[N];
        Map<Integer, Double> map = new HashMap<>(); // 각 스테이지별 실패율 저장
        for (int i = 1; i <= N; i++) {
            int totalNum = 0; // 각 스테이지에 총 도달한 인원 수
            int failNum = 0; // 각 스테이지별 실패한 인원 수
            double fail; // 실패율
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] >= i) {
                    totalNum++;
                    if (stages[j] == i) {
                        failNum++;
                    }
                }
            }

            fail = (double) failNum / (double) totalNum;
            if (failNum == 0 || totalNum == 0) { // map 에 NaN이 들어가는 경우 방지
                fail = 0;
            }

            map.put(i, fail);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((x, y) -> map.get(y).compareTo(map.get(x)));

        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] stages = {1, 1, 1, 2, 3, 4};
        System.out.println(Arrays.toString(solution(5, stages)));
    }
}
