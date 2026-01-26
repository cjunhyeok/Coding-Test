package main.java.algorithm.dfsbfs;

import java.util.ArrayList;

public class DFSTemplate {

    // 그래프를 표현할 인접 리스트 (배열 안에 리스트)
    static ArrayList<Integer>[] adjList;
    // 방문 여부를 체크할 배열
    static boolean[] visited;

    public static void main(String[] args) {
        // 예시 데이터 정점 5 (1 ~ 5번),  간선 4
        int n = 5;
        adjList = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(2, 4);
        addEdge(4, 5);

        dfs(1);
    }

    static void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u);
    }

    static void dfs(int curr) {
        // 현재 노드 방문 처리
        visited[curr] = true;

        for (int next : adjList[curr]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
