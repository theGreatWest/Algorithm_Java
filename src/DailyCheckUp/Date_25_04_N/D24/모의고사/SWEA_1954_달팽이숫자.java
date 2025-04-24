package DailyCheckUp.Date_25_04_N.D24.모의고사;

import java.util.*;
import java.io.*;

public class SWEA_1954_달팽이숫자 {
    static final int[] di = {0, 1, 0, -1};
    static final int[] dj = {1, 0, -1, 0};

    static int n, x, y, currD, cnt, endCnt;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            x = 0;
            y = 0;
            currD = 0;
            cnt = 1;
            endCnt = 0;

            arr[x][y] = cnt++;
            while (endCnt < 4) {
                int ni = x + di[currD];
                int nj = y + dj[currD];

                if (oor(ni, nj) || arr[ni][nj] != 0) {
                    currD = (currD + 1) % 4;
                    endCnt++;
                } else {
                    x = ni;
                    y = nj;
                    arr[x][y] = cnt++;
                    endCnt = 0;
                }
            }

            sb.append("#").append(t).append(" ").append(print());
        }

        System.out.print(sb);
    }

    static boolean oor(int i, int j) {
        return i < 0 || i >= n || j < 0 || j >= n;
    }

    static String print(){
        StringBuilder res = new StringBuilder();

        res.append("\n");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                res.append(arr[i][j]).append(" ");
            }
            res.append("\n");
        }

        return res.toString();
    }
}
