package main.java.algorithm.dp;

public class 최적의행렬곱셈_프로그래머스 {
    public int solution(int[][] matrix_sizes) {
        int n = matrix_sizes.length;
        int[][] dp = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int start = 0; start <= n - len; start++) {
                int end = start + len - 1;

                dp[start][end] = Integer.MAX_VALUE;

                for (int mid = start; mid < end; mid++) {
                    int cost =
                            dp[start][mid]
                                    + dp[mid + 1][end]
                                    + matrix_sizes[start][0]
                                    * matrix_sizes[mid][1]
                                    * matrix_sizes[end][1];

                    dp[start][end] = Math.min(dp[start][end], cost);
                }
            }
        }

        return dp[0][n - 1];
    }
}
