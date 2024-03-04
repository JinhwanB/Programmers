package Lv0;

import java.util.HashMap;
import java.util.Map;

// 영어가 싫어요
// 수를 영단어로 바꿔 조합한 문자열이 주어질 때 다시 수로 바꾸는 문제
public class IDontLikeEnglish {
    public static long solution(String numbers){
        Map<String, Integer> map = new HashMap<>();
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (Map.Entry<String, Integer> item : map.entrySet()) {
            if(numbers.contains(item.getKey())){
                numbers = numbers.replaceAll(item.getKey(), String.valueOf(item.getValue()));
            }
        }

        return Long.parseLong(numbers);
    }

    public static void main(String[] args) {
        System.out.println(solution("onetwothreefourfivesixseveneightnine"));
    }
}
