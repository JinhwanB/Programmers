package Lv1;

// 푸드 파이트 대회
public class N134240 {
    public static String solution(int[] food){
        String result = "";
        StringBuffer sb = new StringBuffer();

        for (int i = 1; i < food.length; i++) {
            int num = food[i] / 2;
            for (int j = 0; j < num; j++) {
                sb.append(i);
            }
        }

        String s = sb.toString();

        result = s + "0" + sb.reverse();
        return result;
    }

    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};
        System.out.println(solution(food));
    }
}
