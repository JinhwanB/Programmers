package Lv2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 후보키
public class N42890 {

    static int col;
    static int row;
    static boolean[] result;
    static List<Set<Integer>> prevSet = new ArrayList<>();
    static int answer = 0;

    public static int solution(String[][] relation) {
        col = relation[0].length;
        row = relation.length;
        result = new boolean[col];

        comRow(0, relation);

        return answer;
    }

    // 모든 후보 키 조합을 확인
    private static void comRow(int idx, String[][] relation) {
        if (idx >= col) {
            if (isKey(relation)) { // 후보 키가 조건에 부합하는지 확인
                answer++;
            }

            return;
        }

        result[idx] = false;
        comRow(idx + 1, relation);
        result[idx] = true;
        comRow(idx + 1, relation);
    }

    // 후보 키가 유일성과 최소성을 부합하는지 확인
    private static boolean isKey(String[][] relation) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < row; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < col; j++) {
                if (!result[j]) {
                    continue;
                }

                sb.append(relation[i][j]);
            }

            set.add(sb.toString());
        }

        if (set.size() == row) { // 유일성 조건을 만족할 때
            if (isMin()) { // 최소성을 만족하는지 확인
                return true;
            }
        }

        return false;
    }

    // 후보 키의 최소성 만족 여부 확인
    private static boolean isMin() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < col; i++) {
            if (result[i]) {
                set.add(i);
            }
        }

        for (Set<Integer> prev : prevSet) {
            if (set.containsAll(prev)) { // 현재 후보 키가 다른 후보 키의 부분 집합인 경우
                return false;
            }
        }

        prevSet.add(set);
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(
            new String[][]{{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}}));
    }
}
