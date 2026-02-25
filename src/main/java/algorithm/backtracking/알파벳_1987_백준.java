package main.java.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳_1987_백준 {

    private static int R, C;
    private static char[][] values;
    private static boolean[] alphabet = new boolean[27];
    private static int[] dx = new int[]{-1, 0, 1, 0};
    private static int[] dy = new int[]{0, -1, 0, 1};
    private static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        values = new char[R + 1][C + 1];

        for (int i = 1; i <= R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                char value = line.charAt(j);
                values[i][j + 1] = value;
            }
        }

        alphabet[values[1][1] - 'A'] = true;

        dfs(1, 1, 1);

        System.out.println(result);
    }

    private static void dfs(int startX, int startY, int count) {

        result = Math.max(result, count);

        for (int i = 0; i < 4; i++) {
            int nextX = startX + dx[i];
            int nextY = startY + dy[i];

            if (nextX > 0 && nextY > 0 && nextX <= R && nextY <= C) {
                int c = values[nextX][nextY] - 'A';
                if (!alphabet[c]) {
                    alphabet[c] = true;
                    dfs(nextX, nextY, count + 1);
                    alphabet[c] = false;
                }
            }
        }
    }
}
