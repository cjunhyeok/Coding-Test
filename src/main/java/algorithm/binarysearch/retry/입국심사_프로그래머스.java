package main.java.algorithm.binarysearch.retry;

import java.util.Arrays;

public class 입국심사_프로그래머스 {
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);

        long left = 0;
        long right = (long) times[times.length - 1] * n;

        while (left <= right) {

            long mid = (right + left) / 2;
            long total = 0;

            for (int i = 0; i < times.length; i++) {
                long time = times[i];
                long count = mid / time;
                total += count;
            }

            if (total >= n) {
                answer = mid;
                right = mid - 1;
            } else if (total < n) {
                left = mid + 1;
            }
        }

        return answer;
    }
}
