package main.java.algorithm.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 호텔대실_프로그래머스 {

    public int solution(String[][] book_time) {
        int[][] times = new int[book_time.length][2];

        for (int i = 0; i < book_time.length; i++) {
            times[i][0] = toMinute(book_time[i][0]);
            times[i][1] = toMinute(book_time[i][1]) + 10;
        }

        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;

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

    private int toMinute(String time) {
        String[] split = time.split(":");

        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);

        return hour * 60 + minute;
    }
}
