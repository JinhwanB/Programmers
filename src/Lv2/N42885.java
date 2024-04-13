package Lv2;

import java.util.Arrays;

// 구명보트
public class N42885 {
    public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        int cnt = 0; // 총 보트 수
        int left = 0;
        int right = people.length - 1;
        while (left <= right) { // 가장 최소의 보트만 사용하려면 가장 무거운 사람 + 가벼운 사람(보트 정원이 2명이므로)
            if (people[left] + people[right] <= limit) { // 무게 제한을 넘지 않는다면 둘 모두 태운다.
                left++;
                right--;
            } else { // 무게 제한을 넘는다면 1명만 태운다.
                right--;
            }

            cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(solution(new int[]{70, 80, 50}, 100));
    }
}
