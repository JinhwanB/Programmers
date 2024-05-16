package Lv2;

import java.util.Stack;

// [1차] 프렌즈4블록
public class N17679 {
    public static int solution(int m, int n, String[] board) {
        char[][] arr = new char[m][n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = board[i].toCharArray();
        }

        while (true) {
            Stack<int[]> deletedBlocks = getDeletedBlocks(arr); // 삭제되는 블록을 찾는다.

            if (deletedBlocks.isEmpty()) break; // 삭제될 블록이 더 이상 없다면 반복문 break

            while (!deletedBlocks.isEmpty()) { // 삭제할 블록을 .으로 변경한다.
                int[] pop = deletedBlocks.pop();
                int i = pop[0];
                int j = pop[1];
                arr[i][j] = '.';
            }

            moveBlocks(arr); // 블록을 삭제 후 위에 있는 블록을 아래쪽으로 채운다.
        }

        int count = 0;
        for (char[] chars : arr) {
            for (char aChar : chars) {
                if (aChar == '.') count++;
            }
        }

        return count;
    }

    // 윗 블록을 삭제한 블록을 대신하여 채우는 메소드
    private static void moveBlocks(char[][] arr) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) { // 한 열마다 삭제한 블록을 제외한 블록을 스택에 넣는다.
                char c = arr[j][i];
                if (c != '.') stack.add(c);
            }

            if (!stack.isEmpty()) { // 스택이 비어있지 않다면
                for (int j = arr.length - 1; j >= 0; j--) {
                    if (stack.isEmpty()) { // 스택을 모두 사용한 후라면
                        arr[j][i] = '.'; // 나머지는 삭제한 블록으로 채운다.
                        continue;
                    }

                    arr[j][i] = stack.pop(); // 하나씩 빼서 아래쪽부터 채운다.
                }
            }
        }
    }

    // 삭제될 블록을 찾는 메소드
    private static Stack<int[]> getDeletedBlocks(char[][] arr) {
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr[i].length - 1; j++) {
                char a = arr[i][j];
                if (a == '.') continue; // 이미 삭제한 블록이라면 continue

                char b = arr[i][j + 1]; // 오른쪽 블록
                char c = arr[i + 1][j]; // 아래 블록
                char d = arr[i + 1][j + 1]; // 아래 오른쪽(대각선) 블록
                if (a == b && a == c && a == d) { // 4개의 블록이 모두 같을 때 지운다.
                    stack.add(new int[]{i, j});
                    stack.add(new int[]{i, j + 1});
                    stack.add(new int[]{i + 1, j});
                    stack.add(new int[]{i + 1, j + 1});
                }
            }
        }
        return stack;
    }

    public static void main(String[] args) {
        System.out.println(solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        System.out.println(solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
    }
}
