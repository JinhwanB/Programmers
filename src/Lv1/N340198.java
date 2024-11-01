package Lv1;

public class N340198 {

    public static int solution(int[] mats, String[][] park) {
        int answer = -1;
        int len = 0;
        int[][] D = new int[park.length][park[0].length]; // DP
        for (int i = 0; i < park[0].length; i++) {
            if (park[0][i].equals("-1")) {
                D[0][i] = 1;
            }

            if (D[0][i] > len) {
                len = D[0][i];
            }
        }

        // 가장 큰 정사각형의 한 변의 길이 구하는 과정
        for (int i = 1; i < park.length; i++) {
            for (int j = 0; j < park[0].length; j++) {
                if (park[i][j].equals("-1")) {
                    D[i][j] = 1;
                    if (j != 0 && park[i - 1][j - 1].equals("-1") && park[i - 1][j].equals("-1")
                        && park[i][j - 1].equals("-1")) {
                        D[i][j] = Math.min(Math.min(D[i - 1][j - 1], D[i - 1][j]), D[i][j - 1]) + 1;
                        len = Math.max(D[i][j], len);
                    }
                }
            }
        }

        for (int mat : mats) {
            if (mat <= len) {
                answer = Math.max(mat, answer);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 3, 2},
            new String[][]{{"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
            }));
    }
}
