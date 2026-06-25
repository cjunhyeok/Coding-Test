package main.java.algorithm.bruteforce.retry;

public class 피로도_프로그래머스 {

    private static int N;
    private static boolean[] used;
    private static int answer = -1;

    public int solution(int k, int[][] dungeons) {

        N = dungeons.length;
        used = new boolean[N];

        for (int i = 0; i < N; i++) {
            int[] dungeon = dungeons[i];
            int min = dungeon[0];
            int use = dungeon[1];

            if (k < min) {
                continue;
            }

            used[i] = true;
            dfs(1, k - use, dungeons);
            used[i] = false;
        }

        return answer;
    }

    private static void dfs(int depth, int k, int[][] dungeons) {

        answer = Math.max(answer, depth);
        if (depth == N) {
            return;
        }

        for (int i = 0; i < N; i++) {

            if (used[i]) {
                continue;
            }

            int[] dungeon = dungeons[i];
            int min = dungeon[0];
            int use = dungeon[1];

            if (k < min) {
                continue;
            }

            used[i] = true;
            dfs(depth + 1, k - use, dungeons);
            used[i] = false;
        }
    }
}
