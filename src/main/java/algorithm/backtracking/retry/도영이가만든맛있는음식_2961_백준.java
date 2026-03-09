package main.java.algorithm.backtracking.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도영이가만든맛있는음식_2961_백준 {

    private static int[] S;
    private static int[] B;
    private static int N;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        S = new int[N];
        B = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 1, 0, false);

        System.out.println(result);
    }

    private static void dfs(int index, int s, int b, boolean used) {
        if (index == N) {
            if (used) {
                result = Math.min(Math.abs(s - b), result);
            }
            return;
        }

        dfs(index + 1, s * S[index], b + B[index], true);

        dfs(index + 1, s, b, used);
    }
}
