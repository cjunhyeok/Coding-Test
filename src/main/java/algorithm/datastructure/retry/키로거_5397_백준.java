package main.java.algorithm.datastructure.retry;

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
            String line = br.readLine();

            Stack<Character> stack = new Stack<>();
            Stack<Character> sideStack = new Stack<>();

            for (int i = 0; i < line.length(); i++) {
                char value = line.charAt(i);

                if (value == '<') {
                    if (!stack.isEmpty()) {
                        Character pop = stack.pop();
                        sideStack.add(pop);
                    }
                } else if (value == '>') {
                    if (!sideStack.isEmpty()) {
                        Character poll = sideStack.pop();
                        stack.add(poll);
                    }
                } else if (value == '-') {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.add(value);
                }
            }

            StringBuilder sb = new StringBuilder();
            if (!stack.isEmpty()) {
                for (Character c : stack) {
                    sb.append(c);
                }
            }

            while (!sideStack.isEmpty()) {
                sb.append(sideStack.pop());
            }

            System.out.println(sb);
        }
    }
}
