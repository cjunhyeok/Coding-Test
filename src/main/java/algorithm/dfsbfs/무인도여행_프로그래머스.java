package main.java.algorithm.dfsbfs;

import java.util.*;

public class 무인도여행_프로그래머스 {

    private static int N, M;
    private static int[][] grid;
    private static boolean[][] visited;
    private static int[] dx = new int[] {-1, 0, 1, 0};
    private static int[] dy = new int[] {0, -1, 0, 1};

    public int[] solution(String[] maps) {
        int[] answer = {};

        N = maps.length;
        M = maps[0].length();
        grid = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String map = maps[i];
            for (int j = 0; j < M; j++) {
                char value = map.charAt(j);

                if (value == 'X') {
                    grid[i][j] = -1;
                } else {
                    grid[i][j] = value - '0';
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && grid[i][j] != -1) {
                    int count = bfs(i, j);
                    list.add(count);
                }
            }
        }

        if (list.isEmpty()) {
            return new int[]{-1};
        }

        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        Arrays.sort(answer);
        return answer;
    }

    private static int bfs(int startX, int startY) {
        Queue<Integer[]> queue = new LinkedList<>();
        visited[startX][startY] = true;
        int count = grid[startX][startY];
        queue.add(new Integer[]{startX, startY});

        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();
            Integer currentX = poll[0];
            Integer currentY = poll[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }

                if (visited[nextX][nextY] || grid[nextX][nextY] == -1) {
                    continue;
                }

                visited[nextX][nextY] = true;
                count = count + grid[nextX][nextY];
                queue.add(new Integer[]{nextX, nextY});
            }
        }

        return count;
    }
}
