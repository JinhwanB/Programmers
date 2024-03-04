package Lv1;

import java.util.Arrays;

// K번째 수
// i 번째 수부터 j 번째 수를 담고 있는 배열을 오름차순으로 정렬한 후
// k 번째에 해당하는 수를 배열에 담아 리턴
public class N42748 {
    public static int[] solution(int[] array, int[][] commands){
        int[] result = new int[commands.length];

        int idx = 0;
        for (int[] item : commands) {
            int i = item[0];
            int j = item[1];
            int k = item[2];
            int[] newArr = new int[j - i + 1];
            int newIdx = 0;
            for (int l = i - 1; l <= j - 1 ; l++) {
                newArr[newIdx++] = array[l];
            }

            Arrays.sort(newArr);

            result[idx++] = newArr[k - 1];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(solution(array, commands)));
    }
}
