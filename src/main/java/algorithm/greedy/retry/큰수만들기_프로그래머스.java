package main.java.algorithm.greedy.retry;

import java.util.Stack;

public class 큰수만들기_프로그래머스 {

    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char value = number.charAt(i);

            while (!stack.isEmpty()) {
                if (k == 0) {
                    break;
                }

                Character peek = stack.peek();

                if (peek >= value) {
                    break;
                }

                stack.pop();
                k--;
            }

            stack.add(value);
        }

        for (int i = 0; i < k; i++) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
