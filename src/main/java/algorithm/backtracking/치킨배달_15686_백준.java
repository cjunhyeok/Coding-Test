package main.java.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 치킨배달_15686_백준 {

    private static int N,M;
    private static List<Integer[]> houses = new ArrayList<>();
    private static List<Integer[]> chickens = new ArrayList<>();
    private static int[] selected;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selected = new int[M];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                int value = Integer.parseInt(st.nextToken());

                if (value == 1) {
                    houses.add(new Integer[]{i, j});
                } else if (value == 2) {
                    chickens.add(new Integer[]{i, j});
                }
            }
        }

        dfs(0, 0);

        System.out.println(result);
    }

    private static void dfs(int start, int depth) {
        if (depth == M) {
            result = Math.min(result, getDistance());
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }

    private static int getDistance() {
        int total = 0;

        for (Integer[] house : houses) {
            Integer hx = house[0];
            Integer hy = house[1];
            int minDistance = Integer.MAX_VALUE;

            for (int i = 0; i < M; i++) {
                Integer[] chicken = chickens.get(selected[i]);
                Integer cx = chicken[0];
                Integer cy = chicken[1];

                int distance = Math.abs(hx - cx) + Math.abs(hy - cy);
                minDistance = Math.min(minDistance, distance);
            }

            total = total + minDistance;
        }

        return total;
    }
}
