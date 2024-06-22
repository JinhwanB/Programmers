package Lv2;

// 멀쩡한 사각형
public class N62048 {

    public static long solution(int w, int h) {
        long total = (long) w * h;
        int gcd = gcd(Math.max(w, h), Math.min(w, h));
        w /= gcd;
        h /= gcd;

        return total - (long) (Math.max(w, h) + Math.min(w, h) - 1) * gcd;
    }

    private static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(solution(8, 12));
        System.out.println(solution(8, 3));
    }
}
