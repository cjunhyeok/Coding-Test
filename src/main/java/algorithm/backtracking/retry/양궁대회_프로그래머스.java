package main.java.algorithm.backtracking.retry;

public class 양궁대회_프로그래머스 {

    private static final int LENGTH = 11;

    private static int[] INFO;
    private static int[] PATH;
    private static int[] answer = new int[LENGTH];
    private static int maxDiff = 0;
    private static boolean isMaxValue = false;

    public static void main(String[] args) {
        solution(9, new int[]{2,3,1,0,0,0,0,1,3,0,0});
    }

    public static int[] solution(int n, int[] info) {

        INFO = info;
        PATH = new int[LENGTH];

        dfs(0, n);

        if (!isMaxValue) {
            return new int[]{-1};
        }

        return answer;
    }

    private static void dfs(int depth, int n) {
        if (depth == LENGTH || n == 0) {

            PATH[LENGTH - 1] += n;

            int ryanScore = 0;
            int apeachScore = 0;

            for (int i = 0; i < LENGTH; i++) {
                int info = INFO[i];
                int path = PATH[i];

                if (info == 0 && path == 0) {
                    continue;
                }

                if (path > info) {
                    ryanScore += LENGTH - (i + 1);
                } else {
                    apeachScore += LENGTH - (i + 1);
                }
            }

            int currentDiff = ryanScore - apeachScore;

            if (currentDiff <= 0) {
                PATH[LENGTH - 1] -= n;
                return;
            }

            if (currentDiff > maxDiff) {
                for (int i = 0; i < LENGTH; i++) {
                    answer[i] = PATH[i];
                }

                maxDiff = currentDiff;
                isMaxValue = true;
            } else if (currentDiff == maxDiff) {
                boolean isUpdate = false;

                for (int i = LENGTH - 1; i >= 0; i--) {
                    int ans = answer[i];
                    int path = PATH[i];

                    if (path > ans) {
                        isUpdate = true;
                        break;
                    } else if (path < ans) {
                        break;
                    }
                }

                if (isUpdate && isMaxValue) {
                    for (int i = 0; i < LENGTH; i++) {
                        answer[i] = PATH[i];
                    }

                    maxDiff = currentDiff;
                }
            }

            PATH[LENGTH - 1] -= n;

            return;
        }

        int info = INFO[depth];

        if (n > info) {
            int cost = info + 1;
            PATH[depth] = cost;
            dfs(depth + 1, n - (cost));
            PATH[depth] = 0;
        }

        dfs(depth + 1, n);
    }
}
