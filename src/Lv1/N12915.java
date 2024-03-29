package Lv1;

import java.util.Arrays;
import java.util.Comparator;

// 문자열 내 마음대로 정렬하기
// n 번째 단어를 기준으로 정렬하기 단, n 번째 단어가 같다면 사전순으로 정렬하기
public class N12915 {
    public static String[] solution(String[] strings, int n){
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(n) == o2.charAt(n)){ // n 번째 단어가 같다면 사전순으로 먼저 오는 순으로 정렬
                    return o1.compareTo(o2);
                }
                return (int) o1.charAt(n) - (int) o2.charAt(n); // n 번째 단어 기준으로 정렬
            }
        });

        return strings;
    }

    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"};
        int n = 1;
        System.out.println(Arrays.toString(solution(strings, n)));
    }
}
