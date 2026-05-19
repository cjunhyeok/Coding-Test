package main.java.algorithm.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class 리코쳇로봇_프로그래머스 {

    private static int N,M;
    private static boolean[][] visited;

    public int solution(String[] board) {

        N = board.length;
        M = board[0].length();
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = board[i];
            for (int j = 0; j < M; j++) {
                char value = line.charAt(j);
                if (value == 'R') {
                    return bfs(i, j, board);
                }
            }
        }

        return -1;
    }

    private static int bfs(int startX, int startY, String[] board) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            int count = poll[2];

            if (board[currentX].charAt(currentY) == 'G') {
                return count;
            }

            // 상, 하, 좌, 우 끝점 탐색
            int x = currentX;
            while (true) {
                // 현재 칸이 끝칸
                if (x == 0) {
                    if (!visited[x][currentY]) {
                        visited[x][currentY] = true;
                        queue.add(new int[]{x, currentY, count + 1});
                    }
                    break;
                }
                // 다음칸이 D
                if (board[x - 1].charAt(currentY) == 'D') {
                    if (!visited[x][currentY]) {
                        visited[x][currentY] = true;
                        queue.add(new int[]{x, currentY, count + 1});
                    }
                    break;
                }
                x--;
            }
            x = currentX;
            while (true) {
                // 현재 칸이 끝칸
                if (x == N - 1) {
                    if (!visited[x][currentY]) {
                        visited[x][currentY] = true;
                        queue.add(new int[]{x, currentY, count + 1});
                    }
                    break;
                }
                // 다음칸이 D
                if (board[x + 1].charAt(currentY) == 'D') {
                    if (!visited[x][currentY]) {
                        visited[x][currentY] = true;
                        queue.add(new int[]{x, currentY, count + 1});
                    }
                    break;
                }
                x++;
            }
            int y = currentY;
            while (true) {
                // 현재 칸이 끝칸
                if (y == 0) {
                    if (!visited[currentX][y]) {
                        visited[currentX][y] = true;
                        queue.add(new int[]{currentX, y, count + 1});
                    }
                    break;
                }
                // 다음칸이 D
                if (board[currentX].charAt(y - 1) == 'D') {
                    if (!visited[currentX][y]) {
                        visited[currentX][y] = true;
                        queue.add(new int[]{currentX, y, count + 1});
                    }
                    break;
                }
                y--;
            }
            y = currentY;
            while (true) {
                // 현재 칸이 끝칸
                if (y == M - 1) {
                    if (!visited[currentX][y]) {
                        visited[currentX][y] = true;
                        queue.add(new int[]{currentX, y, count + 1});
                    }
                    break;
                }
                // 다음칸이 D
                if (board[currentX].charAt(y + 1) == 'D') {
                    if (!visited[currentX][y]) {
                        visited[currentX][y] = true;
                        queue.add(new int[]{currentX, y, count + 1});
                    }
                    break;
                }
                y++;
            }
        }

        return -1;
    }
}
