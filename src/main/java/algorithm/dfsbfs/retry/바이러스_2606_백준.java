package main.java.algorithm.dfsbfs.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 바이러스_2606_백준 {

    private static int N, M;
    private static List<Integer>[] virus;
    private static boolean[] visited;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        virus = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            virus[i] = new ArrayList<>();
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            virus[start].add(end);
            virus[end].add(start);
        }

        dfs(1);

        System.out.println(result);
    }

    private static void dfs(int start) {
        visited[start] = true;

        List<Integer> values = virus[start];
        for (Integer value : values) {
            if (!visited[value]) {
                dfs(value);
                result++;
            }
        }
    }
}
