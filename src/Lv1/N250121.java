package Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// [PCCE 기출문제] 10번 / 데이터 분석
public class N250121 {
    // 데이터 = 코드번호, 제조일, 최대수량, 현재수량
    // ext -> code = 코드번호, date = 제조일, maximum = 최대수량, remain = 현재수량
    // data 에서 ext 값이 val_ext 보다 작은 데이터만 뽑은 후 sort_by 에 해당하는 값을 기준으로 오름차순
    static class MyData {
        int code;
        int date;
        int maximum;
        int remain;

        public MyData(int code, int date, int maximum, int remain) {
            this.code = code;
            this.date = date;
            this.maximum = maximum;
            this.remain = remain;
        }
    }

    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<MyData> list = new ArrayList<>();
        for (int[] datum : data) {
            int num;
            if (ext.equals("code")) num = datum[0];
            else if (ext.equals("date")) num = datum[1];
            else if (ext.equals("maximum")) num = datum[2];
            else num = datum[3];

            if (num < val_ext) {
                list.add(new MyData(datum[0], datum[1], datum[2], datum[3]));
            }
        }

        if (sort_by.equals("code")) list.sort((x, y) -> x.code - y.code);
        else if (sort_by.equals("date")) list.sort((x, y) -> x.date - y.date);
        else if (sort_by.equals("maximum")) list.sort((x, y) -> x.maximum - y.maximum);
        else list.sort((x, y) -> x.remain - y.remain);

        int[][] result = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            MyData myData = list.get(i);
            result[i][0] = myData.code;
            result[i][1] = myData.date;
            result[i][2] = myData.maximum;
            result[i][3] = myData.remain;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] solution = solution(new int[][]{{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}}, "date", 20300501, "remain");
        for (int[] ints : solution) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
