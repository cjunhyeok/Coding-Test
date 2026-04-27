package main.java.algorithm.datastructure.프로그래머스;

import java.util.Stack;

public class 올바른괄호_프로그래머스 {

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);

            if (value == '(') {
                stack.add(value);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                if (stack.peek() == ')') {
                    return false;
                }

                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
