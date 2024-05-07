package Lv2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 롤케이크 자르기
public class N132265 {
    public static int solution(int[] topping) {
        Set<Integer> set = new HashSet<>(); // 동생의 토핑 수
        Map<Integer, Integer> map = new HashMap<>(); // 형의 토핑 수
        for (int i : topping) {
            int num = map.getOrDefault(i, 0);
            map.put(i, num + 1);
        }

        // 처음에 형이 모든 토핑을 가지고 시작하여 토핑을 하나씩 동생한테 주며 서로의 토핑 수를 확인한다.
        // 동생은 set을 사용하여 한 개씩 줄때마다 중복을 제거해 갯수를 확인한다.
        // 형은 map을 사용하여 keySet을 통해 토핑 갯수를 확인한다.
        int count = 0;
        for (int i : topping) {
            set.add(i); // 동생에게 한 개씩 주고
            int curNum = map.get(i); // 동생에게 준 토핑은 형의 토핑에서 뺀다.
            if (curNum - 1 == 0) { // 만약 0개가 된다면
                map.remove(i); // key를 지우고
            } else { // 아니라면
                map.put(i, curNum - 1); // 갯수를 하나 빼고 저장
            }

            if (set.size() == map.keySet().size()) { // 서로의 토핑 갯수 확인
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));
        System.out.println(solution(new int[]{1, 2, 3, 1, 4}));
    }
}
