package main.java.algorithm.backtracking.retry;

import java.util.Arrays;

public class 섬연결하기_프로그래머스 {

    private int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        Arrays.sort(costs, (a, b) -> {
            return Integer.compare(a[2], b[2]);
        });

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int edge = 0;

        for (int i = 0; i < costs.length; i++) {
            int start = costs[i][0];
            int end = costs[i][1];
            int cost = costs[i][2];

            if (find(start) == find(end)) {
                continue;
            }

            union(start, end);
            answer += cost;
            edge++;

            if (edge == n - 1) {
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
        int parentA = find(a);
        int parentB = find(b);

        if (parentA != parentB) {
            parent[parentB] = parentA;
        }
    }
}
