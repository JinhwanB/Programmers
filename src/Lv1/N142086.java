package Lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 가장 가까운 같은 글자
public class N142086 {
    public static int[] solution(String s){
        int[] result = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        result[0] = -1;
        map.put(s.charAt(0), 0);

        for (int i = 1; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                result[i] = i - map.get(s.charAt(i));
            }else{
                result[i] = -1;
            }
            map.put(s.charAt(i), i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("banana")));
    }
}
