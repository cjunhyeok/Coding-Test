package main.java.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기_14888_백준 {

    private static int values[];
    private static int MAX = Integer.MIN_VALUE;
    private static int MIN = Integer.MAX_VALUE;
    private static int operations[] = new int[4];
    private static int path[] = new int[4];
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        values = new int[N];
        path = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            values[i] = val;
        }

        path[0] = values[0];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            int operation = Integer.parseInt(st.nextToken());
            operations[i] = operation;
        }

        dfs(1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    static void dfs(int depth) {
        if (depth == N) {
            MAX = Math.max(MAX, path[depth - 1]);
            MIN = Math.min(MIN, path[depth - 1]);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int operation = operations[i];

            if (operation == 0) {
                continue;
            }

            operations[i] = operations[i] - 1;

            if (i == 0) {
                // plus
                path[depth] = path[depth - 1] + values[depth];
            } else if (i == 1) {
                // minus
                path[depth] = path[depth - 1] - values[depth];
            } else if (i == 2) {
                path[depth] = path[depth - 1] * values[depth];
            } else if (i == 3) {
                if (path[depth - 1] < 0) {
                    path[depth - 1] = path[depth - 1] * -1;
                    path[depth]= path[depth - 1] / values[depth];
                    path[depth] = path[depth] * -1;
                    path[depth - 1] = path[depth - 1] * -1;
                } else {
                    path[depth] = path[depth - 1] / values[depth];
                }
            }

            dfs(depth + 1);

            operations[i] = operations[i] + 1;
        }
    }
}
