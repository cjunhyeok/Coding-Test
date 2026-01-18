package main.java.algorithm.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 프린터큐_1966_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            Queue<Integer[]> queue = new LinkedList<>();

            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line, " ");

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            line = br.readLine();
            st = new StringTokenizer(line, " ");

            for (int index = 0; index < N; index++) {
                int priority = Integer.parseInt(st.nextToken());
                Integer[] value = new Integer[2];

                value[0] = index;
                value[1] = priority;

                queue.add(value);
            }

            int result = 1;

            while (!queue.isEmpty()) {
                Integer[] peek = queue.peek();
                boolean isHighPriority = true;

                for (Integer[] integers : queue) {
                    if (peek[1] < integers[1]) {
                        isHighPriority = false;
                        break;
                    }
                }

                if (!isHighPriority) {
                    Integer[] poll = queue.poll();
                    queue.add(poll);
                } else {
                    Integer[] poll = queue.poll();

                    Integer print = poll[0];
                    if (M == print) {
                        break;
                    } else {
                        result++;
                    }
                }
            }

            System.out.println(result);
        }
    }
}
