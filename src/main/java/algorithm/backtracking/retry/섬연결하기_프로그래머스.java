package main.java.algorithm.backtracking.retry;

import java.util.Arrays;

public class 섬연결하기_프로그래머스 {

    private static int[] parents;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        Arrays.sort(costs, (a, b) -> {
            return Integer.compare(a[2], b[2]);
        });

        int count = 0;

        for (int i = 0; i < costs.length; i++) {
            int[] path = costs[i];
            int start = path[0];
            int end = path[1];
            int cost = path[2];

            int startParent = find(start);
            int endParent = find(end);

            if (startParent == endParent) {
                continue;
            }

            union(start, end);

            answer += cost;
            count++;

            if (count == n - 1) {
                break;
            }
        }

        return answer;
    }

    private static int find(int x) {
        if (parents[x] == x) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parents[rootY] = rootX;
        }
    }
}
