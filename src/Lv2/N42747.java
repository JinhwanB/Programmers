package Lv2;

import java.util.Arrays;

// H-Index
public class N42747 {
    public static int solution(int[] citations) {
        // 논문의 인용 횟수와 인용 횟수 이상으로 인용된 논문의 수 중 최솟값이 h-index
        Arrays.sort(citations);
        int result = 0; // h-index
        for (int i = citations.length - 1; i >= 0; i--) {
            int cur = citations[i]; // 현재 논문의 인용 횟수
            int cnt = 0; // 현재 논문의 인용 횟수 이상으로 인용된 논문의 수
            for (int j = citations.length - 1; j >= 0; j--) {
                if (cur <= citations[j]) {
                    cnt++;
                } else break;
            }
            result = Math.max(result, Math.min(cnt, cur));
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 0, 6, 1, 5}));
        System.out.println(solution(new int[]{6, 5, 4, 1, 0}));
    }
}
