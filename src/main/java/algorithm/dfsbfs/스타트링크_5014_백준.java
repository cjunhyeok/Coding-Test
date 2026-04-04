package main.java.algorithm.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스타트링크_5014_백준 {

    private static int F,S,G,U,D;
    private static int[] floor;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        floor = new int[F + 1];
        visited = new boolean[F + 1];

        Arrays.fill(floor, -1);

        bfs();

        if (floor[G] == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(floor[G]);
        }
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        visited[S] = true;
        floor[S] = 0;
        queue.add(S);

        while (!queue.isEmpty()) {
            Integer currentStep = queue.poll();

            int nextStep = currentStep + U;

            if (nextStep <= F) {

                if (!visited[nextStep]) {
                    visited[nextStep] = true;
                    floor[nextStep] = floor[currentStep] + 1;
                    queue.add(nextStep);
                }
            }

            nextStep = currentStep - D;

            if (nextStep > 0) {

                if (!visited[nextStep]) {
                    visited[nextStep] = true;
                    floor[nextStep] = floor[currentStep] + 1;
                    queue.add(nextStep);
                }
            }
        }
    }
}
