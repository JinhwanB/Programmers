package Lv2;

import java.util.Arrays;

// 전화번호 목록
public class N42577 {
    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book); // 사전순 정렬 후
        for (int i = 0; i < phone_book.length - 1; i++) { // 바로 다음 단어와만 비교함
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(solution(new String[]{"123", "456", "789"}));
        System.out.println(solution(new String[]{"12", "123", "1235", "567", "88"}));
        System.out.println(solution(new String[]{"0001", "000", "00"}));
    }
}
