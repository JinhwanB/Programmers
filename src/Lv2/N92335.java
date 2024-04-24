package Lv2;

// k진수에서 소수 개수 구하기
public class N92335 {
    public static int solution(int n, int k) {
        // 문제에 길게 설명이 되어 있지만 결국 0과 0사이의 수 중 소수의 개수를 구하는 문제
        // 만약 0이 없다면 해당 수 자체가 소수인지 구하면 됨
        String string = Integer.toString(n, k); // n을 k진수로 변경
        String[] split = string.split("0"); // 0을 기준으로 배열로 나눈다.
        int count = 0;
        for (String s : split) {
            if (s.equals("1") || s.isEmpty()) { // 1이라면 소수가 아니다 || ""는 수가 아니다.
                continue;
            }

            long num = Long.parseLong(s); // int범위를 벗어나므로 int를 쓴다면 런타임 에러 발생
            if (num == 2) { // 2는 소수
                count++;
                continue;
            }

            boolean flag = false;
            for (int i = 2; i < Math.sqrt(num) + 1; i++) { // 소수 판별
                if (num % i == 0) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(437674, 3));
        System.out.println(solution(110011, 10));
        System.out.println(solution(1000000, 10));
    }
}
