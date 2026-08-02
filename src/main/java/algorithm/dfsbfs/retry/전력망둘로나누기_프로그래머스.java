package main.java.algorithm.dfsbfs.retry;

import java.util.ArrayList;
import java.util.List;

public class 전력망둘로나누기_프로그래머스 {

    private List<Integer>[] graph;
    private boolean[] visited;
    private int count;

    public int solution(int n, int[][] wires) {

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            graph[a].add(b);
            graph[b].add(a);
        }

        int answer = Integer.MAX_VALUE;

        for (int[] wire : wires) {
            int cutA = wire[0];
            int cutB = wire[1];
            visited = new boolean[n + 1];
            count = 0;

            dfs(cutA, cutA, cutB);

            answer = Math.min(answer, Math.abs(n - 2 * count));
        }

        return answer;
    }

    private void dfs(int current, int cutA, int cutB) {

        visited[current] = true;
        count++;

        for (int next : graph[current]) {

            // 현재 끊은 전선은 지나가지 않는다.
            if ((current == cutA && next == cutB)
                    || (current == cutB && next == cutA)) {
                continue;
            }

            if (!visited[next]) {
                dfs(next, cutA, cutB);
            }
        }
    }
}
