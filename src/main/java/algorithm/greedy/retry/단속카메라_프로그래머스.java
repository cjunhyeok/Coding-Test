package main.java.algorithm.greedy.retry;

import java.util.Arrays;

public class 단속카메라_프로그래머스 {
    public int solution(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes, (a, b) -> {
            return a[1] - b[1];
        });

        int prevEnd = routes[0][1];

        for (int i = 1; i < routes.length; i++) {
            int[] route = routes[i];
            int start = route[0];
            int end = route[1];

            if (start > prevEnd) {
                answer++;
                prevEnd = end;
            }
        }

        return answer;
    }
}
