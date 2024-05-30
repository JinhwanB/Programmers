package Lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 호텔 대실
public class N155651 {

    static class Time {
        int hour;
        int minute;

        public Time(int hour, int minute) {
            this.hour = hour;
            this.minute = minute;
        }
    }

    public static int solution(String[][] book_time) {
        PriorityQueue<Time[]> reservations = new PriorityQueue<>((o1, o2) -> { // 예약 목록
            if (o1[0].hour == o2[0].hour) {
                if (o1[0].minute == o2[0].minute) {
                    if (o1[1].hour == o2[1].hour) {
                        return o1[1].minute - o2[1].minute;
                    }

                    return o1[1].hour - o2[1].hour;
                }

                return o1[0].minute - o2[0].minute;
            }

            return o1[0].hour - o2[0].hour;
        });

        List<Time> rooms = new ArrayList<>(); // 방

        for (String[] times : book_time) { // 예약 목록 저장
            Time[] cur = new Time[2];
            for (int i = 0; i < times.length; i++) {
                String time = times[i];
                String[] split = time.split(":");
                int hour = Integer.parseInt(split[0]);
                int minute = Integer.parseInt(split[1]);
                cur[i] = new Time(hour, minute);
            }
            reservations.offer(cur);
        }

        rooms.add(new Time(0, 0)); // 처음 1개의 방 저장

        while (!reservations.isEmpty()) {
            Time[] poll = reservations.poll();
            Time in = poll[0];
            Time out = poll[1];

            for (Time room : rooms) {
                if (in.hour > room.hour || (in.hour == room.hour && in.minute >= room.minute)) { // 현재 예약으로 사용 가능한 방의 경우
                    rooms.remove(room); // 기존의 방 시간을 제거 후 예약의 체크아웃 시간의 10분을 더한 것을 저장
                    break;
                }
            }

            // 예약이 사용 불가한 경우 새로운 방을 저장
            out.minute += 10;
            if (out.minute > 59) {
                out.hour += 1;
                out.minute = (out.minute - 59) - 1;
            }
            rooms.add(out);
        }

        return rooms.size();
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}}));
        System.out.println(solution(new String[][]{{"09:10", "10:10"}, {"10:20", "12:20"}}));
        System.out.println(solution(new String[][]{{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}}));
    }
}
