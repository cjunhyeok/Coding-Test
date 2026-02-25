package main.java.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도영이가만든맛있는음식_2961_백준 {

    private static int[] S, B;
    private static int N;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        S = new int[N];
        B = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            S[i] = s;
            B[i] = b;
        }

        dfs(0, 1, 0, false);

        System.out.println(result);
    }

    private static void dfs(int depth, int mul, int sum, boolean used) {
        if (depth == N) {
            if (used) {
                result = Math.min(result, Math.abs(mul - sum));
            }
            return;
        }

        // 선택
        dfs(depth + 1, mul * S[depth], sum + B[depth], true);

        // 비선택
        dfs(depth + 1, mul, sum, used);
    }
}
