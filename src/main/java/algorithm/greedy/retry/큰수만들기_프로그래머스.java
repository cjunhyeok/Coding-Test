package main.java.algorithm.greedy.retry;

import java.util.Stack;

public class 큰수만들기_프로그래머스 {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {

            int value = number.charAt(i) - '0';

            while (!stack.isEmpty()) {
                if (k == 0) {
                    break;
                }

                Integer peek = stack.peek();
                if (peek < value) {
                    stack.pop();
                    k--;
                } else {
                    break;
                }
            }

            stack.add(value);
        }

        for (int i = 0; i < k; i++) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        for (Integer i : stack) {
            sb.append(i);
        }

        return sb.toString();
    }
}
