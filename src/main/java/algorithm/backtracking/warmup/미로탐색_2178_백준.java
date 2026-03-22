package main.java.algorithm.backtracking.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색_2178_백준 {

    private static int[][] values;
    private static boolean[][] visited;
    private static int[][] map;
    private static int[] dx = new int[]{-1, 0, 1, 0};
    private static int[] dy = new int[]{0, -1, 0, 1};
    private static int N,M;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        values = new int[N + 1][M + 1];
        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                values[i][j] = line.charAt(j - 1) - '0';
            }
        }

        bfs(1, 1);

        System.out.println(map[N][M]);
    }

    private static void bfs(int startX, int startY) {
        Queue<Integer[]> queue = new LinkedList<>();
        Integer[] value = new Integer[3];
        value[0] = startX;
        value[1] = startY;
        value[2] = 1;
        queue.add(value);

        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();

            Integer currentX = poll[0];
            Integer currentY = poll[1];

            if (currentX == N && currentY == M) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX <= 0 || nextY <= 0 || nextX > N || nextY > M) {
                    continue;
                }

                if (values[nextX][nextY] != 1) {
                    continue;
                }

                if (!visited[nextX][nextY]) {
                    Integer[] nexts = new Integer[3];
                    nexts[0] = nextX;
                    nexts[1] = nextY;
                    nexts[2] = poll[2] + 1;
                    map[nextX][nextY] = nexts[2];
                    visited[nextX][nextY] = true;
                    queue.add(nexts);
                    result++;
                }
            }
        }
    }
}
