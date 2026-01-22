package main.java.algorithm.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 키로거_5397_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {

            Stack<Character> stack = new Stack<>();
            Stack<Character> subStack = new Stack<>();

            String line = br.readLine();

            for (int i = 0; i < line.length(); i++) {
                char value = line.charAt(i);

                if (value == '<') {
                    if (!stack.isEmpty()) {
                        subStack.add(stack.pop());
                    }
                } else if (value == '>') {
                    if (!subStack.isEmpty()) {
                        stack.add(subStack.pop());
                    }

                } else if (value == '-') {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.add(value);
                }
            }

            while (!subStack.isEmpty()) {
                stack.add(subStack.pop());
            }

            StringBuilder sb = new StringBuilder();
            for (Character c : stack) {
                sb.append(c);
            }

            System.out.println(sb);
        }
    }
}
