package Lv1;

// 옹알이 (2)
public class N133499 {
    public static int solution(String[] babbling) {
        String[] arr = {"aya", "ye", "woo", "ma"};
        String[] repeatArr = {"ayaaya", "yeye", "woowoo", "mama"}; // 연속으로 있는 경우 제외용
        int result = 0;
        for (int i = 0; i < babbling.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                babbling[i] = babbling[i].replaceAll(repeatArr[j], "*").replaceAll(arr[j], " "); // 공백으로 replace 하는 이유는 공백으로 했을 때 다른 단어와 붙어서 replace 되는 경우를 제외시키기 위함
            }

            if (babbling[i].trim().equals("")) result++;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        System.out.println(solution(babbling));
    }
}
