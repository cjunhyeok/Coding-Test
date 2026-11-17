package main.java.algorithm.backtracking.retry;

import java.util.Arrays;

public class 섬연결하기_프로그래머스 {

    private static int[] parents;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        parents = new int[n];
        for (int i = 0; i < n; i++){
            parents[i] = i;
        }

        Arrays.sort(costs, (a, b) -> {
            return a[2] - b[2];
        });

        for (int i = 0; i < costs.length; i++) {
            int[] cost = costs[i];
            int start = cost[0];
            int end = cost[1];
            int price = cost[2];

            int startParent = find(start);
            int endParent = find(end);

            if (startParent == endParent) {
                continue;
            }

            parents[end] = startParent;
            answer = answer + price;
            n--;

            if (n == 0) {
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
}
