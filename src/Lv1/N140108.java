package Lv1;

// 문자열 나누기
public class N140108 {
    public static int solution(String s) {
        if (s.length() == 1) {
            return 1;
        }

        int cur = 1; // 현재 시작 문자와 같은 갯수
        int another = 0; // 시작 문자와 다른 문자 갯수
        int result = 0; // 문자 나눈 횟수
        int left = 0; // 시작 문자 index
        int right = left + 1; // 시작 문자 다음에 있는 index
        while (left < s.length()) {
            char c = s.charAt(left); // 시작 문자
            if (right > s.length() - 1) {
                result++;
                break;
            }

            if (s.charAt(right) == c) {
                cur++;
            } else {
                another++;
            }

            if (cur == another) {
                result++;
                left = right + 1;
                right = left + 1;
                cur = 1;
                another = 0;
            } else {
                right++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution("banana"));
        System.out.println(solution("abracadabra"));
        System.out.println(solution("aaabbaccccabba"));
    }
}
