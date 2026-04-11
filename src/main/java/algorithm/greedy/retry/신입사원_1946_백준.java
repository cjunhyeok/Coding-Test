package main.java.algorithm.greedy.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 신입사원_1946_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T --> 0) {
            int N = Integer.parseInt(br.readLine());

            List<int[]> list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int document = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());

                list.add(new int[]{document, interview});
            }

            Collections.sort(list, (s1, s2) -> {
                return s1[0] - s2[0];
            });

            int result = list.size();
            int minInterview = list.get(0)[1];
            for (int i = 1; i < list.size(); i++) {
                int interview = list.get(i)[1];

                if (interview > minInterview) {
                    result--;
                } else {
                    minInterview = interview;
                }
            }

            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }
}
