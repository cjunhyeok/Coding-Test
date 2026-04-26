package main.java.algorithm.datastructure.프로그래머스;

import java.util.Stack;

public class 같은숫자는싫어_프로그래머스 {

    public int[] solution(int []arr) {
        int[] answer = {};

        Stack<Integer> stack = new Stack<>();
        for (int value : arr) {
            if (!stack.isEmpty()) {

                Integer peek = stack.peek();
                if (!peek.equals(value)) {
                    stack.add(value);
                }

            } else {
                stack.add(value);
            }
        }

        answer = new int[stack.size()];
        int index = 0;
        for (Integer value : stack) {
            answer[index] = value;
            index++;
        }

        return answer;
    }
}
