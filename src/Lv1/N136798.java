package Lv1;

// 기사단원의 무기
public class N136798 {
    public static int solution(int number, int limit, int power) {
        if (number == 1) {
            return 1;
        }

        int[] cnt = new int[number]; // 1 ~ number 까지 각각의 약수 갯수를 저장
        cnt[0] = 1;
        for (int i = 2; i <= number; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) {
                    cnt[i - 1]++;
                } else if (i % j == 0) {
                    cnt[i - 1] += 2;
                }
            }
        }

        int result = 0;
        for (int i : cnt) {
            if (i > limit) {
                result += power;
            } else {
                result += i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 3, 2));
    }
}
