package Lv1;

import java.util.*;

// 가장 많이 받은 선물
public class N258712 {
    public static int solution(String[] friends, String[] gifts) {
        Map<String, List<String>> giveTo = new HashMap<>(); // 선물한 사람(key)과 선물 받은 사람(value)를 저장
        Arrays.stream(gifts).forEach(x -> {
            String[] names = x.split(" ");
            String give = names[0];
            String gave = names[1];
            List<String> list = giveTo.getOrDefault(give, new ArrayList<>());
            list.add(gave);
            giveTo.put(give, list);
        });

        int[] count = new int[friends.length]; // 다음 달에 선물 받는 수
        for (int i = 0; i < friends.length; i++) {
            String nameA = friends[i];
            for (int j = 0; j < friends.length; j++) {
                String nameB = friends[j];
                int give = 0;
                int gave = 0;
                if (j != i) {
                    give = (int) giveTo.getOrDefault(nameA, new ArrayList<>()).stream().filter(x -> x.equals(nameB)).count(); // A가 B에게 선물한 수
                    gave = (int) giveTo.getOrDefault(nameB, new ArrayList<>()).stream().filter(x -> x.equals(nameA)).count(); // B가 A에게 선물한 수
                } else {
                    continue;
                }

                if (give > gave) {
                    count[i]++;
                } else if (give == gave) {
                    int giveRate = getGiftRate(nameA, giveTo); // A의 선물지수
                    int gaveRate = getGiftRate(nameB, giveTo); // B의 선물지수

                    if (giveRate > gaveRate) {
                        count[i]++;
                    }
                }
            }
        }

        return Arrays.stream(count).max().getAsInt();
    }

    // 선물 지수 구하는 메소드
    private static int getGiftRate(String name, Map<String, List<String>> giveTo) {
        int give = giveTo.getOrDefault(name, new ArrayList<>()).size(); // 선물한 갯수
        int gave = 0;
        for (Map.Entry<String, List<String>> entry : giveTo.entrySet()) { // 선물 받은 갯수
            List<String> value = entry.getValue();
            gave += (int) value.stream().filter(x -> x.equals(name)).count(); // value에는 선물 받은 사람의 이름이 들어있으므로 그 이름이 name과 같다면 name이 선물 받은 것이 된다.
        }

        return give - gave;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"muzi", "ryan", "frodo", "neo"}, new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}));
        System.out.println(solution(new String[]{"joy", "brad", "alessandro", "conan", "david"}, new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"}));
        System.out.println(solution(new String[]{"a", "b", "c"}, new String[]{"a b", "b a", "c a", "a c", "a c", "c a"}));
    }
}
