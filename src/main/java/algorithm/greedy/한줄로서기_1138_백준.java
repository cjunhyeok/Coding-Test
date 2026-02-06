package main.java.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 한줄로서기_1138_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] results = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            int value = Integer.parseInt(st.nextToken());

            for (int j = 0; j < N; j++) {

                if (value > 0 && results[j] == 0) {
                    value--;
                } else if (value == 0 && results[j] == 0) {
                    results[j] = i;
                    break;
                }
            }
        }

        for (int result : results) {
            System.out.print(result + " ");
        }
    }
}
