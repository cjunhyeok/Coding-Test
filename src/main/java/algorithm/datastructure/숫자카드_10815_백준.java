package main.java.algorithm.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 숫자카드_10815_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();

        String value = br.readLine();
        StringTokenizer st = new StringTokenizer(value, " ");

        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            set.add(val);
        }

        int M = Integer.parseInt(br.readLine());

        value = br.readLine();
        st = new StringTokenizer(value, " ");

        for (int i = 0; i < M; i++) {
            int val = Integer.parseInt(st.nextToken());

            if (set.contains(val)) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
    }
}
