package main.java.algorithm;

import java.util.*;

public class 메뉴리뉴얼_프로그래머스 {

    private static Map<String, Integer> map;
    private static char[] path;

    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        List<String> resultList = new ArrayList<>();

        for (int i = 0; i < course.length; i++) {

            map = new HashMap<>();
            int targetDepth = course[i];
            path = new char[targetDepth];

            for (int j = 0; j < orders.length; j++) {
                String order = orders[j];
                char[] chars = order.toCharArray();

                Arrays.sort(chars);

                String result = new String(chars);
                dfs(0, 0, targetDepth, result);
            }

            List<String> tempResult = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            for (String s : map.keySet()) {
                Integer count = map.get(s);
                if (count >= 2) {
                    if (count > max) {
                        max = count;
                        tempResult = new ArrayList<>();
                        tempResult.add(s);
                    } else if (count == max) {
                        tempResult.add(s);
                    }
                }
            }

            if (max >= 2) {
                if (!tempResult.isEmpty()) {
                    for (String s : tempResult) {
                        resultList.add(s);
                    }
                }
            }
        }

        resultList.sort((a, b) -> {
            return a.compareTo(b);
        });
        answer = resultList.toArray(new String[0]);

        return answer;
    }

    private static void dfs(int start, int depth, int targetDepth, String order) {
        if (depth == targetDepth) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < depth; i++) {
                sb.append(path[i]);
            }
            String value = sb.toString();
            if (map.containsKey(value)) {
                Integer count = map.get(value);
                map.put(value, count + 1);
            } else {
                map.put(value, 1);
            }
            return;
        }

        for (int i = start; i < order.length(); i++) {
            char value = order.charAt(i);

            path[depth] = value;
            dfs(i + 1, depth + 1, targetDepth, order);
        }
    }
}
