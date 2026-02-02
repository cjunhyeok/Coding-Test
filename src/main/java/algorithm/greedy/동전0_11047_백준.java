package main.java.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 동전0_11047_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        StringTokenizer st = new StringTokenizer(line, " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> coins = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            coins.add(value);
        }

        Collections.reverse(coins);

        int index = 0;
        int result = 0;
        while (K != 0) {

            Integer coin = coins.get(index);

            if (K >= coin) {
                K = K - coin;
                result++;
            } else {
                index++;
            }

        }

        System.out.println(result);
    }
}
