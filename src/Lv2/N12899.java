package Lv2;

// 124 나라의 숫자
public class N12899 {
    /**
     * 10진법을 3진법으로 변경하는 문제
     * 원래 3진법은 0, 1, 2로 이루어져있지만 이 문제는 0을 포함하면 안된다.
     */
    public static String solution(int n) {
        if (n == 1 || n == 2) {
            return String.valueOf(n);
        }

        StringBuilder sb = new StringBuilder();

        /*
         n을 3진법으로 변경한다.
         1. 몫이 0이 될때까지 3으로 나눈다.
         2. 나머지를 저장한다.
         3. 만약 나머지가 0이라면 0을 사용하면 안되므로 몫을 하나 빼고 나머지를 3으로 만든다.
         3-1. 문제는 1, 2, 4로 이루어져 있으므로 나머지가 3인 경우는 4로 저장한다.
         4. 몫이 0이 되는 순간의 나머지도 저장한다.
         5. 저장한 수를 뒤집는다.
         */
        while (n != 0) {
            int a = n / 3; // 몫
            int b = n % 3; // 나머지

            if (b == 0) { // 나머지가 0인 경우
                a -= 1;
                b = 4;

                sb.append(b);
                n = a;
                continue;
            }

            n = a;
            sb.append(b);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(9));
    }
}
