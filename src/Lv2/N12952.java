package Lv2;

// N-Queen
public class N12952 {

    static int result = 0;

    /*
    퀸은 어차피 행별로 하나씩 밖에 배치할 수 없다.
    따라서 2차원 배열이 아닌 1차원 배열로 압축하여 탐색한다.
     */
    public static int solution(int n) {
        batchQueen(new int[n], 0, n);

        return result;
    }

    private static void batchQueen(int[] cur, int depth, int n) {
        if (depth == n) {
            result++;
            return;
        }

        for (int i = 0; i < n; i++) {
            cur[depth] = i; // 퀸의 위치(index)를 뜻한다.
            if (isBatch(cur, depth)) { // 수직, 대각선 위치에 퀸이 이미 존재하는지 확인한다.
                batchQueen(cur, depth + 1, n);
            }
        }
    }

    private static boolean isBatch(int[] cur, int depth) {
        for (int i = 0; i < depth; i++) {
            if (cur[depth] == cur[i]) { // 수직선상에 이미 퀸이 있는 경우
                return false;
            }

            // 대각선은 기울기를 이용하여 확인한다.
            if (Math.abs(depth - i) == Math.abs(cur[depth] - cur[i])) { // 대각선상에 이미 퀸이 있는 경우
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}
