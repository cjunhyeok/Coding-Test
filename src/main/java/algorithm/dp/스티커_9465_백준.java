package main.java.algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커_9465_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] values = new int[2][N];
            int[][] dp = new int[2][N];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                values[0][i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                values[1][i] = Integer.parseInt(st.nextToken());
            }

            dp[0][0] = values[0][0];
            dp[1][0] = values[1][0];

            if (N == 1) {
                System.out.println(Math.max(dp[0][0], dp[1][0]));
                continue;
            }

            dp[0][1] = dp[1][0] + values[0][1];
            dp[1][1] = dp[0][0] + values[1][1];

            if (N == 2) {
                System.out.println(Math.max(dp[0][1], dp[1][1]));
                continue;
            }

            for (int i = 2; i < N; i++) {

                dp[0][i] = Math.max(dp[1][i - 1] + values[0][i], dp[0][i - 2] + values[0][i]);
                dp[0][i] = Math.max(dp[0][i], dp[1][i - 2] + values[0][i]);

                dp[1][i] = Math.max(dp[0][i - 1] + values[1][i], dp[0][i - 2] + values[1][i]);
                dp[1][i] = Math.max(dp[1][i], dp[1][i - 2] + values[1][i]);
            }

            System.out.println(Math.max(dp[0][N - 1], dp[1][N - 1]));
        }
    }
}
