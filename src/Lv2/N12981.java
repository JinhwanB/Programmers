package Lv2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 영어 끝말잇기
public class N12981 {
    public static int[] solution(int n, String[] words){
        int turn = 1; // 몇 번째 차례인지 나타내는 변수
        boolean success = true; // 성공여부
        int person = 1; // 사람의 번호
        Set<String> set = new HashSet<>(); // 같은 단어가 있는지 판별용
        char prevLast = words[0].charAt(0); // 각 단어의 마지막 문자
        for (String word : words) {
            if(person > n){ // 마지막 사람까지 했다면 다시 1번 순서로 돌아감
                person = 1;
                turn++; // 차례를 증가시킴
            }

            if(!set.add(word) || word.charAt(0) != prevLast){ // 이미 말한 단어를 다시 한 번 말한 경우 또는 마지막 단어로 이어지지 않는 단어인 경우
                success = false; // 실패
                break;
            }

            prevLast = word.charAt(word.length() - 1);
            person++;
        }

        if(success){
            return new int[]{0, 0};
        }else{
            return new int[]{person, turn};
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
        System.out.println(Arrays.toString(solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
        System.out.println(Arrays.toString(solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));
    }
}
