package main.java.algorithm.binarysearch;

import java.util.*;

class 입국심사_프로그래머스 {

    public long solution(int n, int[] times) {

        Arrays.sort(times);

        long left = 1;
        long right = (long) times[times.length - 1] * n;
        long answer = right;

        while (left <= right) {

            long mid = (left + right) / 2;
            long count = 0;

            for (int time : times) {
                count += mid / time;

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