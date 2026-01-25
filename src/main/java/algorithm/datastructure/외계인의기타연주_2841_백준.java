package main.java.algorithm.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class 외계인의기타연주_2841_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Map<Integer, Stack<Integer>> map = new HashMap<>();
        int result = 0;
        for (int i = 1; i <= N; i++) {
            line = br.readLine();
            st = new StringTokenizer(line, " ");

            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            Stack<Integer> stack = map.get(n);
            if (stack == null) {
                stack = new Stack<>();
                stack.add(p);
                map.put(n, stack);
                result++;
            } else {
                Integer peek = stack.peek();
                if (p > peek) {
                    stack.add(p);
                    map.put(n, stack);
                    result++;
                } else if (p == peek) {
                    continue;
                } else if (p < peek) {

                    while (true) {

                        if (stack.isEmpty()) {
                            stack = new Stack<>();
                            stack.add(p);
                            map.put(n, stack);
                            result++;
                            break;
                        }

                        peek = stack.peek();
                        if (p > peek) {
                            stack.add(p);
                            map.put(n, stack);
                            result++;
                            break;
                        } else if (p == peek) {
                            map.put(n, stack);
                            break;
                        } else if (p < peek) {
                            stack.pop();
                            result++;
                        }
                    }

                }
            }
        }

        System.out.println(result);
    }
}
