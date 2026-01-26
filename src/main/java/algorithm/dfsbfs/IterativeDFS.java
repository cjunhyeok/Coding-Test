package main.java.algorithm.dfsbfs;

import java.util.ArrayList;
import java.util.Stack;

public class IterativeDFS {

    static ArrayList<Integer>[] adjList;
    static boolean[] visited;

    public static void main(String[] args) {
        int n = 5;
        adjList = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(2, 4);
        addEdge(4, 5);

        iterativeDfs(1);
    }

    static void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u);
    }

    static void iterativeDfs(int start) {
        Stack<Integer> stack = new Stack<>();

        // 시작 노드 스택에 넣기
        stack.push(start);

        while (!stack.isEmpty()) {
            Integer curr = stack.pop();

            // 스택은 넣을 때가 아니라, 꺼낼 때 방문 처리를 하는 것이 일반적
            if (visited[curr]) {
                continue;
            }

            visited[curr] = true;

            // 인접 노드 탐색
            // 스택의 특성상 나중에 넣은게 먼저 나오므로,
            // 작은 번호부터 방문하고 싶다면 역순(Reverse)으로 넣어야 한다.
            for (int i = adjList[curr].size() - 1; i >= 0; i--) {
                Integer next = adjList[curr].get(i);
                if (!visited[next]) {
                    stack.push(next);
                }
            }
        }
    }
}
