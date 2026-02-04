package main.java.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class ATOB_16953_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Long A = Long.parseLong(st.nextToken());
        Long B = Long.parseLong(st.nextToken());

        Long result = 0L;

        while (true) {

            if (B < A) {
                result = -1L;
                break;
            }

            if (Objects.equals(A, B)) {
                result++;
                break;
            }

            if (B % 2 == 0) {
                B = B / 2;
                result++;
                continue;
            }

            if (B % 10 == 1) {
                B = B - 1;
                B = B / 10;
                result++;
                continue;
            }

            result = -1L;
            break;
        }

        System.out.println(result);
    }
}
