package DailyCheckUp.Date_25_05_N.D04;

import java.util.*;
import java.io.*;

public class SWEA_1861_정사각형방_DFS {
    static final int[] di = {0,0,-1,1};
    static final int[] dj = {-1,1,0,0};

    static int N, num, max, curr;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N][N];
            for(int i=0;i<N;i++){
                arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            num = max = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    curr = 0;
                    dfs(i, j, 0);
                    if(curr > max) {
                        max = curr;
                        num = arr[i][j];
                    }else if(curr == max) num = Math.min(num, arr[i][j]);
                }
            }

            sb.append("#").append(t).append(" ").append(num).append(" ").append(max+1).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int i, int j, int cnt){
        boolean exist = false;

        for(int d=0;d<4;d++){
            int ni = i + di[d];
            int nj = j + dj[d];

            if(!ior(ni, nj) && arr[ni][nj]==arr[i][j]+1){
                exist = true;
                dfs(ni, nj, cnt+1);
            }
        }

        if(!exist) curr =  cnt;
    }

    static boolean ior(int i, int j){
        return i<0 || j<0 || i>=N || j>=N;
    }
}
