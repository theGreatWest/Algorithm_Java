package DailyCheckUp.Date_25_03_N.D02;

import java.util.*;
import java.io.*;

public class 백준_4963_섬의개수 {
    static final int[] di = {0,0,1,1,1,-1,-1,-1,-1,1};
    static final int[] dj = {-1, 1,-1,0,1,-1,0,1,0,0};

    static int h, w;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w==0 && h==0) break;

            arr = new int[h][w];
            for(int i=0;i<h;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<w;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visited = new boolean[h][w];
            int res = 0;
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(arr[i][j]==1 && !visited[i][j]){
                        res++;
                        dfs(i, j);
                    }
                }
            }

            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int i, int j){
        visited[i][j] = true;

        for(int d=0;d<8;d++){
            int nI = i + di[d];
            int nJ = j + dj[d];

            if(!isOutOfRange(nI, nJ) && arr[i][j]==1 && !visited[nI][nJ] ){
                dfs(nI, nJ);
            }
        }
    }

    static boolean isOutOfRange(int i, int j){
        return i<0 || j<0 || i>=h || j>=w;
    }
}
