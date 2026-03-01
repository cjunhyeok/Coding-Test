package main.java.algorithm.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 벽부수고이동하기_2206_백준 {

    private static int N, M;
    private static int[][] values;
    private static int[][][] dist;
    private static int[] dx = new int[]{-1, 0, 1, 0};
    private static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        values = new int[N][M];
        dist = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                values[i][j] = line.charAt(j) - '0';
            }
        }

        ArrayDeque<Node> queue = new ArrayDeque<>();

        dist[0][0][0] = 1;
        queue.add(new Node(0, 0, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int currentX = current.x;
            int currentY = current.y;
            int currentBroke = current.broke;

            if (currentX == N - 1 && currentY == M - 1) {
                System.out.println(dist[currentX][currentY][currentBroke]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX < 0 | nextY < 0 || nextX >= N || nextY >= M) continue;

                if (values[nextX][nextY] == 0) {
                    if (dist[nextX][nextY][currentBroke] == 0) {
                        dist[nextX][nextY][currentBroke] = dist[currentX][currentY][currentBroke] + 1;
                        queue.add(new Node(nextX, nextY, currentBroke));
                    }
                } else {
                    if (currentBroke == 0 && dist[nextX][nextY][1] == 0) {
                        dist[nextX][nextY][1] = dist[currentX][currentY][0] + 1;
                        queue.add(new Node(nextX, nextY, 1));
                    }
                }
            }
        }

        System.out.println(-1);
    }

    private static class Node {
        int x, y, broke;

        public Node(int x, int y, int broke) {
            this.x = x;
            this.y = y;
            this.broke = broke;
        }
    }
}
