package main.java.algorithm.binarysearch.retry;

import java.util.*;

public class 징검다리_프로그래머스 {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        long left = 1;
        long right = distance;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            int removed = 0;
            int current = 0;

            for (int rock : rocks) {
                if (rock - current < mid) {
                    removed++;
                } else {
                    current = rock;
                }
            }

            // 마지막 남은 돌 ~ 도착점 거리도 확인
            if (distance - current < mid) {
                removed++;
            }

            if (removed <= n) {
                answer = mid;
                left = mid + 1;   // 더 큰 최소거리도 가능한지 확인
            } else {
                right = mid - 1;  // 제거가 너무 많이 필요하므로 거리 줄이기
            }
        }

        return (int) answer;
    }
}
