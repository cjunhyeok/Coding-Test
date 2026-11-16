package main.java.algorithm.greedy.retry;

import java.util.Arrays;

public class 체육복_프로그래머스 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        int[] students = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            students[i] = 1;
        }

        for (int i = 0; i < reserve.length; i++) {
            int value = reserve[i];
            students[value] = students[value] + 1;
        }

        for (int i = 0; i < lost.length; i++) {
            int value = lost[i];
            students[value] = students[value] - 1;
        }

        if (students[1] == 0) {
            if (students[2] > 1) {
                students[1] = 1;
                students[2] = students[2] - 1;
            }
        }

        for (int i = 2; i < n; i++) {
            int student = students[i];

            if (student != 0) {
                continue;
            }

            if (students[i - 1] > 1) {
                students[i] = 1;
                students[i - 1] = students[i - 1] - 1;
                continue;
            }

            if (students[i + 1] > 1) {
                students[i] = 1;
                students[i + 1] = students[i + 1] - 1;
            }
        }

        if (students[n] == 0 && students[n - 1] > 1) {
            students[n] = 1;
            students[n - 1] = students[n - 1] - 1;
        }

        for (int i = 1; i <= n; i++) {
            if (students[i] > 0) {
                answer++;
            }
        }

        return answer;
    }
}
