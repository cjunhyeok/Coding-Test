package main.java.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M2_15650_백준 {

    static int N, M;
    static int[] path;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        path = new int[M];

        dfs(1, 0);

        System.out.print(sb);
    }

    static void dfs(int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(path[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i <= N; i++) {
            path[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}
