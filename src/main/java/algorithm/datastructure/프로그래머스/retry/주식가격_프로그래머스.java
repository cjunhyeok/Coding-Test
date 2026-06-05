package main.java.algorithm.datastructure.프로그래머스.retry;

import java.util.Stack;

public class 주식가격_프로그래머스 {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];

            if (stack.isEmpty()) {
                stack.add(i);
                continue;
            }

            while (!stack.isEmpty()) {
                Integer peek = stack.peek();
                int peekPrice = prices[peek];

                if (peekPrice <= price) {
                    break;
                }

                stack.pop();
                int time = i - peek;
                answer[peek] = time;
            }

            stack.add(i);
        }

        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            answer[pop] = prices.length - 1 - pop;
        }

        return answer;
    }
}
