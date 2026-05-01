package main.java.algorithm.greedy;

import java.util.*;

public class 큰수만들기_프로그래머스 {
    public String solution(String number, int k) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char value = number.charAt(i);

            while (true) {
                if (k == 0) {
                    break;
                }
                if (stack.isEmpty()) {
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

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
