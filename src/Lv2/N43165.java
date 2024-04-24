package Lv2;

// 타겟 넘버
public class N43165 {
    static int count = 0;

    public static int solution(int[] numbers, int target) {
        dfs(0, 1, 0, numbers, target);
        dfs(0, -1, 0, numbers, target);
        return count;
    }

    // 모든 경우의 수 확인 dfs
    private static void dfs(int idx, int mul, int sum, int[] numbers, int target) {
        if (idx == numbers.length - 1) {
            if (sum + numbers[idx] * mul == target) {
                count++;
            }
            return;
        }
        sum += (numbers[idx] * mul);
        dfs(idx + 1, 1, sum, numbers, target);
        dfs(idx + 1, -1, sum, numbers, target);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
        count = 0;
        System.out.println(solution(new int[]{4, 1, 2, 1}, 4));
    }
}
