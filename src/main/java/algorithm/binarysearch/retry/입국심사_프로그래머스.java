package main.java.algorithm.binarysearch.retry;

import java.util.Arrays;

public class 입국심사_프로그래머스 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long left = 0;
        long right = (long) n * times[times.length - 1];
        long answer = right;

        while (left <= right) {
            long mid = (long) (left + right) / 2;
            long currentCount = 0;

            for (int time : times) {
                currentCount += (mid / time);
                if (currentCount >= n) {
                    break;
                }
            }

            if (currentCount >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}
