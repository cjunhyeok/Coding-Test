package main.java.algorithm.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 영역구하기_2583_백준 {

    private static int N,M,K;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = new int[]{-1, 0, 1, 0};
    private static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine(), " ");

            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            for (int i = startX; i < endX; i++) {
                for (int j = startY; j < endY; j++) {
                    map[j][i] = 1;
//                    visited[j][i] = true;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int values = map[i][j];

                if (values == 0) {
                    if (!visited[i][j]) {
                        int count = bfs(i, j);
                        list.add(count);
                    }
                }
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append('\n');
        for (Integer i : list) {
            sb.append(i).append(' ');
        }

        System.out.println(sb);
    }

    private static int bfs(int startX, int startY) {
        Queue<Integer[]> queue = new LinkedList<>();
        visited[startX][startY] = true;
        queue.add(new Integer[]{startX, startY});

        int count = 0;
        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();
            Integer currentX = poll[0];
            Integer currentY = poll[1];
            count++;

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) {
                    continue;
                }

                if (visited[nextX][nextY]) {
                    continue;
                }

                if (map[nextX][nextY] == 0) {
                    visited[nextX][nextY] = true;
                    queue.add(new Integer[]{nextX, nextY});
                }
            }
        }

        return count;
    }
}
