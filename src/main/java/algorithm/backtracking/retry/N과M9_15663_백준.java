package main.java.algorithm.backtracking.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M9_15663_백준 {

    private static int N,M;
    private static int[] values;
    private static int[] path;
    private static boolean[] used;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        values = new int[N];
        path = new int[N];
        used = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(values);

        dfs(0, -1);

        System.out.println(sb);
    }

    private static void dfs(int depth, int prev) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(path[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            int value = values[i];

            if (value == prev) {
                continue;
            }

            if (!used[i]) {
                prev = value;

                path[depth] = value;
                used[i] = true;
                dfs(depth + 1, -1);
                used[i] = false;
            }
        }
    }
}
