package main.java.algorithm.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌세상_4949_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();

            if (line.equals(".")) {
                break;
            }

            stack.clear();
            boolean isCorrect = true;

            for (int i = 0; i < line.length(); i++) {
                char value = line.charAt(i);

                if (value == '(') {
                    stack.add(value);
                } else if (value == ')') {
                    if (stack.isEmpty()) {
                        isCorrect = false;
                        break;
                    }

                    Character peek = stack.peek();

                    if (peek.equals('(')) {
                        stack.pop();
                    } else {
                        isCorrect = false;
                        break;
                    }

                } else if (value == '[') {
                    stack.add(value);
                } else if (value == ']') {
                    if (stack.isEmpty()) {
                        isCorrect = false;
                        break;
                    }

                    Character peek = stack.peek();

                    if (peek.equals('[')) {
                        stack.pop();
                    } else {
                        isCorrect = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) {
                isCorrect = false;
            }

            if (isCorrect) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }

        System.out.println(sb);
    }
}
