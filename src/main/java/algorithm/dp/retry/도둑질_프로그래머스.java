package main.java.algorithm.dp.retry;

public class 도둑질_프로그래머스 {
    public int solution(int[] money) {
        int answer = 0;

        int length = money.length;

        int[] dp = new int[length];
        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);

        answer = dp[1];

        for (int i = 2; i < length - 1; i++) {
            dp[i] = Math.max(dp[i - 1], money[i] + dp[i - 2]);
            answer = Math.max(answer, dp[i]);
        }

        dp = new int[length];
        dp[1] = money[1];
        dp[2] = Math.max(money[1], money[2]);

        for (int i = 3; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], money[i] + dp[i - 2]);
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }
}
