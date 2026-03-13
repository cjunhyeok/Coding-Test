package main.java.algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주시식_2156_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] values = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(values[0]);
            return;
        }

        if (N == 2) {
            System.out.println(values[0] + values[1]);
            return;
        }

        dp[0] = values[0];
        dp[1] = values[1] + values[0];

        int result = Integer.MIN_VALUE;

        dp[2] = Math.max(values[0] + values[1], values[1] + values[0]);
        dp[2] = Math.max(dp[2], values[1] + values[2]);
        dp[2] = Math.max(dp[2], values[0] +  values[2]);
        if (N == 3) {
            System.out.println(dp[2]);
            return;
        }

        for (int i = 3; i < N; i++) {
            dp[i] = Math.max((values[i] + dp[i - 2]), (values[i] + values[i - 1] + dp[i - 3]));
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }


        for (int i = 0; i < N; i++) {
            if (result < dp[i]) {
                result = dp[i];
            }
        }

        System.out.println(result);
    }
}
