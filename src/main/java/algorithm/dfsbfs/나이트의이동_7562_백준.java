package main.java.algorithm.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의이동_7562_백준 {

    private static int[][] grid;
    private static boolean[][] visited;
    private static int[] dx = new int[]{2, 2, -2, -2, 1, 1, -1, -1};
    private static int[] dy = new int[]{1, -1, 1, -1, 2, -2, 2, -2};
    private static int startX, startY, endX, endY;
    private static int T, I;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            I = Integer.parseInt(br.readLine());
            grid = new int[I][I];
            visited = new boolean[I][I];
            StringTokenizer st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            bfs(startX, startY);
        }
    }

    private static void bfs(int x, int y) {
        Queue<Integer[]> queue = new LinkedList<>();
        Integer[] value = new Integer[2];
        value[0] = x;
        value[1] = y;
        queue.add(value);

        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();
            Integer currentX = poll[0];
            Integer currentY = poll[1];

            if (currentX.equals(endX) && currentY.equals(endY)) {
                System.out.println(grid[currentX][currentY]);
                return;
            }

            for (int i = 0; i < dx.length; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= I || nextY >= I) {
                    continue;
                }

                if (visited[nextX][nextY]) {
                    continue;
                }

                visited[nextX][nextY] = true;
                grid[nextX][nextY] = grid[currentX][currentY] + 1;
                queue.add(new Integer[]{nextX, nextY});
            }
        }
    }
}
