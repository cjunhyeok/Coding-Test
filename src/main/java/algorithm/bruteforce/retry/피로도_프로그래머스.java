package main.java.algorithm.bruteforce.retry;

public class 피로도_프로그래머스 {
    private static int N;
    private static boolean[] used;
    private static int answer = 0;

    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        used = new boolean[N];

        for (int i = 0; i < N; i++) {
            dfs(i, k, 0, dungeons);
        }

        return answer;
    }

    private static void dfs(int depth, int k, int count, int[][] dungeons) {
        if (depth == N) {
            answer = Math.max(answer, count);
            return;
        }
        
        for (int i = 0; i < N; i++) {

            int minFatigue = dungeons[i][0];
            int consumeFatigue = dungeons[i][1];

            if (k < minFatigue) {
                continue;
            }

            if (used[i]) {
                continue;
            }

            used[i] = true;
            dfs(depth + 1, k - consumeFatigue, count + 1, dungeons);
            used[i] = false;
        }
    }
}
