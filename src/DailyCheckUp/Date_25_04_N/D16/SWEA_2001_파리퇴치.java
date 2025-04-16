package DailyCheckUp.Date_25_04_N.D16;

import java.util.*;
import java.io.*;

public class SWEA_2001_파리퇴치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = -1;
            for(int i=0; i<=N-M; i++){
                for(int j=0; j<=N-M; j++){
                    int sum = 0;
                    for(int x=i; x<i+M; x++){
                        for(int y=j; y<j+M; y++){
                            sum+=arr[x][y];
                        }
                    }
                    max = Math.max(max, sum);
                }
            }

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }
}
