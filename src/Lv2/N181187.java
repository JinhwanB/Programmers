package Lv2;

// 두 원 사이의 정수 쌍
public class N181187 {

    public static long solution(int r1, int r2) {
        long answer = 0;

        // y^2 = r^2 - x^2 을 이용한다.
        // 1사분면만 구한뒤 4를 곱한다.
        for (int i = 1; i <= r2; i++) {
            long max = (long) Math.floor(Math.sqrt(1.0 * r2 * r2 - 1.0 * i * i));
            long min = (long) Math.ceil(Math.sqrt(1.0 * r1 * r1 - 1.0 * i * i));
            answer += (max - min + 1);
        }

        return answer * 4;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 3));
    }
}
