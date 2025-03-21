package DailyCheckUp.Date_25_03_N.D21;

import java.io.*;
import java.util.*;

public class 백준_2630_색종이만들기 {
    static int n, white, blue;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            paper[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        recall(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    static void recall(int x, int y, int size) {
        if (isOneColor(x, y, size)) return;

        int halfSize = size / 2;
        int nextX = x + halfSize, nextY = y + halfSize;

        recall(x, y, halfSize);
        recall(x, nextY, halfSize);
        recall(nextX, y, halfSize);
        recall(nextX, nextY, halfSize);
    }

    // 모든 요소가 하나의 색을 나타내면 true 반환, 아니라면 false 반환
    static boolean isOneColor(int x, int y, int size) {
        int color = paper[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != color) return false;
            }
        }

        if (color == 0) white++;
        else blue++;

        return true;
    }
}
