package main.java.algorithm.bruteforce;

public class 피로도_프로그래머스 {

    private static int N;
    private static boolean[] visited;
    private static int result = 0;

    public int solution(int k, int[][] dungeons) {

        N = dungeons.length;
        visited = new boolean[N];
        dfs(dungeons, k, 0);

        return result;
    }

    private static void dfs(int[][] dungeons, int k, int depth) {

        result = Math.max(result, depth);

        for (int i = 0; i < N; i++) {
            int[] dungeon = dungeons[i];
            int min = dungeon[0];
            int use = dungeon[1];

            if (k < min) {
                continue;
            }

            if (k - use < 0) {
                continue;
            }

            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            dfs(dungeons, k - use, depth + 1);
            visited[i] = false;
        }
    }
}
