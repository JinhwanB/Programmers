package Lv1;

// 신규 아이디 추천
public class N72410 {
    public static String solution(String new_id) {
        new_id = new_id.toLowerCase()
                .replaceAll("[^a-z0-9._-]", "") // 소문자, 숫자, ., _, - 를 제외한 문자 제거
                .replaceAll("[.]+", ".") // . 이 연속하는 경우 1개로 바꿈
                .replaceAll("^[.]", "") // 시작이 . 인경우 제거
                .replaceAll("[.]$", ""); // 끝 문자가 . 인경우 제거

        if (new_id.length() == 0) { // 빈 문자열일 경우 a 추가
            new_id += "a";
        }

        if (new_id.length() >= 16) { // 문자열이 16자 이상일 경우
            new_id = new_id.substring(0, 15).replaceAll("[.]$", "");
        }

        if (new_id.length() <= 2) { // 문자열이 2자 이하인 경우
            char c = new_id.charAt(new_id.length() - 1);

            while (new_id.length() != 3) {
                new_id += c;
            }
        }

        return new_id;
    }

    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(solution("z-+.^."));
        System.out.println(solution("=.="));
        System.out.println(solution("123_.def"));
        System.out.println(solution("abcdefghijklmn.p"));
    }
}
