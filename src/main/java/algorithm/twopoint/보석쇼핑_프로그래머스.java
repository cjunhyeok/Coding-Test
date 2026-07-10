package main.java.algorithm.twopoint;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 보석쇼핑_프로그래머스 {

    public int[] solution(String[] gems) {
        int[] answer = {};

        Set<String> gemSet = new HashSet<>();
        for (String gem : gems) {
            gemSet.add(gem);
        }

        int gemSize = gemSet.size();
        int N = gems.length;

        Map<String, Integer> map = new HashMap<>();
        map.put(gems[0], 1);

        int left = 0;
        int right = 0;
        int length = Integer.MAX_VALUE;

        while (left < N) {

            int currentSize = map.size();
            int currentLength = right - left;

            if (right == N - 1) {
                if (currentSize < gemSize) {
                    break;
                }
            }

            if (currentSize == gemSize) {
                if (currentLength < length) {
                    length = currentLength;
                    answer = new int[]{left + 1, right + 1};

                    if (length == gemSize - 1) {
                        return answer;
                    }
                }

                String gem = gems[left];
                left++;

                Integer count = map.get(gem);
                if (count == 1) {
                    map.remove(gem);
                } else {
                    map.put(gem, count - 1);
                }
            } else if (currentSize < gemSize) {
                right++;
                String gem = gems[right];

                if (map.containsKey(gem)) {
                    map.put(gem, map.get(gem) + 1);
                } else {
                    map.put(gem, 1);
                }
            } else {
                String gem = gems[left];
                left++;

                Integer count = map.get(gem);
                if (count == 1) {
                    map.remove(gem);
                } else {
                    map.put(gem, count - 1);
                }
            }

        }

        return answer;
    }
}
