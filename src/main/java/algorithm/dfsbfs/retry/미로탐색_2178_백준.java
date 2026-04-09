package main.java.algorithm.dfsbfs.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색_2178_백준 {

    private static int N,M;
    private static int[][] map;
    private static int[] dx = new int[]{-1, 0, 1, 0};
    private static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                int value = line.charAt(j - 1) - '0';
                map[i][j] = value;
            }
        }

        bfs(1, 1);

        System.out.println(map[N][M]);
    }

    private static void bfs(int startX, int startY) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{startX, startY});

        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();
            Integer currentX = poll[0];
            Integer currentY = poll[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX <= 0 || nextY <= 0 || nextX > N || nextY > M) {
                    continue;
                }

                if (map[nextX][nextY] == 1) {
                    map[nextX][nextY] = map[currentX][currentY] + 1;
                    queue.add(new Integer[]{nextX, nextY});
                }
            }
        }
    }
}
