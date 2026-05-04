package main.java.algorithm.datastructure.프로그래머스;

import java.util.Stack;

public class 뒤에있는큰수찾기_프로그래머스 {

    public int[] solution(int[] numbers) {
        int length = numbers.length;
        int[] answer = new int[length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            stack.add(numbers[i]);
        }

        Stack<Integer> subStack = new Stack<>();
        answer[length - 1] = -1;
        subStack.add(stack.pop());

        int index = length - 2;

        while (!stack.isEmpty()) {

            Integer pop = stack.pop();

            while (true) {

                if (subStack.isEmpty()) {
                    subStack.add(pop);
                    answer[index] = -1;
                    index--;
                    break;
                }

                Integer peek = subStack.peek();

                if (peek > pop) {
                    answer[index] = peek;
                    subStack.add(pop);
                    index--;
                    break;
                } else {
                    subStack.pop();
                }
            }

        }

        return answer;
    }
}
