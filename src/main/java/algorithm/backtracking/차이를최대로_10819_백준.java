package main.java.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 차이를최대로_10819_백준 {
    private static int[] path;
    private static boolean[] used;
    private static List<Integer> values = new ArrayList<>();
    private static int N;
    private static List<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        path = new int[N];
        used = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            values.add(value);
        }

        dfs(0);

        if (resultList.isEmpty()) {
            System.out.println();
        }

        Integer max = Collections.max(resultList);
        System.out.println(max);
    }

    private static void dfs(int depth) {
        if (depth == N) {
            int result = 0;
            for (int i = 0; i < N - 1; i++) {
                result = result + Math.abs(path[i] - path[i + 1]);
            }
            resultList.add(result);
            return;
        }

        for (int i = 0; i < N; i++) {
            Integer val = values.get(i);
            boolean isVisited = used[i];

            if (!isVisited) {
                used[i] = true;

                path[depth] = val;
                dfs(depth + 1);

                used[i] = false;
            }
        }
    }
}
