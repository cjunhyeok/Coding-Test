package main.java.algorithm.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N으로표현_프로그래머스 {

    public static int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();

        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        for (int count = 1; count <= 8; count++) {
            int repeated = 0;

            for (int i = 0; i < count; i++) {
                repeated = repeated * 10 + N;
            }

            dp.get(count).add(repeated);

            for (int left = 1; left < count; left++) {
                int right = count - left;

                for (int a : dp.get(left)) {
                    for (int b : dp.get(right)) {
                        dp.get(count).add(a + b);
                        dp.get(count).add(a - b);
                        dp.get(count).add(a * b);

                        if (b != 0) {
                            dp.get(count).add(a / b);
                        }
                    }
                }
            }

            if (dp.get(count).contains(number)) {
                return count;
            }
        }

        return -1;
    }
}
