package main.java.algorithm.dfsbfs.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 촌수계산_2644_백준 {

    private static int N, M;
    private static List<Integer>[] lists;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        lists = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            lists[x].add(y);
            lists[y].add(x);
        }

        bfs(start, end);
    }

    private static void bfs(int start, int end) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();
            Integer value = poll[0];
            Integer step = poll[1];

            if (Objects.equals(end, value)) {
                System.out.println(step);
                return;
            }

            List<Integer> list = lists[value];
            for (Integer i : list) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(new Integer[]{i, step + 1});
                }
            }
        }

        System.out.println(-1);
    }
}
