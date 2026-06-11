package main.java.algorithm.sort.retry;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 호텔대실_프로그래머스 {
    public int solution(String[][] book_time) {
        int answer = 0;

        int[][] times = new int[book_time.length][book_time[0].length];

        for (int i = 0; i < book_time.length; i++) {
            times[i][0] = toMinutes(book_time[i][0]);
            times[i][1] = toMinutes(book_time[i][1]) + 10;
        }

        Arrays.sort(times, (a, b) -> {
            return a[0] - b[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] time : times) {
            int start = time[0];
            int end = time[1];

            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }

            pq.add(end);
            answer = Math.max(answer, pq.size());
        }

        return answer;
    }

    private int toMinutes(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int minutes = Integer.parseInt(split[1]);

        return (hour * 60) + minutes;
    }
}
