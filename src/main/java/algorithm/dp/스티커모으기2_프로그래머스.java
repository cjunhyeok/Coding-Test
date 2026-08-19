package main.java.algorithm.dp;

public class 스티커모으기2_프로그래머스 {
    public int solution(int[] sticker) {
        int answer = 0;

        int length = sticker.length;

        if (length == 1) {
            return sticker[0];
        }

        if (length == 2) {
            return Math.max(sticker[0], sticker[1]);
        }

        if (length == 3) {
            answer = Math.max(answer, sticker[0] + sticker[2]);
            return Math.max(answer, sticker[1]);
        }

        int[] dp = new int[length];
        dp[0] = sticker[0];
        dp[1] = Math.max(sticker[1], dp[0]);

        for (int i = 2; i < length - 1; i++) {
            dp[i] = Math.max(sticker[i] + dp[i - 2], dp[i - 1]);
            answer = Math.max(answer, dp[i]);
        }

        dp = new int[length];
        dp[1] = sticker[1];
        dp[2] = Math.max(sticker[2], dp[1]);

        for (int i = 3; i < length; i++) {
            dp[i] = Math.max(sticker[i] + dp[i - 2], dp[i - 1]);
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }
}
