package main.java.algorithm.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 알고리즘수업깊이우선탐색1_24479_백준 {

    static PriorityQueue<Integer>[] lists;
    static boolean[] visited;
    static int N, M, R;
    static int[] results;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        StringTokenizer st = new StringTokenizer(line, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        lists = new PriorityQueue[N + 1];
        visited = new boolean[N + 1];
        results = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            lists[i] = new PriorityQueue<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            lists[u].add(v);
            lists[v].add(u);
        }

        dfs(R);

        for (int i = 1; i <= N; i++) {
            if (results[i] == 0) {
                System.out.println(0);
            } else {
                System.out.println(results[i]);
            }
        }
    }

    static void dfs(int start) {
        visited[start] = true;
        results[start] = count;

        PriorityQueue<Integer> list = lists[start];

        while (!list.isEmpty()) {
            Integer poll = list.poll();

            if (!visited[poll]) {
                count++;
                dfs(poll);
            }
        }
    }
}
