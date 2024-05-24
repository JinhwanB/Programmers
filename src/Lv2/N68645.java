package Lv2;

import java.util.Arrays;

// 삼각 달팽이
public class N68645 {
    static int[] dy = {1, 0, -1};
    static int[] dx = {0, 1, -1};

    public static int[] solution(int n) {
        int[][] arr = new int[n][n];
        arr[0][0] = 1;
        int y = 0;
        int x = 0;
        int num = 2;
        int idx = 0; // dy, dx를 순회할 인덱스 0: 아래 이동, 1: 오른쪽 이동, 2: 왼쪽 대각선 이동
        int count = 0; // 이동할 수 없는 경우의 횟수, 2라면 이미 모든 부분을 다 채운 경우이므로 반복문 탈출

        /*
        2차원 배열을 만들고 아래 -> 오른쪽 -> 왼쪽 대각선 순으로 순회한다.
         */
        while (count < 2) {
            int Y = y + dy[idx];
            int X = x + dx[idx];
            if (Y >= 0 && Y < arr.length && X >= 0 && X < arr[0].length && arr[Y][X] == 0) { // 이동 가능한지 확인
                arr[Y][X] = num++;
                y = Y;
                x = X;
                count = 0;
                continue;
            } else { // 이동 불가능한 경우
                count++;
            }

            idx++;
            if (idx == dy.length) {
                idx = 0;
            }
        }

        int[] result = new int[num - 1];
        int index = 0;
        for (int[] ints : arr) {
            for (int cur : ints) {
                if (cur == 0) {
                    break;
                }

                result[index++] = cur;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4)));
        System.out.println(Arrays.toString(solution(5)));
        System.out.println(Arrays.toString(solution(6)));
        System.out.println(Arrays.toString(solution(3)));
    }
}
