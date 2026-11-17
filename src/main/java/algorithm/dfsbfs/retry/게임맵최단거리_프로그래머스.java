package main.java.algorithm.dfsbfs.retry;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리_프로그래머스 {

    private static int N, M;
    private static int[][] MAPS;
    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static int answer = 0;

    public static void main(String[] args) {
        solution(new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        });
    }

    public static int solution(int[][] maps) {

        N = maps.length;
        M = maps[0].length;
        MAPS = maps;
        visited = new boolean[N][M];

        bfs(0, 0);

        if (!visited[N - 1][M - 1]) {
            return -1;
        }

        return answer;
    }

    private static void bfs(int startX, int startY) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{startX, startY, 1});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();
            Integer currentX = poll[0];
            Integer currentY = poll[1];
            Integer count = poll[2];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX == N - 1 && nextY == M - 1){
                    visited[nextX][nextY] = true;
                    answer = count + 1;
                    return;
                }

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                    continue;
                }

                if (MAPS[nextX][nextY] == 0) {
                    continue;
                }

                if (visited[nextX][nextY]) {
                    continue;
                }

                queue.add(new Integer[]{nextX, nextY, count + 1});
                visited[nextX][nextY] = true;
            }
        }
    }
}
