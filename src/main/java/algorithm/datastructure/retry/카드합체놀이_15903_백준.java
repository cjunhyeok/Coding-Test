package main.java.algorithm.datastructure.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 카드합체놀이_15903_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Long value = Long.parseLong(st.nextToken());
            priorityQueue.add(value);
        }

        for (int i = 0; i < M; i++) {
            Long first = priorityQueue.poll();
            Long second = priorityQueue.poll();

            priorityQueue.add(first + second);
            priorityQueue.add(first + second);
        }

        Long result = 0L;
        while (!priorityQueue.isEmpty()) {
            result = result + priorityQueue.poll();
        }

        System.out.println(result);
    }
}
