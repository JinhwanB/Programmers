package Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 모의고사
public class N42840 {
    public static int[] solution(int[] answers) {
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] cnt = new int[4]; // 1~3만 사용, 각 1번부터 3번의 점수 저장
        int max = 0; // 가장 많이 맞춘 사람의 맞춘 문제 수

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == person1[i % person1.length]) {
                cnt[1]++;
                max = Math.max(cnt[1], max);
            }

            if (answers[i] == person2[i % person2.length]) {
                cnt[2]++;
                max = Math.max(cnt[2], max);
            }

            if (answers[i] == person3[i % person3.length]) {
                cnt[3]++;
                max = Math.max(cnt[3], max);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < cnt.length; i++) {
            if (cnt[i] == max) {
                list.add(i);
            }
        }

        Collections.sort(list);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] answers = {1, 3, 2, 4, 2};
        System.out.println(Arrays.toString(solution(answers)));
    }
}
