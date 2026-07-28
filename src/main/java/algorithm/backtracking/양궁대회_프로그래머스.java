package main.java.algorithm.backtracking;

public class 양궁대회_프로그래머스 {

    private int maxDiff = 0;
    private int[] bestAnswer = {-1};
    private int[] ryan = new int[11];

    public int[] solution(int n, int[] info) {
        dfs(0, n, info);
        return bestAnswer;
    }

    private void dfs(int index, int remain, int[] info) {
        if (index == 11 || remain == 0) {
            if (remain > 0) {
                ryan[10] += remain;
            }

            evaluate(info);

            if (remain > 0) {
                ryan[10] -= remain;
            }

            return;
        }

        int required = info[index] + 1;

        if (required <= remain) {
            ryan[index] = required;

            dfs(index + 1, remain - required, info);

            ryan[index] = 0;
        }

        dfs(index + 1, remain, info);
    }

    private void evaluate(int[] info) {
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
            bestAnswer = ryan.clone();
            return;
        }

        if (diff == maxDiff && isBetter(ryan, bestAnswer)) {
            bestAnswer = ryan.clone();
        }
    }

    private boolean isBetter(int[] current, int[] best) {
        for (int i = 10; i >= 0; i--) {
            if (current[i] != best[i]) {
                return current[i] > best[i];
            }
        }

        return false;
    }
}
