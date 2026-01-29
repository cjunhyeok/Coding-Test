package main.java.algorithm.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 단지번호붙이기_2667_백준 {

    static int[][] lists;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        lists = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < line.length(); j++) {
                char value = line.charAt(j);

                if (value == '0') {
                    lists[i][j] = 0;
                } else if (value == '1') {
                    lists[i][j] = 1;
                }
            }
        }

        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lists[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    dfs(i, j);
                    results.add(count);
                }
            }
        }

        Collections.sort(results);

        StringBuilder sb = new StringBuilder();
        sb.append(results.size() + "\n");

        for (Integer result : results) {
            sb.append(result + "\n");
        }

        System.out.println(sb);
    }

    static void dfs(int startX, int startY) {
        visited[startX][startY] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nextX = startX + dx[i];
            int nextY = startY + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
                if (lists[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    dfs(nextX, nextY);
                }
            }
        }
    }
}
