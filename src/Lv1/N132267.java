package Lv1;

// 콜라 문제
public class N132267 {
    public static int solution(int a, int b, int n){
        if(n < a) return 0;

        int result = 0;
        while(n >= a){
            int get = n / a * b;

            if(n % a == 0){
                n = n / a * b;
            }else{
                n = (n / a * b) + n % a;
            }

            result += get;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 1, 20));
    }
}
