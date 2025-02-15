package DailyCheckUp.Date_25_02_15;

import java.util.*;
import java.io.*;

public class 백준_1018_체스판다시칠하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        // B: black 1, W: white -1
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (String s : br.readLine().split("")) {
                arr[i][j++] = (s.equals("B")) ? 1 : -1;
            }
        }

        int min = Integer.MAX_VALUE;
        int[] dx = {0, -1};
        int[] dy = {-1, 0};

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                int[][] tmp = new int[n][m];
                for(int start : new int[]{1, -1}){
                    tmp[i][j] = start;
                    int cnt = (tmp[i][j] == arr[i][j])?0 : 1;

                    // 8 x 8 격자판 탐색 시작
                    for (int x = i; x < i + 8; x++) {
                        for (int y = j; y < j + 8; y++) {
                            if(x==i && y==j) continue;

                            // 먼저 값 넣어주기
                            tmp[x][y] = arr[x][y];

                            // 좌, 상과 값 비교
                            for(int d=0;d<2;d++){
                                int tmpX = x + dx[d], tmpY = y + dy[d];
                                if (!isOutOfRange(n, m, tmpX, tmpY) && (tmp[x][y]== tmp[tmpX][tmpY])) {
                                    tmp[x][y] *= -1;
                                    cnt++;
                                    break;
                                }
                            }
                        }
                    }
                    min = Math.min(cnt, min);
                }
            }
        }
        System.out.println(min);
    }

    static boolean isOutOfRange(int n, int m, int i, int j) {
        return i < 0 || j < 0 || i >= n || j >= m;
    }
}
