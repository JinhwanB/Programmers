package Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

// 과제 진행하기
public class N176962 {

    static class MyHomeWork {

        String name;
        int startMin;
        int playTime;

        public MyHomeWork(String[] plan) {
            String startTime = plan[1];
            String[] split = startTime.split(":");
            int min = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);

            this.name = plan[0];
            this.startMin = min;
            this.playTime = Integer.parseInt(plan[2]);
        }
    }

    public static String[] solution(String[][] plans) {
        PriorityQueue<MyHomeWork> homeWorks = new PriorityQueue<>(
            Comparator.comparingInt(o -> o.startMin));
        Stack<MyHomeWork> waitList = new Stack<>();
        for (String[] plan : plans) {
            homeWorks.offer(new MyHomeWork(plan));
        }

        List<String> result = new ArrayList<>();
        int time = 0; // 현재 시간
        while (!homeWorks.isEmpty()) {
            MyHomeWork poll = homeWorks.poll();
            MyHomeWork peek = homeWorks.peek();
            if (peek == null) { // 다음 진행할 과제가 없는 경우
                result.add(poll.name);
                break;
            }

            time = poll.startMin;
            int curMin = poll.startMin, nextMin = peek.startMin;
            curMin += poll.playTime; // 현재 진행할 과제를 완료시키는 시간

            if (curMin < nextMin) { // 현재 과제가 완료된 시간이 다음 진행할 과제 시간보다 이전인 경우
                result.add(poll.name);
                time = curMin;
                if (!waitList.isEmpty()) { // 멈춘 과제 실행하기
                    startWait(time, nextMin, waitList, result);
                }
            } else if (curMin == nextMin) { // 현재 과제가 완료된 시간과 다음 과제가 시작할 시간이 같은 경우
                result.add(poll.name);
            } else { // 현재 과제 도중에 다음 과제가 시작되는 경우
                int diffMin = nextMin - time;
                poll.playTime -= diffMin; // 다음 과제를 시작할 시간만큼만 현재 과제를 진행함
                waitList.add(poll);
            }
        }

        while (!waitList.isEmpty()) { // 위 과정 후에 남아있는 과제 진행
            result.add(waitList.pop().name);
        }

        return result.toArray(String[]::new);
    }

    // 잠시 멈춰둔 과제 실행
    private static void startWait(int curMin, int nextMin, Stack<MyHomeWork> waitList,
        List<String> result) {
        while (!waitList.isEmpty()) {
            if (curMin >= nextMin) { // 현재 시간이 다음 과제를 실행해야할 경우
                break;
            }

            MyHomeWork peek = waitList.peek();
            curMin += peek.playTime; // 과제를 완료하는 시간
            if (curMin <= nextMin) { // 과제 완료 시간이 다음 과제 시작 시간보다 먼저 완료되는 경우
                MyHomeWork pop = waitList.pop();
                result.add(pop.name);
            } else { // 과제 도중 다음 과제를 실행해야하는 경우
                curMin -= peek.playTime;
                int diffMin = nextMin - curMin;
                peek.playTime -= diffMin;
                curMin += diffMin;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
            new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"},
                {"math", "12:30", "40"}})));
        System.out.println(Arrays.toString(solution(
            new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"},
                {"history", "14:00", "30"}, {"computer", "12:30", "100"}})));
        System.out.println(Arrays.toString(solution(
            new String[][]{{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"},
                {"ccc", "12:40", "10"}})));
    }
}
