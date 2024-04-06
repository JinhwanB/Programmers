package Lv2;

// 숫자의 표현
public class N12924 {
    public static int solution(int n){
        if(n == 1){ // 1인 경우는 1가지 뿐이다.
            return 1;
        }

        int num = 1;
        int count = 0;
        while(num <= n){
            int sum = 0;
            for (int i = num; i <= n; i++) {
                if(sum == n) { // 합이 n이 되는 경우
                    count++;
                    break;
                }

                if(i + sum <= n) sum += i;
                else break;
            }

            num++;
        }

        return count + 1; // 위 반복문의 결과인 count는 자기 자신을 뺀 경우이므로 +1을 해준다.
    }

    public static void main(String[] args) {
        System.out.println(solution(15));
    }
}
