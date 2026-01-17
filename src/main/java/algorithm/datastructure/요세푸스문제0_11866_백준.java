package main.java.algorithm.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 요세푸스문제0_11866_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        StringTokenizer st = new StringTokenizer(line, " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {

            for (int i = 1; i < K; i++) {
                if (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    queue.add(poll);
                } else {
                    break;
                }
            }
            result.add(queue.poll());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < result.size(); i++) {

            if (i == (result.size() - 1)) {
                sb.append(result.get(i) + ">");
            } else {
                sb.append(result.get(i) + ", ");
            }
        }

        System.out.println(sb);
    }
}
