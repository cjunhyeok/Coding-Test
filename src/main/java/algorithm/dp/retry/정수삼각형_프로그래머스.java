package main.java.algorithm.dp.retry;

public class 정수삼각형_프로그래머스 {
    public static int solution(int[][] triangle) {
        int answer = 0;

        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                int value = triangle[i][j];

                if (j - 1 >= 0) {
                    dp[i][j] = dp[i - 1][j - 1] + value;
                }

                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + value);

                answer = Math.max(answer, dp[i][j]);
            }
        }

        return answer;
    }
}
