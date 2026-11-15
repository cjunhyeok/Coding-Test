package main.java.algorithm.dfsbfs.retry;

import java.util.ArrayList;
import java.util.List;

public class 네트워크_프로그래머스 {

    private static List<Integer>[] graph;
    private static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            int[] computer = computers[i];
            for (int j = 0; j < n; j++) {
                int connect = computer[j];

                if (i == j) {
                    continue;
                }

                if (connect == 1) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i);
                answer++;
            }
        }

        return answer;
    }

    private static void dfs(int start) {
        List<Integer> values = graph[start];
        for (int i = 0; i < values.size(); i++) {
            Integer value = values.get(i);

            if (!visited[value]) {
                visited[value] = true;
                dfs(value);
            }
        }
    }
}
