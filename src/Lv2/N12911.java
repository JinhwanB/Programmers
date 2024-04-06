package Lv2;

// 다음 큰 숫자
public class N12911 {
    public static int solution(int n){
        // bitCount라는 메소드 이용 -> 2진수의 1의 갯수를 반환하는 메소드
        int nCount = Integer.bitCount(n);
        int nextNum = n + 1;
        while(true){
            int nextNumCount = Integer.bitCount(nextNum);
            if(nextNumCount == nCount){
                return nextNum;
            }
            nextNum++;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(78));
        System.out.println(solution(15));
    }
}
