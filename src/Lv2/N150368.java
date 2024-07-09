package Lv2;

import java.util.Arrays;

// 이모티콘 할인행사
public class N150368 {

    static int[] discounts = new int[]{40, 30, 20, 10};
    static int[][] newEmoticons; // 이모티콘의 할인율과 할인된 가격을 담을 배열
    static int countOfUser;
    static int money;

    public static int[] solution(int[][] users, int[] emoticons) {
        countOfUser = 0;
        money = 0;
        newEmoticons = new int[emoticons.length][];

        findMax(users, emoticons, 0);

        return new int[]{countOfUser, money};
    }

    // 완전탐색
    private static void findMax(int[][] users, int[] emoticons, int emoticonsIdx) {
        if (emoticonsIdx == emoticons.length) { // 모든 이모티콘에 할인율을 적용한 경우
            int curUser = 0; // 현재 이모티콘 플러스 가입자 수
            int emoticonMoney = 0; // 현재 이모티콘 매출 금액

            for (int[] user : users) {
                int rate = user[0], maxPrice = user[1];
                int curMoney = 0; // 현재 유저의 사용 금액
                for (int[] newEmoticon : newEmoticons) {
                    int discountRate = newEmoticon[0], emoticonPrice = newEmoticon[1];
                    if (discountRate >= rate) { // 이모티콘의 할인율이 유저가 원하는 할인율 이상인 경우(유저가 이모티콘을 구매하는 경우)
                        curMoney += emoticonPrice;
                    }
                }

                if (curMoney >= maxPrice) { // 유저가 구매한 금액이 최대 금액을 초과하는 경우(이모티콘 플러스 가입하는 경우)
                    curUser++;
                } else {
                    emoticonMoney += curMoney;
                }
            }

            // 우선순위 : 이모티콘 플러스 가입자 수 -> 이모티콘 매출 금액
            if (curUser > countOfUser) {
                countOfUser = curUser;
                money = emoticonMoney;
            } else if (curUser == countOfUser && emoticonMoney > money) {
                money = emoticonMoney;
            }

            return;
        }

        // 이모티콘에 할인율을 계속 다르게 적용하며 탐색
        for (int curDis : discounts) {
            newEmoticons[emoticonsIdx] = new int[]{curDis,
                emoticons[emoticonsIdx] - emoticons[emoticonsIdx] / 100 * curDis};
            findMax(users, emoticons, emoticonsIdx + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            solution(new int[][]{{40, 10000}, {25, 10000}}, new int[]{7000, 9000})));
        System.out.println(Arrays.toString(solution(
            new int[][]{{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200},
                {32, 6900}}, new int[]{1300, 1500, 1600, 4900})));
    }
}
