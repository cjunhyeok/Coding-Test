package main.java.algorithm.greedy.retry;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 시소짝궁_프로그래머스 {
    public long solution(int[] weights) {
        long answer = 0;

        Arrays.sort(weights);
        Map<Double, Long> map = new HashMap<>();

        for (int i = 0; i < weights.length; i++) {
            int weight = weights[i];

            answer = answer + map.getOrDefault(weight * (3.0 / 4.0), 0L);
            answer = answer + map.getOrDefault(weight * (1.0 / 2.0), 0L);
            answer = answer + map.getOrDefault(weight * (2.0 / 3.0), 0L);
            answer = answer + map.getOrDefault(weight * 1.0, 0L);

            map.put(weight * 1.0, map.getOrDefault(weight * 1.0, 0L) + 1);
        }

        return answer;
    }
}
