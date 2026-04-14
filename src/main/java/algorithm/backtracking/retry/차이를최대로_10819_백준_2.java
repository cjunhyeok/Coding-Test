package main.java.algorithm.backtracking.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 차이를최대로_10819_백준_2 {

    private static int N;
    private static int[] path;
    private static int[] values;
    private static boolean[] used;
    private static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        path = new int[N];
        values = new int[N];
        used = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(result);
    }

    private static void dfs(int depth) {
        if (depth == N) {
            int sum = 0;
            for (int i = 1; i < N; i++) {
                sum = sum + Math.abs(path[i - 1] - path[i]);
            }
            result = Math.max(sum, result);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                used[i] = true;
                path[depth] = values[i];
                dfs(depth + 1);
                used[i] = false;
            }
        }
    }
}
