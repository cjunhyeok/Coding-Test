package main.java.algorithm.dfsbfs.retry;

import java.util.LinkedList;
import java.util.Queue;

public class 아이템줍기_프로그래머스 {

    private static int[][] map = new int[102][102];
    private static boolean[][] visited = new boolean[102][102];
    private static int[] dx = new int[]{-1, 0, 1, 0};
    private static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) {
        int[][] rectangle = {
                {1, 1, 7, 4},
                {3, 2, 5, 5},
                {4, 3, 6, 9},
                {2, 6, 8, 8}
        };

        solution(rectangle, 1, 3, 7, 8);
    }

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        for (int i = 0; i < rectangle.length; i++) {
            int[] values = rectangle[i];
            int x1 = values[0];
            int y1 = values[1];
            int x2 = values[2];
            int y2 = values[3];

            x1 = x1 * 2;
            y1 = y1 * 2;
            x2 = x2 * 2;
            y2 = y2 * 2;

            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    if (x > x1 && x < x2 && y > y1 && y < y2) {
                        map[x][y] = 1;
                    } else {
                        if (map[x][y] != 1) {
                            map[x][y] = 2;
                        }
                    }
                }
            }
        }

        int result = bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);

        return result / 2;
    }

    private static int bfs(int startX, int startY, int targetX, int targetY) {
        Queue<Integer[]> queue = new LinkedList<>();
        visited[startX][startY] = true;
        queue.add(new Integer[]{startX, startY, 1});

        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();
            Integer currentX = poll[0];
            Integer currentY = poll[1];
            Integer currentCount = poll[2];

            if (currentX == targetX && currentY == targetY) {
                return currentCount;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX < 0 || nextX >= 102 || nextY < 0 || nextY >= 102) {
                    continue;
                }

                if (map[nextX][nextY] != 2) {
                    continue;
                }

                if (visited[nextX][nextY]) {
                    continue;
                }

                visited[nextX][nextY] = true;
                queue.add(new Integer[]{nextX, nextY, currentCount + 1});
            }
        }

        return -1;
    }
}
