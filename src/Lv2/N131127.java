package Lv2;

import java.util.HashMap;
import java.util.Map;

// 할인 행사
public class N131127 {
    public static int solution(String[] want, int[] number, String[] discount) {
        int result = 0; // 회원 등록을 하는 날짜 수

        for (int i = 0; i < discount.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            for (int j = i; j < i + 10; j++) { // 회원 등록을 하는 시점부터 10일간 회원이 유지되므로 10일 동안의 할인 목록과 수량을 map에 저장
                if (j == discount.length) {
                    break;
                }
                map.put(discount[j], map.getOrDefault(discount[j], 0) + 1);
            }

            boolean flag = false;
            for (int j = 0; j < want.length; j++) { // 원하는 목록과 갯수가 10일간 할인하는 품목과 갯수와 일치하면 result + 1
                int discountCnt = map.getOrDefault(want[j], 0);
                if (discountCnt != number[j]) {
                    flag = false;
                    break;
                } else {
                    flag = true;
                }
            }

            if (flag) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
        System.out.println(solution(new String[]{"apple"}, new int[]{10}, new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}));
    }
}
