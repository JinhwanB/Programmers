package Lv0;

import java.util.*;

// 한 번만 등장한 문자
// 문자열 s에서 한번만 등장한 문자를 사전 순으로 정렬한 문자열 return
public class N120896 {
    public static String solution(String s){
        List<String> list = new ArrayList<>(); // 한 개만 있는 문자를 담을 리스트
        Map<String, Integer> map = new HashMap<>(); // 각 문자별로 몇 개가 있는지 매칭

        for (String str : s.split("")) {
            if(map.containsKey(str)){
                map.put(str, map.get(str) + 1);
            }else{
                map.put(str, 1);
            }
        }

        for (Map.Entry<String, Integer> item : map.entrySet()) {
            if(item.getValue() == 1){
                list.add(item.getKey());
            }
        }

        Collections.sort(list);

        return String.join("", list);
    }

    public static void main(String[] args) {
        System.out.println(solution("abcabcadc"));
    }
}
