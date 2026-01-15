package main.java.algorithm.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 스택수열_1874_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            values.add(value);
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        List<Integer> resultList = new ArrayList<>();
        int listIndex = 0;
        int value = 1;

        while (true) {

            // 4 3 6 8 7 5 2 1
            Integer listValue = values.get(listIndex);
            // value -> 1 2 3 4 5 6 7 8
            if (value > N) {
                break;
            }

            if (stack.isEmpty()) {
                stack.add(value);
                value++;
                sb.append("+\n");
                continue;
            }

            Integer peek = stack.peek();
            if (peek == listValue) {
                Integer pop = stack.pop();
                resultList.add(pop);
                listIndex++;
                sb.append("-\n");
            } else {
                stack.push(value);
                value++;
                sb.append("+\n");
            }
        }

        while (!stack.isEmpty()) {
            resultList.add(stack.pop());
            sb.append("-\n");
        }

        boolean isCorrect = true;
        for (int i = 0; i < N; i++) {
            Integer val = values.get(i);
            Integer resultValue = resultList.get(i);

            if (val != resultValue) {
                isCorrect = false;
                break;
            }
        }

        if (isCorrect) {
            System.out.println(sb.toString());
        } else {
            System.out.println("NO");
        }
    }
}
