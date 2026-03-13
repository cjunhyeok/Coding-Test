package main.java.algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쉬운계단수_10844_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        final int MOD = 1000000000;

        int[][] dp = new int[N + 1][10];
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i<= N; i++) {
            dp[i][0] = dp[i - 1][1] % MOD;
            dp[i][9] = dp[i - 1][8] % MOD;

            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
            }
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result = (result + dp[N][i]) % MOD;
        }

        System.out.println(result);
    }
}
