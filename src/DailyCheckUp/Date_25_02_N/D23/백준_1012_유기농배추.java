package DailyCheckUp.Date_25_02_N.D23;

import java.io.*;
import java.util.*;

public class 백준_1012_유기농배추 {
    static final int[] di = {-1, 0, 1, 0};
    static final int[] dj = {0, -1, 0, 1};

    static int M, N, K;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N][M];
            for (int m = 0; m < K; m++) {
                st = new StringTokenizer(br.readLine());
                int j = Integer.parseInt(st.nextToken());
                int i = Integer.parseInt(st.nextToken());

                arr[i][j] = 1;
            }

            visited = new boolean[N][M];

            // DFS
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        cnt++;
                        DFS(i, j);
                    }
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }

    static void DFS(int i, int j) {
        visited[i][j] = true;

        for (int d = 0; d < 4; d++) {
            int nI = i + di[d];
            int nJ = j + dj[d];

            if(!isOutOfRange(nI, nJ) && !visited[nI][nJ] && arr[nI][nJ]==1){
                DFS(nI, nJ);
            }
        }
    }

    static boolean isOutOfRange(int i, int j) {
        return i < 0 || j < 0 || i >= N || j >= M;
    }
}
