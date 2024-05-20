package Lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 소수 찾기
public class N42839 {
    public static int solution(String numbers) {
        char[] arr = numbers.toCharArray();
        List<Integer> list = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            boolean[] visited = new boolean[arr.length];
            char c = arr[i];
            visited[i] = true;
            String s = String.valueOf(c);
            solve(s, i, arr, map, list, visited);
        }

        return list.size();
    }

    private static void solve(String s, int idx, char[] arr, Map<Integer, Boolean> map, List<Integer> list, boolean[] visited) {
        int cur = Integer.parseInt(s);
        if (map.getOrDefault(cur, null) == null) { // 한 번 확인한 수를 제외함
            if (isSosu(cur)) { // 소수인 경우
                map.put(cur, true);
                list.add(cur);
            } else { // 소수가 아닌 경우
                map.put(cur, false); // 소수가 아닌 경우에도 map에 넣어서 같은 수를 반복하는 경우를 제외시킴
            }
        }

        for (int i = 0; i < arr.length; i++) { // 다른 수와 조합하는 부분
            char c = arr[i];
            if (i != idx && !visited[i]) { // 처음 시작한 수가 아니고, 조합한 적이 없는 수인 경우 조합 시작
                visited[i] = true;
                solve(s + c, idx, arr, map, list, visited);
                visited[i] = false;
            }
        }
    }

    private static boolean isSosu(int number) {
        if (number == 0 || number == 1) { // 0과 1은 소수가 아님
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) { // 소수 판별
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }
}
