package main.java.algorithm.greedy.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 한줄로서기_1138_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] list = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int value = Integer.parseInt(st.nextToken());
            list[i] = value;
        }

        int[] result = new int[N];
        for (int i = 1; i <= N; i++) {

            int value = list[i];
            int count = 0;

            for (int j = 0; j < N; j++) {

                if (count == value) {
                    if (result[j] == 0) {
                        result[j] = i;
                        break;
                    }
                } else {
                    if (result[j] == 0) {
                        count++;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(' ');
        }

        System.out.println(sb);
    }
}
