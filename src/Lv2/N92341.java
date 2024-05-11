package Lv2;

import java.util.*;

// 주차 요금 계산
public class N92341 {
    public static int[] solution(int[] fees, String[] records) {
        int originMin = fees[0]; // 기본 시간
        int originPrice = fees[1]; // 기본 요금
        int afterMin = fees[2]; // 추가 시간
        int afterPrice = fees[3]; // 추가 요금
        Map<Integer, Integer> minMap = new HashMap<>(); // 처음엔 각 자돋차별 이용 시간 후에는 자동차별 가격
        Map<Integer, String> map = new HashMap<>(); // 출차 관리 -> 입차 시 map에 저장 출차 시 시간 계산 후 map에서 제거
        for (String record : records) {
            String[] arr = record.split(" ");
            int carNum = Integer.parseInt(arr[1]);
            if (map.containsKey(carNum)) { // 이미 입차한 자동차인 경우
                int prevMin = minMap.getOrDefault(carNum, 0);
                String inTime = map.get(carNum);
                int min = getMin(inTime, arr[0]);
                minMap.put(carNum, prevMin + min);
                map.remove(carNum); // 시간을 계산 후 map에서 제거한다.
            } else { // 입차한 적이 없는 차라면
                map.put(carNum, arr[0]);
            }
        }

        // 입차 하고 출차 기록이 없어 23:59에 출차한 것으로 계산
        if (!map.isEmpty()) {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                int carNum = entry.getKey();
                int prevMin = minMap.getOrDefault(carNum, 0);
                String inTime = entry.getValue();
                int min = getMin(inTime, "23:59");
                minMap.put(carNum, prevMin + min);
            }
        }

        // 이용 시간을 가격으로 변환 후 minMap에 가격 저장
        for (Map.Entry<Integer, Integer> entry : minMap.entrySet()) {
            int carNum = entry.getKey();
            int min = entry.getValue();
            getPrice(min, originMin, minMap, carNum, originPrice, afterMin, afterPrice);
        }

        int[] answer = new int[minMap.size()];
        List<Integer> list = new ArrayList<>(minMap.keySet());
        list.sort(Comparator.naturalOrder()); // 자동차의 번호가 작은 순으로 출력하기 위한 sort
        for (int i = 0; i < answer.length; i++) {
            answer[i] = minMap.get(list.get(i));
        }

        return answer;
    }

    // 이용 시간만큼 내야 하는 가격 구하는 메소드
    private static void getPrice(int min, int originMin, Map<Integer, Integer> result, int carNum, int originPrice, int afterMin, int afterPrice) {
        if (min <= originMin) { // 기본 시간만큼 이용하거나 그보다 적게 이용한 경우
            result.put(carNum, originPrice);
        } else { // 기본 시간을 초과해서 이용한 경우
            int after = min - originMin;
            int m = after / afterMin;
            if (after % afterMin != 0) { // 올림 처리
                m += 1;
            }
            int price = m * afterPrice;
            result.put(carNum, originPrice + price);
        }
    }

    // 주차장 이용 시간을 구하는 메소드
    private static int getMin(String in, String out) {
        String[] inArr = in.split(":");
        String[] outArr = out.split(":");
        int inHour = Integer.parseInt(inArr[0]);
        int inMin = Integer.parseInt(inArr[1]);
        int outHour = Integer.parseInt(outArr[0]);
        int outMin = Integer.parseInt(outArr[1]);
        if (inHour == outHour) {
            return outMin - inMin;
        }

        // 1시간 이상 이용한 경우
        if (outMin >= inMin) {
            return (outHour - inHour) * 60 + Math.abs(outMin - inMin);
        } else {
            return (outHour - inHour) * 60 + outMin - inMin;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"})));
        System.out.println(Arrays.toString(solution(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"})));
        System.out.println(Arrays.toString(solution(new int[]{1, 461, 1, 10}, new String[]{"00:00 1234 IN"})));
    }
}
