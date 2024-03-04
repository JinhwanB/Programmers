package Lv1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 두 개 뽑아서 더하기
// 주어진 배열에서 두 개의 수를 뽑아 더해서 나올 수 있는 모든 수를 배열에 담아 오름차순으로 정렬 후 리턴
public class N68644 {
    public static int[] solution(int[] numbers){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]); // 중복 수가 담기는 것 방지
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
