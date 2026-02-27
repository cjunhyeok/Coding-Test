package main.java.algorithm.backtracking.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳_1987_백준 {

    private static int[][] values;
    private static boolean[] alphabet = new boolean[27];
    private static int[] dx = new int[]{-1, 0, 1, 0};
    private static int[] dy = new int[]{0, -1, 0, 1};
    private static int R, C;
    private static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        values = new int[R + 1][C + 1];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                char value = line.charAt(j);
                values[i][j] = value - 'A';
            }
        }

        alphabet[values[0][0]] = true;
        dfs(0, 0, 1);

        System.out.println(result);
    }

    private static void dfs(int startX, int startY, int depth) {
        result = Math.max(depth, result);

        for (int i = 0; i < 4; i++) {
            int nextX = startX + dx[i];
            int nextY = startY + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < R && nextY < C) {
                int value = values[nextX][nextY];
                if (!alphabet[value]) {
                    alphabet[value] = true;
                    dfs(nextX, nextY, depth + 1);
                    alphabet[value] = false;
                }
            }
        }
    }
}
