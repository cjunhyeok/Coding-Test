package main.java.algorithm.backtracking.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합_1182_백준 {

    private static int N,S;
    private static int[] values;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        values = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);

        if (S == 0) {
            System.out.println(count - 1);
        } else {
            System.out.println(count);
        }
    }

    private static void dfs(int index, int depth, int sum) {
        if (depth == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        dfs(index + 1, depth + 1, sum);

        dfs(index + 1, depth + 1, sum + values[index]);
    }
}
