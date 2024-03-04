package Lv1;

// 푸드 파이트 대회
// 주어진 배열은 음식을 칼로리가 적은 순으로 정렬한 것
// 주어진 배열 중 1 은 물이며 무조건 1개만 존재
// 주어진 배열은 각 i 번째 음식의 갯수
// 2명의 선수가 양쪽 끝에서 시작하며 같은 갯수의 음식을 칼로리가 낮은 순으로 먹을 수 있도록 정렬해야 함
// 가운데에는 물을 두고 먼저 물을 마시는 선수가 승리
// 음식을 어떻게 정렬하면 되는지 리턴
public class N134240 {
    public static String solution(int[] food){
        String result = "";
        StringBuffer sb = new StringBuffer(); // 왼쪽에서 시작하는 선수가 먹을 음식을 나열한 후 오른쪽에서 시작하는 선수가 먹을 음식은 왼쪽에서 시작하는 선수가 먹을 음식의 반대로 정렬하면 된다.

        for (int i = 1; i < food.length; i++) {
            int num = food[i] / 2; // 2 명이 같은 갯수의 음식을 먹어야 하므로 1 명이 먹을 음식의 수는 2 로 나눈 수
            for (int j = 0; j < num; j++) { // 왼쪽 선수가 먹을 음식 정렬
                sb.append(i);
            }
        }

        String s = sb.toString();

        result = s + "0" + sb.reverse(); // 왼쪽 선수가 먹을 음식 + 0(물) + 오른쪽 선수가 먹을 음식
        return result;
    }

    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};
        System.out.println(solution(food));
    }
}
