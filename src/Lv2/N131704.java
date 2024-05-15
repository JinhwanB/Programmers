package Lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 택배상자
public class N131704 {
    public static int solution(int[] order) {
        List<Integer> result = new ArrayList<>(); // 트럭
        Stack<Integer> stack = new Stack<>(); // 보조 컨테이너 벨트
        int idx = 0; // 트럭에 실어야할 박스
        int curIdx = 0; // 현재 트럭에 실을 수 있는 박스
        while (idx < order.length) {
            int turn = order[idx]; // 실어야 하는 박스
            if (!stack.isEmpty() && stack.peek() == order[turn - 1]) { // 보조 컨테이너 벨트에 있는 경우 빼서 트럭에 실는다.
                result.add(stack.pop());
                idx++;
                continue;
            }

            if (curIdx == order.length) { // 현재 실어야할 박스를 실을 수 없는 경우
                break;
            }

            // 보조 컨테이너 벨트에 없는 경우
            int cur = order[curIdx]; // 기존의 컨테이너 벨트에서 실을 수 있는 박스
            if (cur == order[turn - 1]) { // 이 박스가 현재 트럭에 실어야하는 박스인 경우
                result.add(cur);
                idx++;
                curIdx++;
                continue;
            }

            stack.add(cur); // 현재 실어야하는 박스가 아니라면 보조 컨테이너 벨트로 옮긴다.
            curIdx++;
        }

        return result.size();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 3, 1, 2, 5}));
        System.out.println(solution(new int[]{5, 4, 3, 2, 1}));
    }
}
