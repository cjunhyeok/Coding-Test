package main.java.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class 로프_2217_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] values = new Integer[N];

        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(values, Collections.reverseOrder());

        int maxWeight = values[0];

        for (int i = 1; i < N; i++) {
            maxWeight = Math.max(maxWeight, values[i] * (i + 1));
        }

        System.out.println(maxWeight);
    }
}
