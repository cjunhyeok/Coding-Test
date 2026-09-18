package main.java.algorithm.backtracking.retry;

public class 양궁대회_프로그래머스 {

    private static int[] INFO;
    private static int[] PATH = new int[11];
    private static int maxDiff = Integer.MIN_VALUE;
    private static int[] answer = new int[11];

    public int[] solution(int n, int[] info) {

        INFO = info;
        dfs(0, n);

        if (maxDiff == Integer.MIN_VALUE) {
            return new int[]{-1};
        }

        return answer;
    }

    private static void dfs(int depth, int remain) {
        if (depth == 11) {

            PATH[10] = PATH[10] + remain;
            int ryonCount = 0;
            int apeachCount = 0;

            for (int i = 0; i < 11; i++) {
                int ryon = PATH[i];
                int apeach = INFO[i];

                if (ryon == 0 && apeach == 0) {
                    continue;
                }

                if (ryon > apeach) {
                    ryonCount += 10 - i;
                } else {
                    apeachCount += 10 - i;
                }
            }

            int currentDiff = ryonCount - apeachCount;
            if (currentDiff > 0) {

                if (maxDiff == Integer.MIN_VALUE) {
                    answer = PATH.clone();
                    maxDiff = currentDiff;
                }

                if (currentDiff > maxDiff) {
                    answer = PATH.clone();
                    maxDiff = currentDiff;
                } else if (currentDiff == maxDiff && isRyonWin()) {
                    answer = PATH.clone();
                    maxDiff = currentDiff;
                }
            }

            PATH[10] = PATH[10] - remain;

            return;
        }

        int info = INFO[depth];

        if (remain > info) {
            PATH[depth] = info + 1;
            dfs(depth + 1, remain - info - 1);
        }

        PATH[depth] = 0;
        dfs(depth + 1, remain);
    }

    private static boolean isRyonWin() {
        for (int i = 10; i >= 0; i--) {
            int ryon = PATH[i];
            int apeach = answer[i];

            if (ryon > apeach) {
                return true;
            } else if (ryon < apeach) {
                return false;
            }
        }

        return false;
    }
}
