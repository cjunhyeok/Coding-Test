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

            int prev = 0;
            int count = 0;

            for (int i = 0; i < rocks.length; i++ ){
                int current = rocks[i];
                int cost = current - prev;

                if (cost < mid) {
                    count++;
                    if (count > n) {
                        break;
                    }
                } else {
                    prev = current;
                }
            }

            if (distance - prev < mid) {
                count++;
            }

            if (count <= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) answer;
    }
}
