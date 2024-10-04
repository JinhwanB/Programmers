package Lv1;

public class N340199 {

    public static int solution(int[] wallet, int[] bill) {
        int result = 0;
        int walletMin = Math.min(wallet[0], wallet[1]);
        int walletMax = Math.max(wallet[0], wallet[1]);
        int billMin = Math.min(bill[0], bill[1]);
        int billMax = Math.max(bill[0], bill[1]);

        while (billMin > walletMin || billMax > walletMax) {
            billMax /= 2;
            int x = billMax;
            int b = billMin;
            billMin = Math.min(x, b);
            billMax = Math.max(x, b);
            result++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{30, 15}, new int[]{26, 17}));
        System.out.println(solution(new int[]{50, 50}, new int[]{100, 241}));
    }
}
