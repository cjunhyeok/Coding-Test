package main.java.algorithm.dfsbfs.retry;

import java.util.*;

public class 지형이동_프로그래머스 {

    private static int N;
    private static int[][] LAND;
    private static int[][] AREA;
    private static int HEIGHT;
    private static boolean[][] visited;
    private static int areaCount = 1;

    private static int[] parent;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    public static int solution(int[][] land, int height) {
        int answer = 0;

        N = land.length;
        LAND = land;
        HEIGHT = height;

        AREA = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]){
                    bfs(i, j);
                    areaCount++;
                }
            }
        }

        if (areaCount == 1) {
            return answer;
        }

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int currentArea = AREA[i][j];
                int currentCost = LAND[i][j];

                for (int k = 0; k < 4; k++) {
                    int nextX = i + dx[k];
                    int nextY = j + dy[k];

                    if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                        continue;
                    }

                    int nextArea = AREA[nextX][nextY];
                    if (currentArea == nextArea) {
                        continue;
                    }

                    int nextCost = LAND[nextX][nextY];
                    int cost = Math.abs(currentCost - nextCost);

                    edges.add(new int[]{currentArea, nextArea, cost});
                }
            }
        }

        edges.sort((a, b) -> {
            return a[2] - b[2];
        });

        parent = new int[areaCount];
        for (int i = 0; i < areaCount; i++) {
            parent[i] = i;
        }

        int count = 1;
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int cost = edge[2];

            int startParent = find(start);
            int endParent = find(end);

            if (startParent == endParent) {
                continue;
            }

            parent[endParent] = startParent;
            answer += cost;
            count++;

            if (count == areaCount) {
                break;
            }
        }

        return answer;
    }

    private static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        AREA[startX][startY] = areaCount;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            int currentCost = LAND[currentX][currentY];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                    continue;
                }

                if (visited[nextX][nextY]) {
                    continue;
                }

                int nextCost = LAND[nextX][nextY];
                int cost = Math.abs(currentCost - nextCost);
                if (cost <= HEIGHT) {
                    queue.add(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                    AREA[nextX][nextY] = areaCount;
                }
            }
        }
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}
