package main.java.algorithm.backtracking.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 연속합_1912_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] values = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = values[0];

        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(values[i], dp[i - 1] + values[i]);
        }

        int result = Arrays.stream(dp).max().getAsInt();
        System.out.println(result);
    }
}
