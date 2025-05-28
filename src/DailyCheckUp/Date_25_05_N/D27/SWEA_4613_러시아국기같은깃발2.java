package DailyCheckUp.Date_25_05_N.D27;

import java.io.*;
import java.util.*;

public class SWEA_4613_러시아국기같은깃발2 {
    static int N, M;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new char[N][M];
            for (int i = 0; i < N; i++) {
                arr[i] = br.readLine().toCharArray();
            }

            int min = Integer.MAX_VALUE;
            for (int bStart = 1; bStart < N - 1; bStart++) {
                for (int rStart = bStart + 1; rStart < N; rStart++) {
                    min = Math.min(min, count(0, bStart, rStart));
                }
            }

            sb.append("#").append(t).append(" ").append(min).append("\n");
        }

        System.out.print(sb);
    }

    static int count(int ws, int bs, int rs){
        int changedNum = 0;

        // 흰색으로 바꾸기
        for(int i=ws; i<bs;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]!='W') changedNum++;
            }
        }
        // 파란색으로 바꾸기
        for(int i=bs; i<rs;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]!='B') changedNum++;
            }
        }
        // 빨간색으로 바꾸기
        for(int i=rs; i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]!='R') changedNum++;
            }
        }

        return changedNum;
    }
}
