package main.java.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 부등호_2529_백준 {

    private static int K;
    private static char[] values;
    private static int[] path;
    private static boolean[] used;
    private static StringBuilder sb = new StringBuilder();
    private static Set<String> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        values = new char[K];
        path = new int[K + 1];
        used = new boolean[10];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < K; i++) {
            values[i] = st.nextToken().charAt(0);
        }

        for (int i = 0; i <= 9; i++) {
            path[0] = i;
            used[i] = true;
            dfs(0, 1, i);
            used[i] = false;
        }

        Object[] array = set.toArray();

        System.out.println((String) array[set.size() - 1]);
        System.out.println((String) array[0]);
    }

    private static void dfs(int idx, int depth, int prev) {
        if (depth == K + 1) {
            for (int i = 0; i <= K; i++) {
                sb.append(path[i]);
            }
            String string = sb.toString();
            set.add(string);
            sb = new StringBuilder();
            return;
        }

        for (int i = 0; i <= 9; i++) {
            char value = values[idx];

            if (value == '<') {
                if (i > prev) {
                    if (!used[i]) {
                        path[depth] = i;
                        used[i] = true;
                        dfs(idx + 1, depth + 1, i);
                        used[i] = false;
                    }
                }
            } else if (value == '>') {
                if (i < prev) {
                    if (!used[i]) {
                        path[depth] = i;
                        used[i] = true;
                        dfs(idx + 1, depth + 1, i);
                        used[i] = false;
                    }
                }
            }
        }
    }
}
