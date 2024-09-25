package Lv1;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class N340213 {

    static LocalTime videoTime;
    static LocalTime posTime;
    static LocalTime opStartTime;
    static LocalTime opEndTime;

    public static String solution(String video_len, String pos, String op_start, String op_end,
        String[] commands) {

        String[] videoLen = video_len.split(":");
        String[] posSplit = pos.split(":");
        String[] opStart = op_start.split(":");
        String[] opEnd = op_end.split(":");
        videoTime = getTime(videoLen); // 전체 동영상 시간
        posTime = getTime(posSplit); // 현재 재생위치
        opStartTime = getTime(opStart); // 오프닝 시작 위치
        opEndTime = getTime(opEnd); // 오프닝 끝 위치

        skipOp(); // 오프닝 스킵

        for (String command : commands) {
            if (command.equals("prev")) {
                moveToPrev(); // 10초 전으로 이동
            } else {
                moveToNext(); // 10초 후로 이동
            }

            skipOp(); // 오프닝 스킵
        }

        return posTime.format(DateTimeFormatter.ofPattern("mm:ss"));
    }

    // 10초 후로 이동하는 메소드
    private static void moveToNext() {

        posTime = posTime.plusSeconds(10);
        if (posTime.isAfter(videoTime)) { // 전체 동영상 시간을 넘어가는 경우
            posTime = videoTime;
        }
    }

    // 10초 전으로 이동하는 메소드
    private static void moveToPrev() {

        int minute = posTime.getMinute();
        int second = posTime.getSecond();

        if (minute == 0 && second < 10) { // 현재 재생위치10초 전으로 이동하면 0초가 되는 경우
            posTime = LocalTime.of(0, 0, 0);
            return;
        }

        posTime = posTime.minusSeconds(10);
    }

    // 오프닝 스킵하는 메소드
    private static void skipOp() {

        if (!posTime.isBefore(opStartTime) && !posTime.isAfter(opEndTime)) {
            posTime = opEndTime;
        }
    }

    // 문자열로 표현된 시간 LocalTime타입으로 변경하는 메소드
    private static LocalTime getTime(String[] split) {

        int min = Integer.parseInt(split[0]);
        int sec = Integer.parseInt(split[1]);

        return LocalTime.of(0, min, sec);
    }

    public static void main(String[] args) {

        System.out.println(
            solution("34:33", "13:00", "00:55", "02:55", new String[]{"next", "prev"}));
        System.out.println(
            solution("10:55", "00:05", "00:15", "06:55", new String[]{"prev", "next", "next"}));
        System.out.println(solution("07:22", "04:05", "00:15", "04:07", new String[]{"next"}));
        System.out.println(solution("30:00", "29:55", "01:00", "01:30", new String[]{"next"}));
    }
}
