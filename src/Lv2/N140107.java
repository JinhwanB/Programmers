package Lv2;

// 점 찍기
public class N140107 {

    // (0, 0) 에서 점 까지의 거리는 (x 길이의 제곱) + (y 길이의 제곱) = (d 의 제곱) 이다.
    // x 를 하나씩 증가시키면서 조건에 충족하는 y의 갯수를 구한다.
    // 총 y의 갯수는 위 공식을 활요해 Math.sqrt((d의 제곱) - (x의 제곱)) 이다.
    // 조건에 만족하는 y의 갯수는 y / k + 1 개이다.
    public static long solution(int k, int d) {
        long D = (long) d * d;
        long count = 0;
        for (long i = 0; i <= d; i++) {
            long a = i * k;
            if (a > d) {
                break;
            }

            long maxB = (long) Math.sqrt(D - a * a);
            count += (maxB / k + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 4));
        System.out.println(solution(1, 5));
    }
}
