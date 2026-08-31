package main.java.algorithm.binarysearch.retry;

import java.util.*;

public class 징검다리_프로그래머스 {
    public int solution(int distance, int[] rocks, int n) {
        long answer = 0;

        Arrays.sort(rocks);

        long left = 0;
        long right = distance;

        while (left <= right) {
            long mid = (left + right) / 2;

            int removed = 0;
            int current = 0;

            for (int rock : rocks) {
                if (rock - current < mid) {
                    removed++;

                    if (removed > n) {
                        break;
                    }
                } else {
                    current = rock;
                }
            }

            if (distance - current < mid) {
                removed++;
            }

            if (removed <= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) answer;
    }
}
