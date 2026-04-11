package main.java.algorithm.datastructure.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 창고다각형_2304_백준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int maxHeight = -1;
        int firstMaxHeightIndex = -1;

        List<Integer[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            list.add(new Integer[]{l, h});
        }

        list.sort(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < list.size(); i++) {
            Integer[] value = list.get(i);
            Integer l = value[0];
            Integer h = value[1];

            if (h > maxHeight) {
                maxHeight = h;
                firstMaxHeightIndex = i;
            }
        }

        // left
        int leftX = list.get(0)[0];
        int leftMaxHeight = list.get(0)[1];
        int leftArea = 0;
        for (int i = 1; i < firstMaxHeightIndex; i++) {
            Integer[] value = list.get(i);
            Integer l = value[0];
            Integer h = value[1];

            if (h > leftMaxHeight) {

                leftArea = leftArea + (l - leftX) * leftMaxHeight;

                leftX = l;
                leftMaxHeight = h;
            }
        }
        leftArea = leftArea + (list.get(firstMaxHeightIndex)[0] - leftX) * leftMaxHeight;

        // right
        int rightX = list.get(list.size() - 1)[0];
        int rightMaxHeight = list.get(list.size() - 1)[1];
        int rightArea = 0;
        for (int i = list.size() - 1; i > firstMaxHeightIndex; i--) {
            Integer[] value = list.get(i);
            Integer l = value[0];
            Integer h = value[1];

            if (h >= rightMaxHeight) {
                rightArea = rightArea + (rightX - l) * rightMaxHeight;
                rightX = l;
                rightMaxHeight = h;
            }
        }
        rightArea = rightArea + (rightX - list.get(firstMaxHeightIndex)[0]) * rightMaxHeight;

        int result = leftArea + rightArea + list.get(firstMaxHeightIndex)[1];

        System.out.println(result);
    }
}
