package Lv2;

// 점프와 순간 이동
public class N12980 {
    public static int solution(int n) {
        int result = 0;
        while (n != 0) {
            if (n == 1) { // 1칸만 남은 경우 1칸 이동
                result += 1;
                n--;
            } else if (n % 2 == 0) { // 2로 나누어 떨어지는 경우 순간이동
                n /= 2;
            } else { // 아닌 경우 1칸 이동
                result += 1;
                n--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(5));
        System.out.println(solution(6));
        System.out.println(solution(5000));
    }
}
