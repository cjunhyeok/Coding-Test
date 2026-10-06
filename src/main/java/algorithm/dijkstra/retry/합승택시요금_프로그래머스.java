package main.java.algorithm.dijkstra.retry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 합승택시요금_프로그래머스 {

    private static List<int[]>[] graph;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] fare : fares) {
            int start = fare[0];
            int end = fare[1];
            int cost = fare[2];

            graph[start].add(new int[]{end, cost});
            graph[end].add(new int[]{start, cost});
        }

        int[] distS = dijkstra(n, s);
        int[] distA = dijkstra(n, a);
        int[] distB = dijkstra(n, b);

        answer = Integer.MAX_VALUE;

        for (int k = 1; k <= n; k++) {
            int totalCost =
                    distS[k]
                            + distA[k]
                            + distB[k];

            answer = Math.min(answer, totalCost);
        }


        return answer;
    }

    private static int[] dijkstra(int n, int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
            return Integer.compare(x[1], y[1]);
        });

        dist[start] = 0;
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();

            int currentNode = poll[0];
            int currentCost = poll[1];

            if (currentCost > dist[currentNode]) {
                continue;
            }

            for (int[] next : graph[currentNode]) {
                int nextCost = currentCost + next[1];

                if (nextCost < dist[next[0]]) {
                    dist[next[0]] = nextCost;
                    pq.offer(new int[]{next[0], nextCost});
                }
            }
        }

        return dist;
    }
}
