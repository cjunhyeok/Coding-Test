package main.java.algorithm.backtracking.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합_1182_백준 {

    private static int N, S;
    private static int[] values;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        values = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            values[i] = value;
        }

        dfs(0, 0);

        if (S == 0) {
            if (result > 0) {
                result--;
            }
        }

        System.out.println(result);
    }

    private static void dfs(int start, int sum) {

        if (start == N) {
            if (sum == S) {
                result++;
            }
            return;
        }
        int value = values[start];

        dfs(start + 1, sum + value);
        dfs(start + 1, sum);
    }
}
