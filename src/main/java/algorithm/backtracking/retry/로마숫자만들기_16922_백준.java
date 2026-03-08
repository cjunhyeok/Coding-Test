package main.java.algorithm.backtracking.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 로마숫자만들기_16922_백준 {

    private static int N;
    private static int[] romas = new int[]{1, 5, 10, 50};
    private static boolean[] seen = new boolean[1001];
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs(0, 0, 0);

        System.out.println(result);
    }

    private static void dfs(int start, int depth, int sum) {
        if (depth == N) {
            if (!seen[sum]) {
                seen[sum] = true;
                result++;
            }
            return;
        }

        for (int i = start; i < 4; i++) {
            dfs(i, depth + 1, sum + romas[i]);
        }
    }
}
