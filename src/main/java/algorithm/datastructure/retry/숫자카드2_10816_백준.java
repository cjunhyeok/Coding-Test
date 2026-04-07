package main.java.algorithm.datastructure.retry;

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

        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());

            if (map.containsKey(value)) {
                Integer count = map.get(value);
                map.put(value, count + 1);
            } else {
                map.put(value, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (map.containsKey(value)) {
                sb.append(map.get(value)).append(' ');
            } else {
                sb.append(0).append(' ');
            }
        }

        System.out.println(sb);
    }
}
