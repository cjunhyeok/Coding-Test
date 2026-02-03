package main.java.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 설탕배달_2839_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        boolean isCorrect = true;
        while (true) {

            if (N == 0) {
                break;
            }

            if (N % 5 != 0) {
                if (N < 3) {
                    isCorrect = false;
                    break;
                }
                N = N - 3;
                result++;
            } else {
                result = result + (N / 5);
                N = N % 5;
            }
        }

        if (isCorrect) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }
}
