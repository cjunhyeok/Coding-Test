package main.java.algorithm.backtracking.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 모든순열_10974_백준_2 {

    private static int N;
    private static int[] path;
    private static boolean[] used;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        path = new int[N];
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
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!used[i]) {
                used[i] = true;
                path[depth] = i;
                dfs(depth + 1);
                used[i] = false;
            }
        }
    }
}
