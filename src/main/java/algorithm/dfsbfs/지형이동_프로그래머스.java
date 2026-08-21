package main.java.algorithm.dfsbfs;

import java.util.*;

public class 지형이동_프로그래머스 {

    static class Edge {
        int from;
        int to;
        int cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    private int n;
    private int[][] land;
    private int height;
    private int[][] area;
    private int areaCount;

    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, -1, 0, 1};

    private int[] parent;

    public int solution(int[][] land, int height) {
        this.land = land;
        this.height = height;
        this.n = land.length;
        this.area = new int[n][n];

        // 1. 영역 번호 붙이기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (area[i][j] == 0) {
                    areaCount++;
                    bfs(i, j, areaCount);
                }
            }
        }

        // 영역이 하나면 사다리 필요 없음
        if (areaCount == 1) {
            return 0;
        }

        // 2. 서로 다른 영역 사이의 간선 만들기
        List<Edge> edges = new ArrayList<>();

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        continue;
                    }

                    int currentArea = area[x][y];
                    int nextArea = area[nx][ny];

                    if (currentArea == nextArea) {
                        continue;
                    }

                    int cost = Math.abs(land[x][y] - land[nx][ny]);

                    edges.add(new Edge(currentArea, nextArea, cost));
                }
            }
        }

        // 3. 비용순 정렬
        edges.sort((a, b) -> Integer.compare(a.cost, b.cost));

        // 4. Union-Find 초기화
        parent = new int[areaCount + 1];

        for (int i = 1; i <= areaCount; i++) {
            parent[i] = i;
        }

        // 5. Kruskal
        int answer = 0;
        int selected = 0;

        for (Edge edge : edges) {
            int rootA = find(edge.from);
            int rootB = find(edge.to);

            if (rootA == rootB) {
                continue;
            }

            parent[rootB] = rootA;
            answer += edge.cost;
            selected++;

            if (selected == areaCount - 1) {
                break;
            }
        }

        return answer;
    }

    private void bfs(int startX, int startY, int areaNumber) {
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{startX, startY});
        area[startX][startY] = areaNumber;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int x = current[0];
            int y = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                if (area[nx][ny] != 0) {
                    continue;
                }

                int diff = Math.abs(land[x][y] - land[nx][ny]);

                if (diff > height) {
                    continue;
                }

                area[nx][ny] = areaNumber;
                queue.offer(new int[]{nx, ny});
            }
        }
    }

    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}
