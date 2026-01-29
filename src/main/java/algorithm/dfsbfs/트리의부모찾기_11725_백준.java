package main.java.algorithm.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리의부모찾기_11725_백준 {

    static List<Integer>[] lists;
    static boolean[] visited;
    static int N;
    static Map<Integer, Integer> results = new TreeMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        lists = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lists[start].add(end);
            lists[end].add(start);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (Integer i : results.keySet()) {
            Integer value = results.get(i);
            sb.append(value + "\n");
        }

        System.out.println(sb);
    }

    static void dfs(int start) {
        visited[start] = true;

        List<Integer> list = lists[start];
        for (Integer i : list) {
            if (!visited[i]) {
                results.put(i, start);
                dfs(i);
            }
        }
    }
}
