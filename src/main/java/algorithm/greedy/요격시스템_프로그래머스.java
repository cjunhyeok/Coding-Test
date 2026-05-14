package main.java.algorithm.greedy;

import java.util.Arrays;

public class 요격시스템_프로그래머스 {
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (a, b) -> {
            return a[1] - b[1];
        });

        int currentEnd = 0;

        for (int i = 0; i < targets.length; i++) {
            int[] target = targets[i];
            int start = target[0];
            int end = target[1];

            if (currentEnd <= start) {
                answer++;
                currentEnd = end;
            }
        }

        return answer;
    }
}
