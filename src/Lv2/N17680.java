package Lv2;

import java.util.LinkedList;
import java.util.Queue;

// [1차] 캐시
public class N17680 {
    public static int solution(int cacheSize, String[] cities) {
        Queue<String> q = new LinkedList<>();
        int result = 0;
        for (String city : cities) {
            String cityName = city.toLowerCase(); // 대소문자를 구분하지 않음
            if (!q.contains(cityName)) { // 캐시에 없으면 cache miss
                q.add(cityName);
                result += 5;
            } else { // 캐시에 있으면 cache hit
                q.remove(cityName);
                q.add(cityName);
                result += 1;
            }

            if (q.size() > cacheSize) { // cacheSize 넘으면 가장 참조가 없는 것 하나 제거(LRU)
                q.poll();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
        System.out.println(solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }
}
