package main.java.algorithm.dp.retry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N으로표현_프로그래머스 {
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        for (int i = 1; i <= 8; i++) {
            int repeat = 0;

            for (int j = 0; j < i; j++){
                 repeat = repeat * 10 + N;
            }

            dp.get(i).add(repeat);

            for (int left = 1; left < i; left++) {
                int right = i - left;

                Set<Integer> lefts = dp.get(left);
                for (Integer l : lefts) {
                    Set<Integer> rights = dp.get(right);
                    for (Integer r : rights) {
                        dp.get(i).add(l + r);
                        dp.get(i).add(l - r);
                        dp.get(i).add(l * r);

                        if (r != 0) {
                            dp.get(i).add(l / r);
                        }
                    }
                }
            }

            if (dp.get(i).contains(number)) {
                return i;
            }
        }

        return -1;
    }
}
