package Lv1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 두 개 뽑아서 더하기
public class N68644 {
    public static int[] solution(int[] numbers){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int[] result = new int[set.size()];
        int idx = 0;
        for (Integer item : set) {
            result[idx++] = item;
        }

        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};
        System.out.println(Arrays.toString(solution(numbers)));
    }
}
