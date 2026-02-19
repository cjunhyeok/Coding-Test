package main.java.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 모든순열_10974_백준 {

    private static int[] path;
    private static boolean[] used;
    private static int N;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        path = new int[N + 1];
        used = new boolean[N + 1];

        dfs(0);

        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                sb.append(path[i]).append(' ');
            }
            sb.append('\n');
        }

        for (int i = 1; i <= N; i++) {

            if (!used[i]) {
                path[depth] = i;
                used[i] = true;

                dfs(depth + 1);

                used[i] = false;
            }
        }
    }
}
