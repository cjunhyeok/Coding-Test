package main.java.algorithm.dp;

import java.util.*;

public class 사칙연산_프로그래머스 {

    public int solution(String[] arr) {
        int n = (arr.length + 1) / 2;

        int[] numbers = new int[n];
        String[] ops = new String[n - 1];

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                numbers[i / 2] = Integer.parseInt(arr[i]);
            } else {
                ops[i / 2] = arr[i];
            }
        }

        int[][] maxDp = new int[n][n];
        int[][] minDp = new int[n][n];

        for (int i = 0; i < n; i++) {
            maxDp[i][i] = numbers[i];
            minDp[i][i] = numbers[i];
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                maxDp[i][j] = Integer.MIN_VALUE;
                minDp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    if (ops[k].equals("+")) {
                        int maxValue =
                                maxDp[i][k] + maxDp[k + 1][j];

                        int minValue =
                                minDp[i][k] + minDp[k + 1][j];

                        maxDp[i][j] =
                                Math.max(maxDp[i][j], maxValue);

                        minDp[i][j] =
                                Math.min(minDp[i][j], minValue);

                    } else {
                        int maxValue =
                                maxDp[i][k] - minDp[k + 1][j];

                        int minValue =
                                minDp[i][k] - maxDp[k + 1][j];

                        maxDp[i][j] =
                                Math.max(maxDp[i][j], maxValue);

                        minDp[i][j] =
                                Math.min(minDp[i][j], minValue);
                    }
                }
            }
        }

        return maxDp[0][n - 1];
    }
}
