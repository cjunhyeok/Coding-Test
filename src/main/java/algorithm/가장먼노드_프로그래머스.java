package main.java.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 가장먼노드_프로그래머스 {

    private static int N;
    private static List<Integer>[] graph;
    private static boolean[] visited;

    public int solution(int n, int[][] edge) {
        N = n;
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            int start = edge[i][0];
            int end = edge[i][1];

            graph[start].add(end);
            graph[end].add(start);
        }

        return bfs(1);
    }

    private static int bfs(int start) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{start, 0});
        visited[start] = true;

        int max = Integer.MIN_VALUE;
        int answer = 0;

        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();

            Integer current = poll[0];
            Integer count = poll[1];

            if (count > max) {
                max = count;
                answer = 1;
            } else if (count == max) {
                answer++;
            }

            List<Integer> integers = graph[current];
            for (Integer integer : integers) {
                if (!visited[integer]) {
                    queue.add(new Integer[]{integer, count + 1});
                    visited[integer] = true;
                }
            }

        }

        return answer;
    }
}
