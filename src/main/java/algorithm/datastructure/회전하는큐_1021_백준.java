package main.java.algorithm.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회전하는큐_1021_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        StringTokenizer st = new StringTokenizer(line, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        line = br.readLine();
        st = new StringTokenizer(line, " ");

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        int listIndex = 0;
        while (true) {

            if (Objects.equals(listIndex, M)) {
                break;
            }

            Integer first = deque.peekFirst();
            Integer listValue = list.get(listIndex);

            if (Objects.equals(first, listValue)) {
                deque.pollFirst();
                listIndex++;
            } else {

                int size = 1;
                boolean isLastStart = false;

                for (Integer i : deque) {

                    int dequeSize = deque.size();

                    if ((dequeSize % 2) == 0) {
                        if (size > (dequeSize / 2)) {
                            isLastStart = true;
                            break;
                        }
                    } else {
                        if (size > (dequeSize / 2) + 1) {
                            isLastStart = true;
                            break;
                        }
                    }

                    if (Objects.equals(listValue, i)) {
                        break;
                    } else {
                        size++;
                    }
                }

                if (!isLastStart) {
                    while (true) {
                        Integer poll = deque.pollFirst();

                        if (Objects.equals(poll, listValue)) {
                            listIndex++;
                            break;
                        } else {
                            deque.addLast(poll);
                            result++;
                        }

                    }
                } else {
                    while (true) {
                        Integer poll = deque.pollLast();

                        if (Objects.equals(poll, listValue)) {
                            result++;
                            listIndex++;
                            break;
                        } else {
                            deque.addFirst(poll);
                            result++;
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }
}
