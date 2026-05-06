package main.java.algorithm.greedy;

import java.util.Arrays;

public class 단속카메라_프로그래머스 {

    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (a, b) -> {
            return a[1] - b[1];
        });

        int camera = Integer.MIN_VALUE;

        for (int[] route : routes) {
            if (camera < route[0]) {
                camera = route[1];
                answer++;
            }
        }

        return answer;
    }
}
