package main.java.algorithm.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7569_백준 {

    static int M, N, H;
    static int[][][] box;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];
        Queue<int[]> queue = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    box[h][i][j] = Integer.parseInt(st.nextToken());

                    if (box[h][i][j] == 1) {
                        queue.add(new int[]{h, i, j});
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int z = cur[0], x = cur[1], y = cur[2];

            for (int d = 0; d < 6; d++) {
                int nz = z + dz[d];
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nz < 0 || nx < 0 || ny < 0 || nz >= H || nx >= N || ny >= M)
                    continue;

                if (box[nz][nx][ny] == 0) {
                    box[nz][nx][ny] = box[z][x][y] + 1;
                    queue.add(new int[]{nz, nx, ny});
                }
            }
        }

        int result = 0;

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (box[h][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    result = Math.max(result, box[h][i][j]);
                }
            }
        }

        System.out.println(result - 1);
    }
}
