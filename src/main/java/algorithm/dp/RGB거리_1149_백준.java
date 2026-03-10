package main.java.algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리_1149_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] values = new int[N][3];
        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            values[i][0] = r;
            values[i][1] = g;
            values[i][2] = b;
        }

        dp[0][0] = values[0][0];
        dp[0][1] = values[0][1];
        dp[0][2] = values[0][2];

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(values[i][0] + dp[i - 1][1], values[i][0] + dp[i - 1][2]);
            dp[i][1] = Math.min(values[i][1] + dp[i - 1][0], values[i][1] + dp[i - 1][2]);
            dp[i][2] = Math.min(values[i][2] + dp[i - 1][0], values[i][2] + dp[i - 1][1]);
        }

        int min = Math.min(dp[N - 1][0], dp[N - 1][1]);
        System.out.println(Math.min(min, dp[N - 1][2]));
    }
}
