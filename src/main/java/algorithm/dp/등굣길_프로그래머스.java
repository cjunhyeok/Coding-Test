package main.java.algorithm.dp;

public class 등굣길_프로그래머스 {

    public static void main(String[] args) {
        solution(4, 3, new int[][]{
                {2, 2}
        });
    }

    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < puddles.length; i++) {
            int x = puddles[i][0];
            int y = puddles[i][1];

            dp[x][y] = -1;
        }

        dp[1][1] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (i == 1 && j == 1) {
                    continue;
                }

                if (dp[i][j] == -1) {
                    continue;
                }

                int left = 0;
                int up = 0;
                if (i - 1 > 0) {
                    if (dp[i - 1][j] != -1) {
                        left = dp[i - 1][j];
                    }
                }
                if (j - 1 > 0) {
                    if (dp[i][j - 1] != -1) {
                        up = dp[i][j - 1];
                    }
                }

                dp[i][j] = (left + up) % 1000000007;
            }
        }

        return dp[m][n];
    }
}
