package main.java.algorithm;

public class 양궁대회_프로그래머스 {

    private static int[] ryan = new int[11];
    private static int[] answer = {-1};
    private static int maxDiff = 0;

    public int[] solution(int n, int[] info) {

        dfs(0, n, info);

        return answer;
    }

    private static void dfs(int depth, int remain, int[] info) {
        if (depth == 11 || remain == 0) {
            if (remain > 0) {
                ryan[10] += remain;
            }
            evaluate(info);
            if (remain > 0) {
                ryan[10] -= remain;
            }
            return;
        }

        int required = info[depth] + 1;

        if (required <= remain) {
            ryan[depth] = required;
            dfs(depth + 1, remain - required, info);
            ryan[depth] = 0;
        }

        dfs(depth + 1, remain, info);
    }

    private static void evaluate(int[] info) {
        int apeachScore = 0;
        int ryanScore = 0;

        for (int i = 0; i < 11; i++) {
            int score = 10 - i;

            if (info[i] == 0 && ryan[i] == 0) {
                continue;
            }

            if (ryan[i] > info[i]) {
                ryanScore += score;
            } else {
                apeachScore += score;
            }
        }

        int diff = ryanScore - apeachScore;

        if (diff <= 0) {
            return;
        }

        if (diff > maxDiff) {
            maxDiff = diff;
            answer = ryan.clone();
            return;
        }

        if (diff == maxDiff && isBetter(ryan, answer)) {
            answer = ryan.clone();
        }
    }

    private static boolean isBetter(int[] current, int[] best) {
        for (int i = 10; i >= 0; i--) {
            if (current[i] != best[i]) {
                return current[i] > best[i];
            }
        }

        return false;
    }
}
