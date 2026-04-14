package main.java.algorithm.backtracking.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M2_15650_백준 {

    private static int N, M;
    private static int[] path;
    private static boolean[] used;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        path = new int[M];
        used = new boolean[N + 1];

        dfs(0, 1);

        System.out.println(sb);
    }

    private static void dfs(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(path[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i <= N; i++) {
            if (!used[i]) {
                path[depth] = i;
                used[i] = true;
                dfs(depth + 1, i + 1);
                used[i] = false;
            }
        }
    }
}
