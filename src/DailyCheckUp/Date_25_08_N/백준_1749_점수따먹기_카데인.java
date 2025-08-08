package DailyCheckUp.Date_25_08_N;

import java.util.*;
import java.io.*;

public class 백준_1749_점수따먹기_카데인 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long result = Long.MIN_VALUE;
        for(int sCol=0; sCol<M; sCol++){ // 시작 열의 인덱스
            long[] sum = new long[N];

            for(int eCol=sCol; eCol<M; eCol++){ // 끝 열의 인덱스
                // 열이 sCol 부터 eCol-1 까지 돌며 누적되어 저장 됨
                // 각 사이클마다 카데인 알고리즘 수행
                for(int i=0; i<N; i++){
                    sum[i] += arr[i][eCol];
                }

                result = Math.max(kadane(sum), result);
            }
        }

        System.out.println(result);
    }

    // 카데인 알고리즘: 1차원 배열의 최대 부분 수열의 합 구하는 알고리즘
    static long kadane(long[] arr){
        long currSum = arr[0];
        long maxSum = arr[0];

        for(int i=1; i<arr.length; i++){
            currSum = Math.max(arr[i], currSum + arr[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}