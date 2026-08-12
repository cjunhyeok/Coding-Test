package main.java.algorithm.backtracking.retry;

import java.util.Arrays;

public class 섬연결하기_프로그래머스 {

    private static int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, (a, b) -> {
            return Integer.compare(a[2], b[2]);
        });

        for (int i = 0; i < costs.length; i++) {
            int[] cost = costs[i];
            int start = cost[0];
            int end = cost[1];
            int price = cost[2];

            int startParent = find(start);
            int endParent = find(end);

            if (startParent != endParent) {
                union(startParent, endParent);
                answer += price;
                n--;
            }

            if (n == 0) {
                return answer;
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

    private void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX != parentY) {
            parent[y] = parentX;
        }
    }
}
