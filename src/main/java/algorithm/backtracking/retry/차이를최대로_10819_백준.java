package main.java.algorithm.backtracking.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 차이를최대로_10819_백준 {

    private static int[] values;
    private static boolean[] used;
    private static int N;
    private static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        values = new int[N];
        used = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            values[i] = value;
        }

        dfs(0, 0);

        System.out.println(result);
    }

    private static void dfs(int depth, int sum) {
        if (depth == N - 1) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < N - 1; i++) {
            if (!used[i]) {
                used[i] = true;

                int abs = Math.abs(values[i] - values[i + 1]);
                dfs(depth + 1, sum + abs);

                used[i] = false;
            }
        }
    }
}
