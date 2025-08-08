package DailyCheckUp.Date_25_08_N;

import java.util.*;
import java.io.*;

public class 백준_1749_점수따먹기_구간합 {
    static final int[] di = {1, 0};
    static final int[] dj = {0, 1};

    static int N, M;
    static int[][] arr;
    static long[][] sum;
    static long maxValue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i=0; i<N; i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        sum = new long[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                long up = (i-1 < 0) ? 0 : sum[i-1][j];
                long left = (j-1 < 0) ? 0 : sum[i][j-1];
                long diagonal = (i-1 < 0 || j-1 < 0) ? 0 : sum[i-1][j-1];

                sum[i][j] = arr[i][j] + up + left - diagonal;
            }
        }

        maxValue = Long.MIN_VALUE;
        for(int endI=0; endI<N; endI++){
            for(int endJ=0; endJ<M; endJ++){ // 오른쪽 하단

                for(int startI=0; startI<=endI; startI++){
                    for(int startJ=0; startJ<=endJ; startJ++){ // 왼쪽 상단

                        dfs(startI, startJ, endI, endJ, arr[startI][startJ]);
                        // dfs는 시간 초과
                        // 그렇다면 슬라이딩 윈도우 방법..?
                    }
                }
            }
        }

        System.out.println(maxValue);
    }

    static void dfs(int currI, int currJ, int endI, int endJ, int fixSum){
        if(currI==endI && currJ==endJ){
            maxValue = Math.max(maxValue, fixSum);
            return;
        }

        for(int d=0; d<2; d++){
            int nI = currI + di[d];
            int nJ = currJ + dj[d];

            if(nI<=endI && nJ<=endJ){
                dfs(nI, nJ, endI, endJ, fixSum + arr[nI][nJ]);
            }
        }
    }
}
