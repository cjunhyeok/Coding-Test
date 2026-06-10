package main.java.algorithm.binarysearch.retry;

import java.util.Arrays;

public class 입국심사_프로그래머스 {
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);

        long left = 1;
        long right = (long) times[times.length - 1] * n;
        answer = right;

        while (left <= right) {

            long mid = (left + right) / 2;
            long count = 0;

            for (int time : times) {
                count = count + (mid / time);

                if (count >= n) {
                    break;
                }
            }

            if (count >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}
