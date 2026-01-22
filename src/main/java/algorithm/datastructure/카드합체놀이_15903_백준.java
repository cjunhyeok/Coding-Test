package main.java.algorithm.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 카드합체놀이_15903_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        line = br.readLine();
        st = new StringTokenizer(line, " ");

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            priorityQueue.add(value);
        }

        for (int i = 0; i < M; i++) {
            Integer first = priorityQueue.poll();
            Integer second = priorityQueue.poll();

            Integer value = first + second;

            priorityQueue.add(value);
            priorityQueue.add(value);
        }

        int result = 0;
        for (int i = 0; i < N; i++){
            result = result + priorityQueue.poll();
        }

        System.out.println(result);
    }
}
