package main.java.algorithm.implementaion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 분수찾기_1193_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println("1/1");
            System.exit(0);
        }

        if (N == 2) {
            System.out.println("1/2");
            System.exit(0);
        }

        if (N == 3) {
            System.out.println("2/1");
            System.exit(0);
        }

        int left = 2;
        int right = 1;

        boolean isLeftPlus = true;

        for (int i = 4; i <= N; i++) {

            if (left == 1) {

                if (isLeftPlus) {
                    left = left + 1;
                    right = right - 1;
                } else {
                    right = right + 1;
                    isLeftPlus = true;
                }

            } else if (right == 1) {

                if (!isLeftPlus) {
                    left = left - 1;
                    right = right + 1;
                } else {
                    left = left + 1;
                    isLeftPlus = false;
                }

            } else {

                if (isLeftPlus) {
                    left = left + 1;
                    right = right - 1;
                } else {
                    left = left - 1;
                    right = right + 1;
                }

            }
        }

        System.out.println(left + "/" + right);
    }
}
