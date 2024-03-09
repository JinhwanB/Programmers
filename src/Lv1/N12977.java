package Lv1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 소수 만들기
public class N12977 {
    public static int solution(int[] nums) {
        List<Integer> list = new ArrayList<>(); // 세 수의 합 리스트
        for (int i = 0; i < nums.length; i++) {
            if (i + 2 >= nums.length) {
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    list.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }

        int answer = 0; // 소수가 되는 경우의 수
        Map<Integer, Boolean> map = new HashMap<>(); // list 에 같은 수가 있다면 map 에 저장되있는 소수 감별 결과를 확인
        for (int item : list) {
            if (map.containsKey(item) && map.get(item)) {
                answer++;
                continue;
            } else if (map.containsKey(item) && !map.get(item)) {
                continue;
            }

            boolean sosu = isSosu(item);
            if (sosu) {
                answer++;
                map.put(item, true);
            } else {
                map.put(item, false);
            }
        }

        return answer;
    }

    // 소수인지 확인하는 메소
    public static boolean isSosu(int num) {
        if (num <= 3) {
            return true;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 8, 4, 5};
        System.out.println(solution(nums));
    }
}
