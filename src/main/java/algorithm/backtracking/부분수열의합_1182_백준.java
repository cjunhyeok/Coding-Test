package main.java.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합_1182_백준 {

    private static int N, S;
    private static int[] arr;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        StringTokenizer st = new StringTokenizer(line, " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr[i] = value;
        }

        dfs(0, 0);

        if (S == 0) {
            count--;
        }

        System.out.println(count);
    }

    private static void dfs(int idx, int sum) {

        if (idx == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        dfs(idx + 1, sum);

        dfs(idx + 1, sum + arr[idx]);
    }
}
