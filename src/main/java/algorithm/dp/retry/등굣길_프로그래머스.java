package main.java.algorithm.dp.retry;

public class 등굣길_프로그래머스 {

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m + 1][n + 1];
        for (int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];

            dp[x][y] = -1;
        }

        dp[1][1] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (dp[i][j] == -1) {
                    continue;
                }

                if (i - 1 == 0 && j - 1 > 0) {
                    if (dp[i][j - 1] == -1) {
                        continue;
                    }

                    dp[i][j] = dp[i][j - 1];
                } else if (i - 1 > 0 && j - 1 == 0) {
                    if (dp[i - 1][j] == - 1) {
                        continue;
                    }

                    dp[i][j] = dp[i - 1][j];
                } else if (i - 1 > 0 && j - 1 > 0) {
                    if (dp[i - 1][j] == -1) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]) % 1000000007;
                    }

                    if (dp[i][j - 1] == -1) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]) % 1000000007;
                    }

                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
                }
            }
        }

        return dp[m][n];
    }
}
