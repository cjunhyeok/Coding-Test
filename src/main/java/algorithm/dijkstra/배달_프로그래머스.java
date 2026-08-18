package main.java.algorithm.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 배달_프로그래머스 {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        List<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < road.length; i++) {
            int[] values = road[i];

            graph[values[0]].add(new int[]{values[1], values[2]});
            graph[values[1]].add(new int[]{values[0], values[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.add(new int[]{1, 0});
        dist[1] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int cost = current[1];

            if (cost > dist[node]) {
                continue;
            }

            for (int[] next : graph[node]) {
                int nextNode = next[0];
                int weight = next[1];

                if (cost + weight < dist[nextNode]) {
                    dist[nextNode] = cost + weight;
                    pq.add(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        for (int i = 1; i <= N; i++){
            if (dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }

}
