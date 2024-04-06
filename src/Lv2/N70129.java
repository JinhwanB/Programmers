package Lv2;

import java.util.Arrays;

// 이진 변환 반복하기
public class N70129 {
    public static int[] solution(String s){
        int count = 0; // 이진 변환 횟수
        int zeroCnt = 0; // 0을 제거한 갯수
        while(!s.equals("1")){ // 1이 될때까지 반복
            StringBuilder sb = new StringBuilder(); // 0이면 zeroCnt증가, 아니면 sb에 추가
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == '0'){
                    zeroCnt++;
                }else{
                    sb.append(c);
                }
            }

            int length = sb.length();
            s = Integer.toBinaryString(length); // 길이를 이진수로 변환
            count++;
        }

        return new int[]{count, zeroCnt};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("110010101001")));
        System.out.println(Arrays.toString(solution("01110")));
        System.out.println(Arrays.toString(solution("1111111")));
    }
}
