package main.java.algorithm.dp.retry;

public class 정수삼각형_프로그래머스 {
    public int solution(int[][] triangle) {
        int answer = 0;

        int N = triangle.length;
        int[][] dp = new int[N][N];

        dp[0][0] = triangle[0][0];

        for (int i = 1; i < N; i++) {
            int[] values = triangle[i];

            for (int j = 0 ; j < values.length; j++) {
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], triangle[i][j] + dp[i - 1][j - 1]);
                    dp[i][j] = Math.max(dp[i][j], triangle[i][j] + dp[i - 1][j]);
                } else {
                    dp[i][j] = Math.max(dp[i][j], triangle[i][j] + dp[i - 1][j]);
                }

                answer = Math.max(answer, dp[i][j]);
            }
        }

        return answer;
    }
}
