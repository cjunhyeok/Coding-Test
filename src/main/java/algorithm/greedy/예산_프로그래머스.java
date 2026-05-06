package main.java.algorithm.greedy;

import java.util.*;

public class 예산_프로그래머스 {

    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        for (int i = 0; i < d.length; i++) {
            int value = d[i];
            if (budget >= value) {
                budget = budget - value;
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }
}
