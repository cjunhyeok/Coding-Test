package main.java.algorithm.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 쇠막대기_10799_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        Stack<Character> stack = new Stack<>();

        int result = 0;
        boolean isBeforeOpen = false;

        for (int i = 0; i < line.length(); i++) {
            char value = line.charAt(i);

            if (value == '(') {
                stack.add(value);
                isBeforeOpen = true;
            } else {
                Character peek = stack.peek();

                if (isBeforeOpen) {
                    stack.pop();
                    result = result + stack.size();
                } else {
                    stack.pop();
                    result = result + 1;
                }

                isBeforeOpen = false;
            }
        }

        System.out.println(result);
    }
}
