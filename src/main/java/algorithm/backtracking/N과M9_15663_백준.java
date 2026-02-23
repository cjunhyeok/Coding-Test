package main.java.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M9_15663_백준 {

    private static int[] path;
    private static boolean[] used;
    private static int[] values;
    private static int N, M;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        path = new int[M];
        used = new boolean[N];
        values = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            values[i] = value;
        }

        Arrays.sort(values);

        dfs(0);

        System.out.println(sb);
    }

    static void dfs (int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(path[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {

            if (!used[i]) {
                if (values[i] == prev) {
                    continue;
                }

                prev = values[i];

                used[i] = true;
                path[depth] = values[i];
                dfs(depth + 1);
                used[i] = false;
            }
        }
    }
}
