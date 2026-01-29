package main.java.algorithm.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농배추_1012_백준 {

    static int[][] list;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int M, N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            String line = br.readLine();

            StringTokenizer st = new StringTokenizer(line, " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            list = new int[M][N];
            visited = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                line = br.readLine();

                st = new StringTokenizer(line, " ");
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                list[X][Y] = 1;
            }

            int result = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if ((list[i][j] == 1) && !visited[i][j]) {
                        dfs(i, j);
                        result++;
                    }
                }
            }

            System.out.println(result);
        }
    }

    static void dfs(int startX, int startY){
        visited[startX][startY] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = startX + dx[i];
            int nextY = startY + dy[i];

            if (nextX < M && nextY < N && nextX >= 0 && nextY >= 0) {
                if (list[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    dfs(nextX, nextY);
                }
            }
        }
    }
}
