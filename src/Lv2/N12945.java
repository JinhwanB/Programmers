package Lv2;

// 피보나치 수
public class N12945 {
    public static int solution(int n){
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        fabonacci(arr);
        return arr[n];
    }

    public static void fabonacci(int[] arr){
        for (int i = 2; i < arr.length; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(5));
    }
}
