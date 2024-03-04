package Lv1;

// 크기가 작은 부분 문자열
// t의 부분 문자열 중 크기가 p와 같은 부분 문자열을 확인
// 해당 부분 문자열을 정수르 바꿨을 때 p를 정수로 바꿨을 때보다 작은 경우의 수 리턴
public class N147355 {
    public static int solution(String t, String p){
        if(t.length() == p.length()){ // 두 문자의 길이가 같다면
            return Long.parseLong(t) <= Long.parseLong(p) ? 1 : 0; // 정수로 바꿔서 바로 비교
        }

        long num = Long.parseLong(p);
        int result = 0;

        for (int i = 0; i < t.length() - p.length() + 1; i++) { // p의 길이만큼 자르기 때문에 t의 길이에서 p의 길이를 뺀 만큼까지만 확인한다.
            String s = t.substring(i, i + p.length());
            long num2 = Long.parseLong(s);

            if(num2 <= num) result++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution("10203", "15"));
    }
}
