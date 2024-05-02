package Lv2;

import java.util.HashMap;
import java.util.Map;

// 모음 사전
public class N84512 {
    static int cnt = 1;
    static Map<String, Integer> map = new HashMap<>();

    public static int solution(String word) {
        /*
        단어를 숫자로 대체하여 저장한다.
        A -> 0, E -> 1, I -> 2, O -> 3, U -> 4
         */
        init(0, ""); // 나올 수 있는 모든 단어를 map에 key와 순서로 저장

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) { // 구하려는 단어를 확인
            char target = word.charAt(i);
            if (target == 'A') sb.append(0);
            else if (target == 'E') sb.append(1);
            else if (target == 'I') sb.append(2);
            else if (target == 'O') sb.append(3);
            else if (target == 'U') sb.append(4);
        }
        String key = sb.toString();
        return map.get(key); // map에서 해당 단어의 순서를 가져와 리턴
    }

    private static void init(int depth, String cur) {
        if (depth == 5) return;

        for (int i = 0; i < 5; i++) {
            String next = cur + i;
            map.put(next, cnt);
            cnt++;
            init(depth + 1, next);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("AAAAE"));
        cnt = 1;
        map.clear();
        System.out.println(solution("AAAE"));
        cnt = 1;
        map.clear();
        System.out.println(solution("I"));
        cnt = 1;
        map.clear();
        System.out.println(solution("EIO"));
    }
}
