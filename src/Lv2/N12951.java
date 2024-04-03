package Lv2;

// JadenCase 문자열 만들기
public class N12951 {
    public static String solution(String s) {
        if (s.length() == 1) {
            return s.toUpperCase();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            if (i == 0) { // 첫 단어일 경우
                sb.append(str.toUpperCase());
            } else if (String.valueOf(s.charAt(i - 1)).equals(" ")) { // 공백 다음에 오는 첫 단어일 경우
                sb.append(str.toUpperCase());
            } else { // 나머지의 경우
                sb.append(str.toLowerCase());
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
        System.out.println(solution("for the last week"));
    }
}
