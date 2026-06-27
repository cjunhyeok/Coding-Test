package main.java.algorithm.greedy.retry;

import java.util.ArrayList;
import java.util.List;

public class 광물캐기_프로그래머스 {

    private static class Group {
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

        int pickCount = picks[0] * 5 + picks[1] * 5 + picks[2] * 5;
        int totalCount = Math.min(pickCount, minerals.length);

        List<Group> groups = new ArrayList<>();

        for (int i = 0; i < totalCount; i = i + 5) {
            int diamond = 0;
            int iron = 0;
            int stone = 0;

            for (int j = i; j < i + 5 && j < totalCount; j++) {
                String mineral = minerals[j];
                if (mineral.equals("diamond")) {
                    diamond++;
                } else if (mineral.equals("iron")) {
                    iron++;
                } else {
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
            } else {
                answer = answer + group.diamond * 25 + group.iron * 5 + group.stone;
                picks[2]--;
            }
        }

        return answer;
    }
}
