package main.java.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 신입사원_1946_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            int N = Integer.parseInt(br.readLine());
            List<int[]> lists = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                int[] value = new int[]{a, b};
                lists.add(value);
            }

            Collections.sort(lists, (s1, s2) -> {
                return s1[0] - s2[0];
            });

            int result = lists.size();
            int maxValue = lists.get(0)[1];

            for (int i = 1; i < lists.size(); i++) {
                int value = lists.get(i)[1];

                if (value > maxValue) {
                    result--;
                } else if (value < maxValue) {
                    maxValue = value;
                }
            }

            System.out.println(result);
        }
    }

    // 인덱스가 서류 순위, 값이 면접 순위인 배열 생성
    // 1등부터 N등까지이므로 크기를 N + 1로 잡습니다
    /**
     * int[] interviewRanks = new int[N + 1];
     *
     * for (int i = 0; i < N; i++) {
     *      StringTokenizer st = new StringTokenizer(br.readLine());
     *      int docRank = Integer.parseInt(st.nextToken());
     *      int interviewRank = Integer.parseInt(st.nextToken());
     *      interviewRanks[docRank] = interviewRank;
     * }
     */

}
