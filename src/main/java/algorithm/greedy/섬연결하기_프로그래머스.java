package main.java.algorithm.greedy;

import java.util.Arrays;

public class 섬연결하기_프로그래머스 {
    private int[] parent;

    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a, b) ->
                Integer.compare(a[2], b[2])
        );

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int answer = 0;
        int selectedEdgeCount = 0;

        for (int[] cost : costs) {
            int from = cost[0];
            int to = cost[1];
            int price = cost[2];

            if (find(from) == find(to)) {
                continue;
            }

            union(from, to);
            answer += price;
            selectedEdgeCount++;

            if (selectedEdgeCount == n - 1) {
                break;
            }
        }

        return answer;
    }

    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}
