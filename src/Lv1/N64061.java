package Lv1;

import java.util.Stack;

// 크레인 인형뽑기 게임
public class N64061 {
    public static int solution(int[][] board, int[] moves) {
        int result = 0;
        Stack<Integer> stack = new Stack<>(); // 옮긴 인형 담기용
        boolean[][] flag = new boolean[board.length][board[0].length]; // 옮겼던 인형인지 판별용
        for (int i = 0; i < moves.length; i++) {
            int cur = moves[i];
            for (int j = 0; j < board.length; j++) {
                if (!flag[j][cur - 1] && board[j][cur - 1] > 0) { // 옮기지 않은 인형이며 빈칸이 아닐 경우
                    if (!stack.isEmpty() && stack.peek() == board[j][cur - 1]) { // 같은 인형이 이미 담겨져 있다면
                        stack.pop();
                        result += 2;
                        flag[j][cur - 1] = true;
                        break;
                    }

                    stack.push(board[j][cur - 1]);
                    flag[j][cur - 1] = true;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}}, new int[]{1, 5, 3, 5, 1, 2, 1, 4}));
    }
}
