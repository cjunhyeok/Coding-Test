package main.java.algorithm.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 숨바꼭질3_134549_백준 {

    private static int N, K;
    private static int[] dist;
    private static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[MAX + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        bfs(N);
    }

    private static void bfs(int start) {
        Deque<Integer> deque = new ArrayDeque<>();
        dist[start] = 0;
        deque.add(start);

        while (!deque.isEmpty()) {
            Integer current = deque.pollFirst();

            if (current == K) {
                System.out.println(dist[current]);
                return;
            }

            int next = current * 2;
            if (next <= MAX && dist[next] > dist[current]) {
                dist[next] = dist[current];
                deque.addFirst(next);
            }

            next = current + 1;
            if (next <= MAX && dist[next] > dist[current] + 1) {
                dist[next] = dist[current] + 1;
                deque.addLast(next);
            }

            next = current - 1;
            if (next >= 0 && dist[next] > dist[current] + 1) {
                dist[next] = dist[current] + 1;
                deque.addLast(next);
            }
        }
    }
}
