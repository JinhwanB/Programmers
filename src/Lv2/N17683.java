package Lv2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// [3차] 방금그곡
public class N17683 {
    // 문제 조건에 추가안된 부분이 있다. 전체 알파벳에 #이 붙은 경우를 확인해야 테케가 통과되는듯 하다.
    public static String solution(String m, String[] musicinfos) {
        m = replaceShap(m); // #이 붙은 알파벳 소문자로 변경

        int min = 0; // 재생 시간
        String result = "";
        for (String musicinfo : musicinfos) {
            String[] split = musicinfo.split(",");
            String startTime = split[0], endTime = split[1], title = split[2], music = split[3];

            music = replaceShap(music); // # 붙은 알파벳 소문자로 변경
            int musicTime = music.length(); // 기억하고 있는 음의 길이
            int totalTime = time(startTime, endTime); // 라디오에서 재생된 곡의 길이

            StringBuilder sb = new StringBuilder();
            if (musicTime == totalTime) { // 악보의 음의 길이와 재생 시간이 같은 경우
                sb = new StringBuilder(music);
            } else if (musicTime < totalTime) { // 악보의 음이 재생 시간보다 짧은 경우 -> 반복재생
                sb = new StringBuilder(music);
                for (int i = 0; i < totalTime / musicTime - 1; i++) {
                    sb.append(music);
                }
                sb.append(music, 0, totalTime % musicTime);
            } else { // 악보의 음이 재생 시간보다 긴 경우 -> 중간에 끊김
                sb.append(music, 0, totalTime);
            }

            if (sb.toString().contains(m) && totalTime > min) { // 기억한 음을 포함한 악보인 경우이면서 재생시간이 가장 길어야 함
                min = totalTime;
                result = title;
            }
        }

        if (result.isEmpty()) {
            return "(None)";
        }

        return result;
    }

    // #이 붙은 알파벳을 찾아 해당 알파벳 소문자로 대체한다 (예: C# -> c)
    private static String replaceShap(String s) {
        Pattern pattern = Pattern.compile("[A-Z]#");
        Matcher matcher = pattern.matcher(s);
        StringBuilder sb = new StringBuilder();

        while (matcher.find()) {
            String group = matcher.group(); // pattern에 해당하는 단어까지의 그룹
            matcher.appendReplacement(sb, group.substring(0, 1).toLowerCase()); // #의 앞부분인 알파벳을 소문자로 대체하여 append
        }
        matcher.appendTail(sb); // 남아있는 문자 append

        return sb.toString();
    }

    // 음악의 총 재생시간이 몇 분인지 구함
    private static int time(String startTime, String endTime) {
        String[] start = startTime.split(":");
        String[] end = endTime.split(":");
        int startHour = Integer.parseInt(start[0]), startMin = Integer.parseInt(start[1]);
        int endHour = Integer.parseInt(end[0]), endMin = Integer.parseInt(end[1]);

        if (startHour == endHour) { // 시가 같다면 분끼리만 빼주면 됨
            return endMin - startMin;
        } else { // 시가 다르다면 시가 차이나는 만큼을 분으로 바꿔 끝나는 시간의 분과 더한 후 시작한 시간의 분을 뺀다
            return endMin + ((endHour - startHour) * 60) - startMin;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
        System.out.println(solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
    }
}
