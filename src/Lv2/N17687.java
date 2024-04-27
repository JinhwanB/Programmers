package Lv2;

// [3차] n진수 게임
public class N17687 {
    public static String solution(int n, int t, int m, int p) {
        // n: 진법, t: 출력해야하는 수, m: 참가인원, p: 타겟의 순서
        int num = 0; // 말할 숫자
        int turn = 1; // 현재 순서
        StringBuilder sb = new StringBuilder();
        while (sb.length() < t) {
            String curNum = Integer.toString(num, n); // 현재 수를 문제의 진법으로 변경
            for (int i = 0; i < curNum.length(); i++) { // 각 자리를 순회
                if (turn > m) { // 현재 턴이 인원을 넘어가면 다시 첫번째 사람 순서로 변경
                    turn = 1;
                }

                char cur = curNum.charAt(i);
                if (turn == p) { // 현재 순서가 타겟의 순서인 경우
                    sb.append(cur);
                    if (sb.length() == t) { // 말해야 할 갯수를 모두 구했을 때
                        break;
                    }
                }
                turn++;
            }
            num++;
        }

        return sb.toString().toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 4, 2, 1));
        System.out.println(solution(16, 16, 2, 1));
        System.out.println(solution(16, 16, 2, 2));
        System.out.println(solution(8, 8, 5, 3));
    }
}
