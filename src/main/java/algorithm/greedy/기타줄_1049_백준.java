package main.java.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타줄_1049_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int minPackage = Integer.MAX_VALUE;
        int minPeace = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int pack = Integer.parseInt(st.nextToken());
            int peace = Integer.parseInt(st.nextToken());

            if (pack < minPackage) {
                minPackage = pack;
            }

            if (peace < minPeace) {
                minPeace = peace;
            }
        }

        int result = 0;
        while (N > 0) {

            if ((minPeace * 6) < minPackage) {
                result = minPeace * N;
                break;
            }

            if (N >= 6) {
                N = N - 6;
                result = result + minPackage;
            } else {
                if (N * minPeace > minPackage) {
                    result = result + minPackage;
                    N = 0;
                } else {
                    result = result + (N * minPeace);
                    N = 0;
                }
            }
        }

        System.out.println(result);
    }
}
