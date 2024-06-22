package Lv2;

// 문자열 압축
public class N60057 {

    /*
    문자열을 순서대로 잘라서 같은지 확인하므로
    문자열의 길이 절반 이상의 길이로 자르면서 확인한다면 결국 현재 문자열의 길이를 반환하게 된다.
    따라서 1자리씩 확인하는 결과부터 문자열의 절반 - 1 까지의 자리까지 잘라 확인하면 된다.
     */
    public static int solution(String s) {
        int result = s.length();
        int start = s.length() / 2 - 1; // 문자열의 절반 - 1
        for (int i = start; i >= 0; i--) {
            result = Math.min(result, reduce(s, i));
        }

        return result;
    }

    // i + 1 은 문자를 자를 단위
    private static int reduce(String s, int i) {
        int count = 1; // 같은 문자 수
        String pre = s.substring(0, i + 1);
        StringBuilder sb = new StringBuilder();
        for (int j = i + 1; j < s.length(); j += i + 1) { // 두 번째로 자르는 문자열부터 pre와 비교한다.
            String cur = s.substring(j, Math.min(j + i + 1, s.length())); // 문자열 길이를 넘기는 경우 방지
            if (cur.equals(pre)) { // 문자가 pre 와 같은 경우
                count++;
                continue;
            }

            // 문자가 pre 와 다른 경우
            if (count != 1) { // count 가 1이 아니라면 같은 문자가 여러개이므로 숫자 + 문자 형식으로 sb 에 넣는다.
                sb.append(count).append(pre);
                pre = cur;
                count = 1;
            } else { // count 가 1이라면 같은 문자가 없는 경우이므로 문자 그대로 sb에 넣는다.
                sb.append(pre);
                pre = cur;
            }
        }

        // 반복문이 끝난 후 남은 문자열을 sb 에 넣어준다.
        if (count == 1) {
            sb.append(pre);
        } else {
            sb.append(count).append(pre);
        }

        return sb.length();
    }

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd"));
    }
}
