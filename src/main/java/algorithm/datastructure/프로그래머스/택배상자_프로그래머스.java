package main.java.algorithm.datastructure.프로그래머스;

import java.util.Stack;

public class 택배상자_프로그래머스 {

    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        int currentIndex = 1;
        for (int i = 0; i < order.length; i++) {
            int value = order[i];

            if (value == currentIndex) {
                answer++;
                currentIndex++;
                continue;
            }

            boolean isCorrect = true;
            while (currentIndex <= order.length + 1) {

                if (stack.isEmpty()) {
                    stack.add(currentIndex);
                    currentIndex++;
                    continue;
                }

                Integer peek = stack.peek();
                if (peek == value) {
                    stack.pop();
                    answer++;
                    break;
                } else if (peek <= value) {
                    stack.add(currentIndex);
                    currentIndex++;
                } else {
                    isCorrect = false;
                    break;
                }
            }

            if (!isCorrect) {
                break;
            }
        }

        return answer;
    }
}
