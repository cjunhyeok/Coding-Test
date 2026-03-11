package main.java.algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수삼각형_1932_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] values = new int[N][N];
        int[][] dp = new int[N][N];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < i; j++) {
                int value = Integer.parseInt(st.nextToken());
                values[i - 1][j] = value;
            }
        }

        dp[0][0] = values[0][0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {

                if (j < 1) {
                    dp[i][j] = values[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = values[i][j] + dp[i - 1][j - 1];
                    dp[i][j] = Math.max(dp[i][j], values[i][j] + dp[i - 1][j]);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, dp[N - 1][i]);
        }

        System.out.println(result);
    }
}
