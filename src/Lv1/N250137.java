package Lv1;

// [PCCP 기출 문제] 1번 / 붕대 감기
public class N250137 {
    public static int solution(int[] bandage, int health, int[][] attacks) {
        int time = bandage[0];
        int healthPerSec = bandage[1];
        int plusHealth = bandage[2];
        int curHealth = health;

        int idx = 0;
        int successCnt = 0;
        for (int i = 1; i <= attacks[attacks.length - 1][0]; i++) {
            if (curHealth <= 0) {
                return -1;
            }

            // 몬스터가 공격하는 시간과 데미지
            int sec = attacks[idx][0];
            int damage = attacks[idx][1];

            if (i == sec) { // 몬스터가 공격했을 때
                curHealth -= damage;
                idx++;
                successCnt = 0;
                continue;
            }

            successCnt++;
            if (successCnt == time) { // 보너스 회복 타임에 도달했을 때
                successCnt = 0;
                curHealth += plusHealth;
            }

            if (curHealth < health) {
                curHealth += healthPerSec;
            }

            if (curHealth > health) {
                curHealth = health;
            }
        }

        if (curHealth <= 0) {
            return -1;
        }

        return curHealth;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 1, 5}, 30, new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}}));
        System.out.println(solution(new int[]{3, 2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}}));
        System.out.println(solution(new int[]{4, 2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}}));
        System.out.println(solution(new int[]{1, 1, 1}, 5, new int[][]{{1, 2}, {3, 2}}));
        System.out.println(solution(new int[]{3, 20, 10}, 100, new int[][]{{2, 30}, {5, 30}, {7, 30}}));
    }
}
