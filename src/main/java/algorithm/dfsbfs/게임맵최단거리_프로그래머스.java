package main.java.algorithm.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리_프로그래머스 {

    private static int N,M;
    private static int[] dx = new int[]{-1, 0, 1, 0};
    private static int[] dy = new int[]{0, -1, 0, 1};

    public int solution(int[][] maps) {

        N = maps.length;
        M = maps[0].length;

        bfs(maps);

        if (maps[N - 1][M - 1] == 0 || maps[N - 1][M - 1] == 1) {
            return -1;
        }
        return maps[N - 1][M - 1];
    }

    private static void bfs(int[][] maps) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{0, 0});

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

                if (maps[nextX][nextY] == 1) {
                    maps[nextX][nextY] = maps[currentX][currentY] + 1;
                    queue.add(new Integer[]{nextX, nextY});
                }
            }
        }
    }
}
