package Lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 다리를 지나는 트럭
public class N42583 {
    static class Truck {
        int weight;
        int location;

        public Truck(int weight, int location) {
            this.weight = weight;
            this.location = location;
        }
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> trucks = new LinkedList<>(); // 전체 트럭
        for (int truckWeight : truck_weights) {
            trucks.add(new Truck(truckWeight, 0));
        }

        List<Truck> list = new ArrayList<>(); // 도착한 트럭
        Queue<Truck> bridge = new LinkedList<>(); // 다리에 있는 트럭
        int time = 0; // 총 시간
        int curWeight = 0; // 다리 위의 트럭 무게
        while (list.size() != truck_weights.length) {
            if (!bridge.isEmpty()) {
                int n = bridge.size();
                for (int i = 0; i < n; i++) { // 다리 위의 트럭 위치를 이동시킨다.
                    Truck poll = bridge.poll();
                    poll.location += 1; // 위치를 1만큼 이동
                    if (poll.location > bridge_length) { // 다리 길이를 넘겼을 때 : 도착했을 때
                        list.add(poll); // 도착 리스트에 저장
                        curWeight -= poll.weight; // 도착한 트럭의 무게를 빼준다.
                    } else { // 도착하지 않았다면
                        bridge.add(poll); // 다시 다리 위의 트럭 큐로 넣는다.
                    }
                }
            }

            Truck peek = trucks.peek();
            // 다음 트럭이 다리에 올라갈 수 있는지 확인
            // 대기 중인 트럭이 있고, 다리에 올라갈 수 있는 최대 트럭 수를 넘지 않았는지, 다리가 견딜 수 있는 최대 무게를 넘어가는지 확인
            if (!trucks.isEmpty() && bridge.size() < bridge_length && peek.weight + curWeight <= weight) {
                Truck poll = trucks.poll();
                poll.location += 1;
                bridge.add(poll);
                curWeight += poll.weight;
            }

            time++;
        }

        return time;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(solution(100, 100, new int[]{10}));
        System.out.println(solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }
}
