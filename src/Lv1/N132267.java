package Lv1;

// 콜라 문제
// a 개를 가져다주면 b 개를 돌려 주는 가게가 있을 때 처음 가지고 있는 수를 n 이라고 한다면 총 몇 개를 돌려받을 수 있는지를 리턴
public class N132267 {
    public static int solution(int a, int b, int n){
        if(n < a) return 0; // n 은 a 보다 커야함

        int result = 0;
        while(n >= a){
            int get = n / a * b;

            if(n % a == 0){
                n = n / a * b;
            }else{
                n = (n / a * b) + n % a; // 총 3 개를 가지고 있고 2 개를 주면 1 개를 돌려받는다 했을 때 3 개 중 2 개를 반납하고 1개를 받는다. 따라서 원래 있던 1 개를 더해줘야 한다.
            }

            result += get;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 1, 20));
    }
}
