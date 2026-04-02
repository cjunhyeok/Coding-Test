package main.java.algorithm.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최소비용구하기_1916_백준 {

    public static void main(String[] args) throws IOException {

        int INF = Integer.MAX_VALUE;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Integer[]>[] graph = new ArrayList[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Integer[]{v, w});
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dist[start] = 0;

        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new Integer[]{start, 0});

        while (!pq.isEmpty()) {
            Integer[] poll = pq.poll();
            Integer node = poll[0];
            Integer cost = poll[1];

            if (node == end) {
                System.out.println(cost);
                return;
            }

            if (cost > dist[node]) {
                continue;
            }

            List<Integer[]> values = graph[node];
            for (Integer[] value : values) {
                Integer nextNode = value[0];
                Integer weight = value[1];

                if (dist[nextNode] > cost + weight) {
                    dist[nextNode] = cost + weight;
                    pq.add(new Integer[]{nextNode, dist[nextNode]});
                }
            }
        }
    }
}
