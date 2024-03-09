package Lv1;

// 덧칠하기
public class N161989 {
    public static int solution(int n, int m, int[] section) {
        if (n == m) {
            return 1;
        }

        int[] arr = new int[n + 1]; // 칠한 구역을 1로 변경한다
        int result = 0;
        for (int i = section.length - 1; i >= 0; i--) {
            if (arr[section[i]] == 1) {
                continue;
            }

            if (section[i] >= m) {
                for (int j = section[i]; j >= section[i] - m + 1; j--) {
                    arr[j] = 1;
                }
                result++;
            } else {
                for (int j = section[i]; j >= 1; j--) {
                    arr[j] = 1;
                }
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] section = {2, 3, 6};
        System.out.println(solution(8, 4, section));
    }
}
