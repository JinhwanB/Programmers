package Lv2;

import java.util.Arrays;

// 카펫
public class N42842 {
    public static int[] solution(int brown, int yellow){
        int num = brown + yellow;
        int x = 0;
        int y = 0;
        // 답은 brown과 yellow의 공약수 중 하나
        for (int i = (int) Math.sqrt(num) + 1; i >= 1; i--) {
            if(num % i == 0){
                x = i;
                y = num / i;
                // 격자의 가운데에는 yellow가 위치해야 하므로
                // 가로 길이에서 양 끝칸 두칸을 제외한 길이로 yellow를 나눴을 때 나머지가 0이어야 한다.
                if(yellow % (Math.max(x, y) - 2) == 0){
                    break;
                }
            }
        }

        return new int[]{Math.max(x, y), Math.min(x, y)};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, 2)));
        System.out.println(Arrays.toString(solution(8, 1)));
        System.out.println(Arrays.toString(solution(24, 24)));
        System.out.println(Arrays.toString(solution(18, 6)));
    }
}
