package DailyCheckUp.Date_25_05_N.D20;

import java.util.*;
import java.io.*;

public class SWEA_7733_치즈도둑 {
    static final int[] di = {-1, 1, 0, 0};
    static final int[] dj = {0, 0, -1, 1};

    static int N;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N][N];
            int maxV = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    maxV = Math.max(arr[i][j], maxV);
                }
            }

            int max = 1;
            for (int day = 1; day <= maxV; day++) {
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                        if(arr[i][j]==day) arr[i][j] = -1;
                    }
                }

                int tmp = 0;
                visited = new boolean[N][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if(arr[i][j]!=-1 && !visited[i][j]) {
                            dfs(i, j);
                            tmp++;
                        }
                    }
                }

                max = Math.max(max, tmp);
            }

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int i, int j) {
        visited[i][j] = true;

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if(isValidPos(ni, nj) && arr[ni][nj]!=-1 && !visited[ni][nj]){
                dfs(ni, nj);
            }
        }
    }

    static boolean isValidPos(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < N;
    }
}
