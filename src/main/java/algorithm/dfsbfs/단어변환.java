package main.java.algorithm.dfsbfs;

import java.util.*;

public class 단어변환 {

    private static String TARGET;
    private static String[] values;
    private static Set<String> used = new HashSet<>();
    private static int result = 0;

    public int solution(String begin, String target, String[] words) {
        values = words;
        TARGET = target;

        bfs(begin);

        return result;
    }

    private static void bfs(String start) {
        Queue<Map<String, Integer>> queue = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        map.put(start, 0);
        queue.add(map);
        used.add(start);

        while (!queue.isEmpty()) {
            Map<String, Integer> poll = queue.poll();

            for (Map.Entry<String, Integer> entry : poll.entrySet()) {
                String key = entry.getKey();
                Integer count = entry.getValue();

                if (key.equals(TARGET)) {
                    result = count;
                    return;
                }

                for (String value : values) {

                    int notEqualCharCount = 0;

                    for (int i = 0; i < key.length(); i++) {
                        if (key.charAt(i) != value.charAt(i)) {
                            notEqualCharCount++;
                        }
                    }

                    if (notEqualCharCount == 1) {
                        if (!used.contains(value)) {
                            used.add(value);
                            Map<String, Integer> queueMap = new HashMap<>();
                            queueMap.put(value, count + 1);
                            queue.add(queueMap);
                        }
                    }
                }
            }
        }

        result = 0;
    }
}
