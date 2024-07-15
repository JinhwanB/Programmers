package Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 숫자 블록
public class N12923 {

    public static int[] solution(long begin, long end) {
        List<Integer> list = new ArrayList<>();
        for (long i = begin; i <= end; i++) {
            int num = maxOfDiv(i);
            list.add(num);
        }

        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }

    // n 위치에 설치된 블록 번호는 n의 약수 중 가장 큰 수이다.
    // 1부터 10000000 까지의 블록을 사용했다 했으므로 그 이상의 블록은 사용할 수 없다.
    // 위치 n이 소수인 경우 1, 소수가 아닌 경우 약수 중 가장 큰 수이면서 10000000보다 작은 수의 블록이 위치한다.
    private static int maxOfDiv(long value) {
        if (value == 1) { // 1일 때는 0
            return 0;
        }

        if (value <= 3) { // 2 또는 3인 경우 소수이므로 1이다.
            return 1;
        }

        int result = 0;
        for (int i = 2; i <= Math.min(Math.sqrt(value), 10000000);
            i++) { // 제곱근까지 반복하지만 10000000이 넘는 경우까지 반복하진 않는다.
            if (value % i == 0) { // 소수가 아닌 경우
                result = (int) Math.max(result,
                    value / i <= 10000000 ? value / i : i); // 가장 큰 약수를 구한다.
            }
        }

        return result == 0 ? 1 : result; // result 가 0이라면 소수라는 얘기이므로 1을 반환한다.
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(1, 10)));
        System.out.println(Arrays.toString(solution(477559014, 477559014)));
    }
}
