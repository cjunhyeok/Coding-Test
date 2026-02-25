package main.java.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스타트와링크_14889_백준 {

    private static int[][] S;
    private static boolean[] pick;
    private static int N;
    private static int best = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        S = new int[N][N];
        pick = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(best);
    }

    private static void dfs(int idx, int cnt) {
        if (idx == N) {
            if (cnt == N / 2) {
                best = Math.min(best, diff());
            }
            return;
        }

        pick[idx] = true;
        dfs(idx + 1, cnt + 1);

        pick[idx] = false;
        dfs(idx + 1, cnt);
    }

    private static int diff() {
        int s = 0;
        int l = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int pair = S[i][j] + S[j][i];
                if (pick[i] && pick[j]) {
                    s = s + pair;
                } else if (!pick[i] && !pick[j]) {
                    l = l + pair;
                }
            }
        }

        return Math.abs(s - l);
    }
}
