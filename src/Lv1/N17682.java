package Lv1;

// [1차] 다트 게임
public class N17682 {
    public static int solution(String dartResult) {
        int first = 0; // 첫 번째 다트 점수
        int second = 0; // 두 번째 다트 점수
        int third = 0; // 세 번째 다트 점수
        int cur = 0; // 현재 계산 중인 다트 점수
        String[] numbers = dartResult.split("[^0-9]+"); // 숫자 부분
        String[] bonusOptions = dartResult.split("[0-9]+"); // 보너스와 옵션 부분
        for (int i = 0; i < numbers.length; i++) {
            cur = Integer.parseInt(numbers[i]);
            int num = i + 1; // 몇 번째 다트 점수인지 구분
            for (int j = 0; j < bonusOptions[i + 1].length(); j++) {
                char c = bonusOptions[i + 1].charAt(j);
                if (c == 'D') {
                    cur = (int) Math.pow(cur, 2);
                    continue;
                }

                if (c == 'T') {
                    cur = (int) Math.pow(cur, 3);
                    continue;
                }

                if (c == '*') {
                    if (num == 2) {
                        first *= 2;
                    } else if (num == 3) {
                        second *= 2;
                    }

                    cur *= 2;
                    continue;
                }

                if (c == '#') {
                    cur *= -1;
                }
            }

            if (num == 1) {
                first = cur;
            } else if (num == 2) {
                second = cur;
            } else {
                third = cur;
            }
        }

        return first + second + third;
    }

    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
        System.out.println(solution("1D2S#10S"));
        System.out.println(solution("1D2S0T"));
        System.out.println(solution("1S*2T*3S"));
        System.out.println(solution("1D#2S*3S"));
        System.out.println(solution("1T2D3D#"));
        System.out.println(solution("1D2S3T*"));
    }
}
