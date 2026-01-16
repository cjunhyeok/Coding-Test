package main.java.algorithm.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호_9012_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            Stack<Character>  stack = new Stack<>();
            boolean isYes = true;

            for (int j = 0; j < line.length(); j++) {
                char val = line.charAt(j);

                if (val == '(') {
                    stack.push(val);
                } else {
                    if (stack.isEmpty()) {
                        isYes = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (stack.isEmpty() && isYes) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
