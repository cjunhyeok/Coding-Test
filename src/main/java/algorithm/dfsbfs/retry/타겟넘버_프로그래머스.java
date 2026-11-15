package main.java.algorithm.dfsbfs.retry;

public class 타겟넘버_프로그래머스 {

    private static int N;
    private static int[] NUMBERS;
    private static int TARGET;
    private static int answer = 0;

    public int solution(int[] numbers, int target) {

        N = numbers.length;
        NUMBERS = numbers;
        TARGET = target;

        dfs(0, 0);

        return answer;
    }

    private static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == TARGET) {
                answer++;
            }
            return;
        }

        dfs(depth + 1, sum + NUMBERS[depth]);
        dfs(depth + 1, sum - NUMBERS[depth]);
    }
}
