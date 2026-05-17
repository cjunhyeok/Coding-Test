package main.java.algorithm.greedy;

import java.util.PriorityQueue;

public class 디펜스게임_프로그래머스 {
    public int solution(int n, int k, int[] enemy) {
        int answer = k;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            if (i >= enemy.length) {
                break;
            }
            pq.add(enemy[i]);
        }

        if (k >= enemy.length) {
            return enemy.length;
        }

        for (int i = k; i < enemy.length; i++) {
            int value = enemy[i];
            Integer peek = pq.peek();

            if (n < 0) {
                break;
            }

            if (peek < value) {
                if (peek > n) {
                    break;
                }
                Integer poll = pq.poll();
                n = n - poll;
                pq.add(value);
                answer++;
            } else {
                if (n - value < 0) {
                    break;
                } else {
                    n = n - value;
                    answer++;
                }
            }
        }

        return answer;
    }
}
