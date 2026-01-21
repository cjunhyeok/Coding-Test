package main.java.algorithm.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 절대값힙_11286_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((s1, s2) -> {
            int s1Abs = Math.abs(s1);
            int s2Abs = Math.abs(s2);

            if (s1Abs != s2Abs) {
                return s1Abs - s2Abs;
            } else {
                return s1 - s2;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());

            if (value == 0) {
                if (priorityQueue.isEmpty()) {
                    sb.append(0 + "\n");
                } else {
                    sb.append(priorityQueue.poll() + "\n");
                }
            } else {
                priorityQueue.add(value);
            }
        }

        System.out.println(sb);
    }
}
