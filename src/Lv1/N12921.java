package Lv1;

// 소수 찾기
public class N12921 {
    public static int solution(int n) {
        int result = 0;

        for (int i = 2; i <= n; i++) {
            boolean sosu = isSosu(i);
            if (sosu) {
                result++;
            }
        }

        return result;
    }

    // 소수 판별 메소드
    public static boolean isSosu(int num) {
        if (num <= 3) {
            return true;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(10));
    }
}
