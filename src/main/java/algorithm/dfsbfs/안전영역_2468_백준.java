package main.java.algorithm.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 안전영역_2468_백준 {

    private static int HEIGHT = Integer.MIN_VALUE;
    private static int N;
    private static int[][] values;
    private static boolean[][] visited;
    private static int[] dx = new int[]{-1, 0, 1, 0};
    private static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        values = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value > HEIGHT) {
                    HEIGHT = value;
                }
                values[i][j] = value;
            }
        }

        int result = 0;
        for (int h = 0; h <= HEIGHT; h++) {
            int count = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int value = values[i][j];

                    if (value > h) {
                        if (!visited[i][j]) {
                            bfs(i, j, h);
                            count++;
                        }
                    }
                }
            }

            result = Math.max(result, count);
        }

        System.out.println(result);
    }

    private static void bfs(int startX, int startY, int height) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{startX, startY});

        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();
            Integer currentX = poll[0];
            Integer currentY = poll[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                    continue;
                }

                if (visited[nextX][nextY]) {
                    continue;
                }

                if (values[nextX][nextY] <= height) {
                    continue;
                }

                visited[nextX][nextY] = true;
                queue.add(new Integer[]{nextX, nextY});
            }
        }
    }
}
