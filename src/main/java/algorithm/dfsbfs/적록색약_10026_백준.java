package main.java.algorithm.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 적록색약_10026_백준 {

    private static int N;
    private static char[][] values;
    private static boolean[][] visited;
    private static int[] dx = new int[]{-1, 0, 1, 0};
    private static int[] dy = new int[]{0, -1, 0, 1};
    private static int general = 0;
    private static int colorBlindness = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        values = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                values[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    general++;
                    bfs(i, j);
                }
            }
        }

        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (values[i][j] == 'G') {
                    values[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    colorBlindness++;
                    bfs(i, j);
                }
            }
        }

        System.out.println(general + " " + colorBlindness);
    }

    private static void bfs(int startX, int startY) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{startX, startY});

        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();
            Integer currentX = poll[0];
            Integer currentY = poll[1];

            char currentColor = values[currentX][currentY];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                    continue;
                }

                if (visited[nextX][nextY]) {
                    continue;
                }

                char nextColor = values[nextX][nextY];

                if (currentColor != nextColor) {
                    continue;
                }

                visited[nextX][nextY] = true;
                queue.add(new Integer[]{nextX, nextY});
            }
        }
    }
}
