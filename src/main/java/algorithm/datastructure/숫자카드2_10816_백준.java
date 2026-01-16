package main.java.algorithm.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 숫자카드2_10816_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());

            if (map.containsKey(val)) {
                Integer count = map.get(val);
                count = count + 1;
                map.put(val, count);
            } else {
                map.put(val, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < M; i++) {
            int val = Integer.parseInt(st.nextToken());

            if (map.containsKey(val)) {
                System.out.print(map.get(val) + " ");
            } else {
                System.out.print(0 + " ");
            }
        }
    }
}
