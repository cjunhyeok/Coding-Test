package main.java.algorithm.greedy;

public class 조이스틱_프로그래머스 {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();

        int move = n - 1; // 오른쪽으로만 쭉 가는 기본 이동

        for (int i = 0; i < n; i++) {
            char c = name.charAt(i);

            // 위/아래 조작 횟수
            answer += Math.min(c - 'A', 'Z' - c + 1);

            // i 다음부터 연속된 A 구간 찾기
            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }

            // 오른쪽으로 갔다가 다시 왼쪽으로 돌아가는 경우
            move = Math.min(move, i * 2 + (n - next));

            // 왼쪽으로 먼저 갔다가 오른쪽으로 돌아오는 경우
            move = Math.min(move, (n - next) * 2 + i);
        }

        return answer + move;
    }
}
