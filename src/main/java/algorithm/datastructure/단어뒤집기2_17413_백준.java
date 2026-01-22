package main.java.algorithm.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 단어뒤집기2_17413_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        List<Character> list = new ArrayList<>();
        Stack<Character> stack = new Stack<>();

        boolean isOpen = false;

        for (int i = 0; i < S.length(); i++) {
            char value = S.charAt(i);

            if (value == '<') {

                while (!stack.isEmpty()) {
                    while (!stack.isEmpty()) {
                        list.add(stack.pop());
                    }
                }

                isOpen = true;
                list.add(value);

            } else if (value == '>') {

                isOpen = false;
                list.add(value);

            } else if (value == ' ') {

                if (!isOpen) {
                    while (!stack.isEmpty()) {
                        list.add(stack.pop());
                    }
                }

                list.add(value);

            } else {

                if (isOpen) {
                    list.add(value);
                } else {
                    stack.add(value);
                }
            }
        }

        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            sb.append(c);
        }

        System.out.println(sb);
    }
}
