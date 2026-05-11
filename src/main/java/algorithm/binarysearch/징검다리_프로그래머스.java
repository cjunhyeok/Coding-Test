package main.java.algorithm.binarysearch;

import java.util.Arrays;

public class 징검다리_프로그래머스 {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int left = 1;
        int right = distance;
        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canMakeMinDistance(distance, rocks, n, mid)) {
                answer = mid;
                left = mid + 1;   // 더 큰 최소 거리 가능?
            } else {
                right = mid - 1;  // mid는 너무 큼
            }
        }

        return answer;
    }

    private boolean canMakeMinDistance(int distance, int[] rocks, int n, int minDistance) {
        int removed = 0;
        int prev = 0;

        for (int rock : rocks) {
            int gap = rock - prev;

            if (gap < minDistance) {
                removed++;
            } else {
                prev = rock;
            }
        }

        // 마지막 바위/도착지 사이 거리 확인
        if (distance - prev < minDistance) {
            removed++;
        }

        return removed <= n;
    }
}
