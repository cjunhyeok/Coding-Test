package main.java.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ATM_11399_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> lists = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            lists.add(value);
        }

        Collections.sort(lists);

        int[] values = new int[N];
        int result = lists.get(0);
        values[0] = lists.get(0);
        for (int i = 1; i < N; i++) {
            values[i] = values[i - 1] + lists.get(i);
            result = result + values[i];
        }

        System.out.println(result);
    }
}
