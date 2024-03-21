package Lv1;

import java.util.HashMap;
import java.util.Map;

// 둘만의 암호
public class N155652 {
    public static String solution(String s, String skip, int index) {
        Map<Character, Boolean> map = new HashMap<>(); // skip 단어 확인용
        for (char c : skip.toCharArray()) {
            map.put(c, true);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            for (int j = 0; j < index; ) {
                ch += 1;
                if ((int) ch > (int) 'z') { // z 를 넘어가는 경우 a 로 바꿈
                    ch = 'a';
                }

                if (map.getOrDefault(ch, false)) { // skip 에 해당 단어가 있다면 continue
                    continue;
                }

                j++;
            }

            sb.append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("aukks", "wbqd", 5));
    }
}
