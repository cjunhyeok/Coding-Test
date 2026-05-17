package main.java.algorithm.greedy;

import java.util.ArrayList;
import java.util.List;

public class 광물캐기_프로그래머스 {
    static class Group {
        int diamond;
        int iron;
        int stone;
        int difficulty;

        Group(int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
            this.difficulty = diamond * 25 + iron * 5 + stone;
        }
    }

    public int solution(int[] picks, String[] minerals) {
        int totalPickCount = picks[0] + picks[1] + picks[2];
        int mineLimit = Math.min(minerals.length, totalPickCount * 5);

        List<Group> groups = new ArrayList<>();

        for (int i = 0; i < mineLimit; i += 5) {
            int diamond = 0;
            int iron = 0;
            int stone = 0;

            for (int j = i; j < i + 5 && j < mineLimit; j++) {
                if (minerals[j].equals("diamond")) {
                    diamond++;
                } else if (minerals[j].equals("iron")) {
                    iron++;
                } else {
                    stone++;
                }
            }

            groups.add(new Group(diamond, iron, stone));
        }

        groups.sort((a, b) -> b.difficulty - a.difficulty);

        int answer = 0;

        for (Group group : groups) {
            if (picks[0] > 0) {
                answer += group.diamond + group.iron + group.stone;
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += group.diamond * 5 + group.iron + group.stone;
                picks[1]--;
            } else {
                answer += group.diamond * 25 + group.iron * 5 + group.stone;
                picks[2]--;
            }
        }

        return answer;
    }
}
