package main.java.algorithm.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 에디터_1406_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        Stack<Character> stack = new Stack<>();
        Stack<Character> subStack = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            char value = line.charAt(i);

            stack.add(value);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String val = br.readLine();

            if (val.startsWith("P")) {
                StringTokenizer st = new StringTokenizer(val, " ");
                String P = st.nextToken();
                char value = st.nextToken().charAt(0);

                stack.add(value);

                continue;
            }

            if (val.equals("L")) {
                if (!stack.isEmpty()) {
                    Character pop = stack.pop();
                    subStack.add(pop);
                }
            } else if (val.equals("D")) {
                if (!subStack.isEmpty()) {
                    Character poll = subStack.pop();
                    stack.add(poll);
                }
            } else if (val.equals("B")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
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
