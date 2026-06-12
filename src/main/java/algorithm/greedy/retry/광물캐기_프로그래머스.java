package main.java.algorithm.greedy.retry;

import java.util.ArrayList;
import java.util.List;

public class 광물캐기_프로그래머스 {

    private class Group {
        int diamond;
        int iron;
        int stone;
        int level;

        public Group(int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
            this.level = diamond * 25 + iron * 5 + stone;
        }
    }

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int totalPickCount = picks[0] + picks[1] + picks[2];
        int mineLimit = Math.min(minerals.length, totalPickCount * 5);

        List<Group> groups = new ArrayList<>();

        for (int i = 0; i < mineLimit; i += 5) {

            int diamond = 0;
            int iron = 0;
            int stone = 0;

            for (int j = i; j < i + 5 && j < mineLimit; j++) {
                String mineral = minerals[j];
                if (mineral.equals("diamond")) {
                    diamond++;
                } else if (mineral.equals("iron")) {
                    iron++;
                } else if (mineral.equals("stone")) {
                    stone++;
                }
            }

            groups.add(new Group(diamond, iron, stone));
        }

        groups.sort((a, b) -> {
            return b.level - a.level;
        });

        for (Group group : groups) {
            if (picks[0] > 0) {
                answer = answer + group.diamond + group.iron + group.stone;
                picks[0]--;
            } else if (picks[1] > 0) {
                answer = answer + group.diamond * 5 + group.iron + group.stone;
                picks[1]--;
            } else if (picks[2] > 0) {
                answer = answer + group.diamond * 25 + group.iron * 5 + group.stone;
                picks[2]--;
            }
        }

        return answer;
    }
}
