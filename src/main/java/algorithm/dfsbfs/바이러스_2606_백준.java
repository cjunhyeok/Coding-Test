package main.java.algorithm.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 바이러스_2606_백준 {

    static List<Integer>[] lists;
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        lists = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lists[start].add(end);
            lists[end].add(start);
        }

        dfs(1);
        System.out.println(result);
    }

    static void dfs(int start) {
        visited[start] = true;
        if (start != 1) {
            result++;
        }

        List<Integer> list = lists[start];
        for (Integer i : list) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}
