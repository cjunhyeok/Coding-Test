package main.java.algorithm.dp.retry;

public class 정수삼각형_프로그래머스 {
    public int solution(int[][] triangle) {
        int answer = 0;

        int length = triangle.length;
        int[][] dp = new int[length][length];

        dp[0][0] = triangle[0][0];

        for (int i = 1; i < length; i++) {

            int[] values = triangle[i];
            for (int j = 0; j < values.length; j++) {
                if (j - 1 >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j] + triangle[i][j], dp[i - 1][j - 1] + triangle[i][j]);
                } else {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                }

                if (dp[i][j] > answer) {
                    answer = dp[i][j];
                }
            }
        }

        return answer;
    }
}
