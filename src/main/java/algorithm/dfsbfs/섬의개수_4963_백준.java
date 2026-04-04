package main.java.algorithm.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 섬의개수_4963_백준 {

    private static int w, h;
    private static int[][] lists;
    private static boolean[][] visited;
    private static int[] dx = new int[]{-1, 0, 1, 0, -1, -1, 1, 1};
    private static int[] dy = new int[]{0, -1, 0, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();

            if (line.equals("0 0")) {
                return;
            }

            StringTokenizer st = new StringTokenizer(line, " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            lists = new int[w][h];
            visited = new boolean[w][h];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < w; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    lists[j][i] = value;
                }
            }

            int result = 0;
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (!visited[i][j] && lists[i][j] == 1) {
                        bfs(i, j);
                        result++;
                    }
                }
            }

            System.out.println(result);
        }
    }

    private static void bfs(int startX, int startY) {
        Queue<Integer[]> queue = new LinkedList<>();
        visited[startX][startY] = true;
        queue.add(new Integer[]{startX, startY});

        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();
            Integer currentX = poll[0];
            Integer currentY = poll[1];

            for (int i = 0; i < 8; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= w || nextY >= h) {
                    continue;
                }

                if (visited[nextX][nextY]) {
                    continue;
                }

                if (lists[nextX][nextY] == 1) {
                    visited[nextX][nextY] = true;
                    queue.add(new Integer[]{nextX, nextY});
                }
            }
        }
    }
}
