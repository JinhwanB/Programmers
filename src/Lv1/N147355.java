package Lv1;

// 크기가 작은 부분 문자열
public class N147355 {
    public static int solution(String t, String p){
        if(t.length() == p.length()){
            return Long.parseLong(t) <= Long.parseLong(p) ? 1 : 0;
        }

        long num = Long.parseLong(p);
        int result = 0;

        for (int i = 0; i < t.length() - p.length() + 1; i++) {
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
