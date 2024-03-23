package Lv1;

import java.util.ArrayList;
import java.util.List;

// 햄버거 만들기
public class N133502 {
    public static int solution(int[] ingredient) {
        if (ingredient.length < 3) {
            return 0;
        }

        List<Integer> list = new ArrayList<>();
        int result = 0;
        for (int i : ingredient) {
            list.add(i);
            while (list.size() >= 4) { // 1, 2, 3, 1 이렇게 4개가 있어야 햄버거가 완성이 되므로 4개 이상일 때만 확인한다.
                int length = list.size();
                if (list.get(length - 1) == 1 && list.get(length - 2) == 3 && list.get(length - 3) == 2 && list.get(length - 4) == 1) { // 거꾸로 확인하여 1, 3, 2, 1 이 되는지 확인
                    for (int j = 0; j < 4; j++) { // 맞다면 뒤에서부터 하나씩 지운다.
                        list.remove(list.size() - 1);
                    }
                    result++;
                } else break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
        System.out.println(solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}));
    }
}
