package DailyCheckUp.Date_25_02_N.D22;

import java.util.*;
import java.io.*;

public class 백준_14940_쉬운최단거리 {
    static final int[] di = {-1, 0, 0, 1};
    static final int[] dj = {0, -1, 1, 0};

    static int n, m;
    static int[][] arr;
    static int[][] res;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        res = new int[n][m];
        visited = new boolean[n][m];

        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    start = i;
                    end = j;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, end});
        visited[start][end] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int i = current[0];
            int j = current[1];

            for (int d = 0; d < 4; d++) {
                int prevI = i + di[d];
                int prevJ = j + dj[d];

                if (!isOutOfRange(prevI, prevJ) && !visited[prevI][prevJ]) {
                    if(arr[prevI][prevJ] != 0){
                        res[prevI][prevJ] = Math.max(res[prevI][prevJ], arr[prevI][prevJ] + res[i][j]);
                        q.offer(new int[]{prevI, prevJ});
                    }
                    visited[prevI][prevJ] = true;
                }
            }
        }
        rest();
        System.out.println(printResult());
    }

    static boolean isOutOfRange(int i, int j) {
        return i < 0 || j < 0 || i >= n || j >= m;
    }

    static String printResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(res[i][j]).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    static void rest(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(res[i][j]==0 && arr[i][j]==1){
                    res[i][j] = -1;
                }
            }
        }
    }
}
