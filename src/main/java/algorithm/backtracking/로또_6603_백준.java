package main.java.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 로또_6603_백준 {

    static int[] path;
    static int k;
    static List<Integer> list;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = br.readLine();

            if (line.equals("0")) {
                break;
            }

            StringTokenizer st = new StringTokenizer(line, " ");
            k = Integer.parseInt(st.nextToken());
            sb = new StringBuilder();

            list = new ArrayList<>();
            path = new int[7];

            for (int i = 0; i < k; i++) {
                int value = Integer.parseInt(st.nextToken());
                list.add(value);
            }

            Collections.sort(list);

            dfs(0, 0);
            System.out.println(sb);
        }

    }

    static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(path[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < k; i++) {
            Integer value = list.get(i);
            path[depth] = value;

            dfs(i + 1, depth + 1);
        }
    }
}
