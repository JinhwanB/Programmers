package Lv2;

import java.util.ArrayList;
import java.util.List;

// [카카오 인턴] 수식 최대화
public class N67257 {

    static long result = 0;

    public static long solution(String expression) {
        String[] numbers = expression.split("[^0-9]"); // 숫자 모음
        String[] operators = expression.split("[0-9]+"); // 연산자 모음
        String[] o = {"*", "+", "-"};
        boolean[] visited = new boolean[o.length];

        List<Long> list = new ArrayList<>();
        for (String number : numbers) {
            list.add(Long.parseLong(number));
        }

        List<String> oper = new ArrayList<>();
        for (String operator : operators) {
            if (!operator.isEmpty()) {
                oper.add(operator);
            }
        }

        solve(list, oper, o, visited);

        return result;
    }

    // 연산자의 우선순위를 바꿔가며 모든 경우의 수 확인하여 가장 최댓값으로 result를 갱신
    private static void solve(List<Long> list, List<String> operators, String[] o, boolean[] visited) {
        if (list.size() == 1) {
            result = Math.max(result, Math.abs(list.get(0))); // 음수인 경우는 절댓값으로
            return;
        }

        for (int i = 0; i < o.length; i++) {
            String curOp = o[i];
            if (visited[i]) { // 현재 연산자가 계산한 연산자인 경우 continue
                continue;
            }

            // 현재 수와 연산자들을 저장해 둔다. -> 다시 연산자의 우선순위를 바꿀 경우에 사용하기 위해
            List<Long> list2 = new ArrayList<>(List.copyOf(list));
            List<String> operators2 = new ArrayList<>(List.copyOf(operators));

            // 연산 과정
            for (int j = 0; j < operators.size(); j++) {
                String cur = operators.get(j);
                if (cur.equals(curOp)) {
                    long firstNum = list.get(j);
                    long secondNum = list.get(j + 1);
                    switch (curOp) {
                        case "*" -> firstNum *= secondNum;
                        case "+" -> firstNum += secondNum;
                        case "-" -> firstNum -= secondNum;
                    }

                    // 연산 후 결과를 저장 -> 연산에 사용한 수를 지우고 연산한 결과를 저장한다.
                    list.remove(j);
                    list.remove(j);
                    list.add(j, firstNum);
                    operators.remove(j); // 연산한 연산자 또한 지운다.
                    j--;
                }
            }

            visited[i] = true;
            solve(list, operators, o, visited);
            visited[i] = false;
            list = list2;
            operators = operators2;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20"));
        result = 0;
        System.out.println(solution("50*6-3*2"));
    }
}
