package main.java.algorithm.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class 아이템줍기_프로그래머스 {

    private int[][] map = new int[102][102];
    private boolean[][] visited = new boolean[102][102];

    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, -1, 0, 1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        // 1. 사각형 좌표 2배 확장 후 map 표시
        for (int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;

            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {

                    // 내부는 2
                    if (x > x1 && x < x2 && y > y1 && y < y2) {
                        map[x][y] = 2;
                    }
                    // 외곽은 1, 단 이미 내부면 유지
                    else {
                        if (map[x][y] != 2) {
                            map[x][y] = 1;
                        }
                    }
                }
            }
        }

        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }

    private int bfs(int startX, int startY, int endX, int endY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int x = current[0];
            int y = current[1];
            int distance = current[2];

            if (x == endX && y == endY) {
                return distance;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= 102 || nextY >= 102) {
                    continue;
                }

                if (visited[nextX][nextY]) {
                    continue;
                }

                // 외곽선만 이동 가능
                if (map[nextX][nextY] != 1) {
                    continue;
                }

                visited[nextX][nextY] = true;
                queue.add(new int[]{nextX, nextY, distance + 1});
            }
        }

        return 0;
    }
}
