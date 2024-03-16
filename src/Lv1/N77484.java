package Lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 로또의 최고 순위와 최저 순위
public class N77484 {
    public static int[] solution(int[] lottos, int[] win_nums) {
        int cnt0 = 0; // 0의 갯수
        int correct = 0; // 실제 로또에 맞은 숫자 수
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                cnt0++;
                continue;
            }

            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    correct++;
                    break;
                }
            }
        }

        if (correct == 6) { // 6개 모두 맞았다는건 0이 없다는 것
            return new int[]{1, 1};
        }

        Map<Integer, Integer> map = new HashMap<>();
        int num = 5;
        for (int i = 2; i <= 6; i++) {
            map.put(i, num--);
        }

        int max = map.getOrDefault(correct + cnt0, 6); // 현재 맞은 갯수에서 0이 모두 맞는 경우가 최대 순위
        int min = map.getOrDefault(correct, 6); // 반대로 최저 순위는 0이 모두 틀리는 경우

        return new int[]{max, min};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})));
        System.out.println(Arrays.toString(solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25})));
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5, 6}, new int[]{7, 8, 9, 10, 11, 12})));
    }
}
