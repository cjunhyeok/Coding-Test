package main.java.algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기_2579_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N][2];
        int[] steps = new int[N];

        for (int i = 0; i < N; i++) {
            steps[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(steps[0]);
            return;
        }

        if (N == 2) {
            System.out.println(steps[0] + steps[1]);
            return;
        }

        dp[0][0] = steps[0];
        dp[1][0] = steps[1];
        dp[1][1] = steps[0] + steps[1];
        for (int i = 2; i < N; i++) {
            dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]) + steps[i];
            dp[i][1] = dp[i - 1][0] + steps[i];
        }

        System.out.println(Math.max(dp[N - 1][0], dp[N - 1][1]));
    }
}
