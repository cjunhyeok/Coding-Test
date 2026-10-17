package main.java.algorithm.backtracking.retry;

import java.util.Arrays;

public class 섬연결하기_프로그래머스 {

    private static int[] parents;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        parents = new int[n];
        for (int i = 1; i < n; i++) {
            parents[i] = i;
        }

        Arrays.sort(costs, (a, b) -> {
            return Integer.compare(a[2], b[2]);
        });

        for (int i = 0; i < costs.length; i++) {
            int[] values = costs[i];
            int start = values[0];
            int end = values[1];
            int cost = values[2];

            int startParent = find(start);
            int endParent = find(end);

            if (startParent == endParent) {
                continue;
            }

            parents[endParent] = start;
            answer += cost;
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
