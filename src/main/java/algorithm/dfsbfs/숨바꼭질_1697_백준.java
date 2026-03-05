package main.java.algorithm.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질_1697_백준 {

    private static int[] map = new int[100001];
    private static boolean[] visited = new boolean[100001];
    private static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N);

        System.out.println(map[K]);
    }

    private static void bfs(int start) {
        Queue<Integer[]> queue = new LinkedList<>();
        Integer[] value = new Integer[2];
        value[0] = start;
        value[1] = 0;
        queue.add(value);

        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();

            if (!visited[poll[0]]) {
                map[poll[0]] = poll[1];
                visited[poll[0]] = true;

                if (poll[0] == K) {
                    return;
                } else {
                    if (poll[0] > 0) {
                        Integer[] next = new Integer[2];
                        next[0] = poll[0] - 1;
                        next[1] = poll[1] + 1;
                        queue.add(next);
                    }

                    if (poll[0] < 100000) {
                        Integer[] next = new Integer[2];
                        next[0] = poll[0] + 1;
                        next[1] = poll[1] + 1;
                        queue.add(next);
                    }

                    if (poll[0] * 2 < 100000) {
                        Integer[] next = new Integer[2];
                        next[0] = poll[0] * 2;
                        next[1] = poll[1] + 1;
                        queue.add(next);
                    }
                }
            }
        }
    }
}
