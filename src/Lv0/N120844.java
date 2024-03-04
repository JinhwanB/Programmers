package Lv0;

import java.util.Arrays;

// 배열 회전시키기
// numbers 배열의 원소를 direction 방향으로 한 칸씩 회전시킨 배열을 리턴
public class N120844 {
    public static int[] solution(int[] numbers, String direction){
        int[] result = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if(direction.equals("right")){
                result[(i + 1) % result.length] = numbers[i];
            }else{
                result[(i - 1 + result.length) % result.length] = numbers[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {4, 455, 6, 4, -1, 45, 6};
        System.out.println(Arrays.toString(solution(numbers, "left")));
    }
}
