package Lv2;

// 2 X n 타일링
public class N12900 {
    static final int N = 1000000007;

    public static int solution(int n) {
        /*
        경우의 수를 확인해보면 n이 1씩 증가할 때마다 경우의 수가 (n - 1의 경우의 수 + n - 2의 경우의 수)가 성립되는 것을 확인할 수 있다.
        즉, 피보나치 수열이다. f(n) = f(n - 1) + f(n - 2)
         */
        if (n == 1 || n == 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % N;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}
