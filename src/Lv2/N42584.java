package Lv2;

import java.util.Arrays;
import java.util.Stack;

// 주식가격
public class N42584 {
    static class MyClass{
        int idx;
        int num;

        public MyClass(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }

    /*
    접근
    반복문을 돌면서 수와 해당 인덱스를 스택에 저장한다.
    현재 수 다음에 오는 수가 작아지는 경우 스택에 저장된 값들과 비교를 진행한다.
    비교하며 다음 수보다 더 큰 수가 있다면 해당 초 뒤에 감소한다는 뜻이므로 다음 수의 인덱스 - 현재 비교하는 수의 인덱스를 저장한다.
    더 작은 값들은 아직 증가하는 중이므로 다시 스택에 넣는다.
    반복문을 끝난 후 스택이 남아있다면 남아있는 수들은 계속 증가하기만 한 수다.
    스택을 반복하면서 몇 초간 증가했는지를 구해서 저장한다.
     */
    public static int[] solution(int[] prices){
        int[] result = new int[prices.length];
        Stack<MyClass> stack = new Stack<>();
        for (int i = 0; i < prices.length - 1; i++) {
            int cur = prices[i];
            int next = prices[i + 1];
            if(cur > next){ // 다음 수가 작아지는 경우에만 비교
                result[i] = 1; // 작아지는 경우에 도달한 cur은 바로 1초 뒤에 감소하므로 1을 저장
                int n = stack.size(); // 현재 스택만큼만 반복한다.(다시 스택에 넣는 경우도 있기 때문)
                for (int j = 0; j < n; j++) {
                    MyClass pop = stack.pop();
                    int idx = pop.idx;
                    int num = pop.num;
                    if(num > next){ // 저장되어 있는 정보 중 next보다 큰 수가 있다면 그 수는 next에 도달하면 감소한다는 뜻
                        result[idx] = i + 1 - idx; // 몇 초뒤인지 구해서 저장
                    }else{
                        stack.push(pop); // 계속 증가중이라면 다시 스택에 넣는다.
                    }
                }
            }else{ // 계속 커지는 경우
                stack.push(new MyClass(i, cur)); // 정보를 스택에 저장한다.
            }
        }

        if(!stack.isEmpty()){ // 반복문 종료 후 아직 스택이 남아있다면
            while(!stack.isEmpty()){
                MyClass pop = stack.pop();
                int idx = pop.idx;

                result[idx] = result.length - idx - 1; // 해당 수들은 감소 없이 계속 증가하는 수이다.
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));
    }
}
