package DailyCheckUp.Date_25_04_N.D07;

import java.io.*;
import java.util.*;

public class SWEA_4615_재미있는오셀로게임 {
    static final int[] di = {-1, -1, -1, 0, 0, 1, 1, 1};
    static final int[] dj = {-1, 0, 1, -1, 1, -1, 0, 1};

    static int n, m; // 보드 한 변의 길이, 플레이어가 돌을 놓는 횟수
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int div2 = n / 2, div2minus1 = div2 - 1;
            arr = new int[n][n];
            arr[div2][div2] = 2;
            arr[div2minus1][div2minus1] = 2;
            arr[div2][div2minus1] = 1;
            arr[div2minus1][div2] = 1;

            m = Integer.parseInt(st.nextToken());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
//                System.out.println(st.toString());
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                int color = Integer.parseInt(st.nextToken()); // 1: 흑돌, 2: 백돌

                arr[x][y] = color;

                change(x, y, color);
            }

            int white = 0, black = 0;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (arr[x][y] == 2) white++;
                    else if (arr[x][y] == 1) black++;
                }
            }
            sb.append("#").append(t).append(" ").append(black).append(" ").append(white).append("\n");
        }

        System.out.print(sb);
    }

    static void change(int x, int y, int color) {
            for (int d = 0; d < 8; d++) {
                int nextI = x + di[d];
                int nextJ = y + dj[d];

                List<int[]> changeList = new ArrayList<>();
                while (!oor(nextI, nextJ) && arr[nextI][nextJ] != 0) {
                    if (arr[nextI][nextJ] == color) {
                        for (int[] idx : changeList) {
                            arr[idx[0]][idx[1]] = color;
                        }
                        break;
                    }
                    changeList.add(new int[]{nextI, nextJ});
                    nextI += di[d];
                    nextJ += dj[d];
                }
            }
    }

    static boolean oor(int i, int j) {
        return i < 0 || j < 0 || i >= n || j >= n;
    }
}
