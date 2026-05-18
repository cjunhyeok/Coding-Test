package main.java.algorithm.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출_프로그래머스 {

    private static int N, M;
    private static int[][] grid;
    private static boolean[][] visited;
    private static int[] dx = new int[]{-1, 0, 1, 0};
    private static int[] dy = new int[]{0, -1, 0, 1};

    public int solution(String[] maps) {

        N = maps.length;
        M = maps[0].length();

        grid = new int[N][M];
        visited = new boolean[N][M];

        boolean isCorrect = true;

        // 시작 -> 레버
        for (int i = 0; i < N; i++) {
            String map = maps[i];
            for (int j = 0; j < M; j++) {
                char value = map.charAt(j);
                if (value == 'S') {
                    isCorrect = bfs(i, j, maps);
                }
            }
        }
        if (!isCorrect) {
            return -1;
        }

        // 레버 -> 출구
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String map = maps[i];
            for (int j = 0; j < M; j++) {
                char value = map.charAt(j);
                if (value == 'L') {
                    isCorrect = secondBfs(i, j, maps);
                }
            }
        }
        if (!isCorrect) {
            return -1;
        }

        for (int i = 0; i < N; i++) {
            String map = maps[i];
            for (int j = 0; j < M; j++) {
                char value = map.charAt(j);
                if (value == 'E') {
                    return grid[i][j];
                }
            }
        }

        return -1;
    }

    private static boolean bfs(int startX, int startY, String[] maps) {
        Queue<int[]> queue = new LinkedList<>();
        visited[startX][startY] = true;
        grid[startX][startY] = 0;
        queue.add(new int[]{startX, startY});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }

                if (visited[nextX][nextY]) {
                    continue;
                }

                if (maps[nextX].charAt(nextY) == 'O' || maps[nextX].charAt(nextY) == 'E') {
                    grid[nextX][nextY] = grid[currentX][currentY] + 1;
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                } else if (maps[nextX].charAt(nextY) == 'L') {
                    grid[nextX][nextY] = grid[currentX][currentY] + 1;
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean secondBfs(int startX, int startY, String[] maps) {
        Queue<int[]> queue = new LinkedList<>();
        visited[startX][startY] = true;
        queue.add(new int[]{startX, startY});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }

                if (visited[nextX][nextY]) {
                    continue;
                }

                if (maps[nextX].charAt(nextY) == 'O' || maps[nextX].charAt(nextY) == 'L' || maps[nextX].charAt(nextY) == 'S') {
                    grid[nextX][nextY] = grid[currentX][currentY] + 1;
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                } else if (maps[nextX].charAt(nextY) == 'E') {
                    grid[nextX][nextY] = grid[currentX][currentY] + 1;
                    return true;
                }
            }
        }

        return false;
    }
}
