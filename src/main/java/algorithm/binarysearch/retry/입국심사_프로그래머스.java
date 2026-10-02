package main.java.algorithm.binarysearch.retry;

import java.util.Arrays;

public class 입국심사_프로그래머스 {

    public static void main(String[] args) {
        solution(6, new int[]{7, 10});
    }

    public static long solution(int n, int[] times) {
        long answer = 0;
        int length = times.length;

        Arrays.sort(times);
        long left = 0;
        long right = (long) times[length - 1] * n;
        answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;

            long process = 0;

            for (int i = 0; i < length; i++) {
                int time = times[i];
                long current = mid / time;
                process += current;
            }

            if (process == n) {
                answer = mid;
                right = mid - 1;
            } else if (process > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}
