package main.java.algorithm.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 촌수계산_2644_백준 {

    static List<Integer>[] lists;
    static int start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        lists = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            line = br.readLine();
            st = new StringTokenizer(line, " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            lists[x].add(y);
            lists[y].add(x);
        }

        dfs(start);
    }

    static void dfs(int startX) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startX);

        int[] dist = new int[lists.length];
        Arrays.fill(dist, -1);
        dist[startX] = 0;


        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            List<Integer> list = lists[poll];

            for (Integer i : list) {
                if (dist[i] == -1) {
                    dist[i] = dist[poll] + 1;
                    queue.add(i);
                }
            }
        }

        System.out.println(dist[end]);
    }
}
