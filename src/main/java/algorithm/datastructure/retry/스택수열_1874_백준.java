package main.java.algorithm.datastructure.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 스택수열_1874_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            int value = Integer.parseInt(br.readLine());
            queue.add(value);
        }

        Stack<Integer> stack = new Stack<>();
        int index = 1;
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {

            if (index > N + 1) {
                sb = new StringBuilder();
                sb.append("NO");
                break;
            }

            Integer queuePeek = queue.peek();

            if (stack.isEmpty()) {
                stack.add(index);
                sb.append('+').append('\n');
                index++;
                continue;
            }

            Integer stackPeek = stack.peek();

            if (stackPeek.equals(queuePeek)) {
                sb.append('-').append('\n');
                stack.pop();
                queue.poll();
            } else {
                stack.add(index);
                sb.append('+').append('\n');
                index++;
            }
        }

        System.out.println(sb);
    }
}
