package main.java.algorithm.implementaion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 제로_10773_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        Stack<Long> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            long value = Long.parseLong(br.readLine());

            if (value != 0) {
                stack.add(value);
            } else {
                stack.pop();
            }
        }

        Long result = 0L;
        for (Long value : stack) {
            result = result + value;
        }

        System.out.println(result);
    }
}