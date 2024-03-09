package Lv1;

import java.util.HashSet;
import java.util.Set;

// 폰켓몬
public class N1845 {
    public static int solution(int[] nums) {
        int num = nums.length / 2;

        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.size() == num) {
                break;
            }

            set.add(i);
        }

        return set.size();
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 3};
        System.out.println(solution(nums));
    }
}
