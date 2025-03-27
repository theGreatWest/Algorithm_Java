package DailyCheckUp.Date_25_03_N.D27;

import java.io.*;
import java.util.*;

public class 백준_14503_로봇청소기 {
    static final int[] I = {-1, 0, 1, 0}; // 오른쪽, 위, 왼쪽, 아래
    static final int[] J = {0, 1, 0, -1};

    static int n, m, x, y, d, cnt;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {

            if (arr[x][y] == 0) {
                arr[x][y] = 2;
                cnt++;
            }

            boolean available = false;
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4; // 우선 반시계 방향으로 돌리기

                int nextI = x + I[d];
                int nextJ = y + J[d];

                if (!oor(nextI, nextJ) && arr[nextI][nextJ] == 0) {
                    available = true;

                    x = nextI;
                    y = nextJ;

                    break;
                }

            }

            if (!available) {
                int backI = x - I[d];
                int backJ = y - J[d];

                if (oor(backI, backJ) || arr[backI][backJ] == 1) break;

                x = backI;
                y = backJ;

            }

        }
        System.out.println(cnt);
    }

    static boolean oor(int i, int j) {
        return i < 0 || j < 0 || i >= n || j >= m;
    }
}
