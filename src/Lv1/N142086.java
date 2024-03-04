package Lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 가장 가까운 같은 글자
// s 라는 문자열이 주어질 때 각 단어마다 앞에(왼쪽) 같은 문자가 있다면 몇 번째 떨어진 자리에 있는지를 배열에 담아서 리턴
// 없다면 -1
public class N142086 {
    public static int[] solution(String s){
        int[] result = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        result[0] = -1; // 첫 글자는 앞에 글이 없으므로 -1
        map.put(s.charAt(0), 0);

        for (int i = 1; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){ // map 에 현재 단어가 있다면
                result[i] = i - map.get(s.charAt(i)); // map 에는 해당 단어가 몇 번째 위치해 있는지가 value로 저장되어 있기에 현재 단어의 위치에서 뺀다.
            }else{ // 없다면
                result[i] = -1;
            }
            map.put(s.charAt(i), i); // 위치 업데이트
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("banana")));
    }
}
