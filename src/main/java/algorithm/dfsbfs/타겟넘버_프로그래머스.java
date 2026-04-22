package main.java.algorithm.dfsbfs;

public class 타겟넘버_프로그래머스 {

    private static int N, TARGET;
    private static int[] values;
    private static int result = 0;

    public int solution(int[] numbers, int target) {

        values = numbers;
        N = values.length;
        TARGET = target;

        dfs(0, 0);

        return result;
    }

    private static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == TARGET) {
                result++;
            }
            return;
        }

        dfs(depth + 1, sum + values[depth]);

        dfs(depth + 1, sum - values[depth]);
    }
}
