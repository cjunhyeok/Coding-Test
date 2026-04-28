package main.java.algorithm.datastructure.프로그래머스;

import java.util.Stack;

public class 주식가격_프로그래머스 {

    public int[] solution(int[] prices) {

        int length = prices.length;
        int[] answer = new int[length];
        Stack<Integer> stack = new Stack<>();

        // 모든 가격 탐색
        for (int currentIndex = 0; currentIndex < length; currentIndex++) {
            int currentPrice = prices[currentIndex];

            while (!stack.isEmpty()) {

                int prevIndex = stack.peek();
                int prevPrice = prices[prevIndex];

                if (prevPrice <= currentPrice) {
                    break;
                }

                stack.pop();
                int maintain = currentIndex - prevIndex;
                answer[prevIndex] = maintain;
            }
            stack.push(currentIndex);
        }

        while (!stack.isEmpty()) {
            int remainIndex = stack.pop();
            int maintain = (length - 1) - remainIndex;
            answer[remainIndex] = maintain;
        }

        return answer;
    }
}
