package main.java.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 보물_1026_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> A = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            A.add(value);
        }

        List<Integer> B = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            B.add(value);
        }

        Collections.sort(A);
        Collections.sort(B);
        Collections.reverse(B);

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = result + (A.get(i) * B.get(i));
        }

        System.out.println(result);
    }
}
