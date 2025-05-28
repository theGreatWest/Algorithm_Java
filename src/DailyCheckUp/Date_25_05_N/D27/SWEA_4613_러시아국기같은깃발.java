package DailyCheckUp.Date_25_05_N.D27;

import java.util.*;
import java.io.*;

public class SWEA_4613_러시아국기같은깃발 {
    static int N, M, min;
    static char[][] arr;
    static int[] startIdx;

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

            min = Integer.MAX_VALUE;
            startIdx = new int[3];
            dfs(1, 1);

            sb.append("#").append(t).append(" ").append(min).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int idx, int startValue) {
        if (idx == 3) {
            int tmp = 0;
            for (int i = 0; i < 3; i++) {
                int start = startIdx[i];
                int end = (i == 2) ? N : startIdx[i + 1];

                char key = 'R';
                if(i==0) key = 'W';
                else if(i==1) key = 'B';

                tmp += count(start, end, key);
            }
            min = Math.min(min, tmp);
            return;
        }

        int endValue = (idx == 1) ? N - 1 : N;
        for (int n = startValue; n < endValue; n++) {
            startIdx[idx] = n;
            dfs(idx + 1, n + 1);
        }
    }

    static int count(int start, int end, char key){
        int changedNum = 0;
        for(int i=start;i<end;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]!=key) changedNum++;
            }
        }
        return changedNum;
    }
}
