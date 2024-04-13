package Lv2;

// 멀리 뛰기
public class N12914 {
    public static long solution(int n){
        long[] dp = new long[n + 1];
        if(n <= 3){
            return n;
        }

        dp[1] = 1; // n이 1인 경우 1칸 점프하는 경우의 1가지 경우 뿐이다.
        dp[2] = 2; // n이 2인 경우 1칸씩 점프하는 경우와 2칸을 점프하는 경우 총 2가지 경우이다.
        // 3번째 경우부터는 n-1칸에서 1칸 점프하는 경우와 n-2칸에서 2칸을 점프하는 경우임을 알 수 있다.
        // 즉 n칸으로 이동하는 경우의 수는 (n-2칸으로 가는 경우의 수 + n-1칸으로 가는 경우의 수)이다.
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
        System.out.println(solution(3));
    }
}
