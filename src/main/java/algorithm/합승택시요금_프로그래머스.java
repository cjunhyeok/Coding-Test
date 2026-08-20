package main.java.algorithm;

import java.util.*;

public class 합승택시요금_프로그래머스 {
    static class Node {
        int next;
        int cost;

        Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }

    private List<Node>[] graph;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] fare : fares) {
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];

            graph[from].add(new Node(to, cost));
            graph[to].add(new Node(from, cost));
        }

        int[] distS = dijkstra(s, n);
        int[] distA = dijkstra(a, n);
        int[] distB = dijkstra(b, n);

        int answer = Integer.MAX_VALUE;

        for (int k = 1; k <= n; k++) {
            int totalCost =
                    distS[k]
                            + distA[k]
                            + distB[k];

            answer = Math.min(answer, totalCost);
        }

        return answer;
    }

    private int[] dijkstra(int start, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq =
                new PriorityQueue<>((x, y) ->
                        Integer.compare(x.cost, y.cost));

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            int currentNode = current.next;
            int currentCost = current.cost;

            if (currentCost > dist[currentNode]) {
                continue;
            }

            for (Node next : graph[currentNode]) {
                int nextCost = currentCost + next.cost;

                if (nextCost < dist[next.next]) {
                    dist[next.next] = nextCost;
                    pq.offer(new Node(next.next, nextCost));
                }
            }
        }

        return dist;
    }
}
