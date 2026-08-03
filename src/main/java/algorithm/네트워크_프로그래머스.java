package main.java.algorithm;

import java.util.ArrayList;
import java.util.List;

public class 네트워크_프로그래머스 {

    private static int N;
    private static List<Integer>[] graph;
    private static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        N = n;
        graph = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (i == j) {
                    continue;
                }

                int computer = computers[i][j];

                if (computer == 1) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]){
                dfs(i);
                answer++;
            }
        }

        return answer;
    }

    private static void dfs(int start) {
        visited[start] = true;

        List<Integer> values = graph[start];
        for (Integer value : values) {
            if (!visited[value]) {
                dfs(value);
            }
        }
    }
}
