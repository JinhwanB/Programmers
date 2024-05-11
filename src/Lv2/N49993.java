package Lv2;

import java.util.HashMap;
import java.util.Map;

// 스킬트리
public class N49993 {
    public static int solution(String skill, String[] skill_trees) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < skill.length(); i++) {
            char c = skill.charAt(i);
            map.put(c, i); // map 에 key : 스킬, value : 스킬의 순서 (0이 첫 번째) 저장
        }

        int count = 0;
        loop:
        for (String skillTree : skill_trees) {
            int[] tree = new int[skill.length()]; // skill 문자열 크기만큼 배열을 만들어 순서대로 스킬을 배우는지 체크해간다.
            for (int i = 0; i < skillTree.length(); i++) {
                char c = skillTree.charAt(i);
                int idx = map.getOrDefault(c, -1); // map 에서 스킬 순서에 해당하는 스킬이라면 스킬의 순서를 가져오고 아니라면 -1
                if (idx == 0) { // 첫 번째 스킬이라면
                    tree[idx] = 1; // 배웠다고 체크
                } else if (idx > 0) { // 두 번째 이상에 해당하는 스킬이라면
                    if (tree[idx - 1] == 1) { // 그 전 스킬이 배운 상태일 때
                        tree[idx] = 1; // 배웠다고 체크
                    } else { // 전 스킬을 안 배운경우
                        continue loop; // 다음 문자열을 확인
                    }
                }
            }

            count++; // 반복문이 끝난 경우는 해당 문자열이 스킬트리가 될 수 있으므로 count 증가
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}
