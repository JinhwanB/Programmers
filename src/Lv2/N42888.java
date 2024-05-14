package Lv2;

import java.util.*;

// 오픈채팅방
public class N42888 {
    private static final String ENTER_STRING = "님이 들어왔습니다.";
    private static final String LEAVE_STRING = "님이 나갔습니다.";

    public static String[] solution(String[] record) {
        String enter = "Enter";
        String leave = "Leave";
        Map<String, String> map = new HashMap<>(); // id와 닉네임을 매칭해서 저장한다.
        List<String[]> list = new ArrayList<>(); // 들어오고 나간 순서를 저장한다.
        for (String s : record) {
            String[] split = s.split(" ");
            if (split[0].equals(enter)) {
                map.put(split[1], split[2]); // 들어온 경우 아이디와 닉네임 저장
                list.add(new String[]{split[0], split[1]}); // 들어온 순서 저장
            } else if (split[0].equals(leave)) {
                list.add(new String[]{split[0], split[1]}); // 나간 경우 나간 순서만 저장
            } else {
                map.put(split[1], split[2]); // 닉네임을 변경한 경우 변경된 닉네임을 아이디에 매칭하여 저장
            }
        }

        String[] result = new String[list.size()];
        for (int i = 0; i < result.length; i++) {
            String[] userInfo = list.get(i);
            String enterOrLeave = userInfo[0];
            String id = userInfo[1];
            String nickName = map.get(id);
            result[i] = enterOrLeave.equals(enter) ? nickName + ENTER_STRING : nickName + LEAVE_STRING;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"})));
    }
}
