package DP;

import java.io.*;
import java.util.*;

public class 백준_2193_이친수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

//  Sol 1 > 내 풀이. 규칙을 찾아내 점화식 세운 풀이
//
//        if(n<3){
//            System.out.println(1);
//        }else{
//            long [] answer = new long[n]; // 정수형 범위를 초과하는 것에 주의한다.
//            answer[0] = 1;
//            answer[1] = 1;
//
//            for( int i =2; i<n; i++){
//                answer[i] = answer[i-1]+answer[i-2];
//            }
//
//            System.out.println(answer[n-1]);
//        }

//  앞의 값을 더하는 방식
        long[][] dp = new long[n+1][2];
        // dp[i][0] : i 길이에서 끝이 0으로 끝나는 수
        // dp[i][1] : i 길이에서 끝이 1로 끝나는 수

        // 0은 그 전에 1이든 0이든 모두 붙일 수 있음. dp[n][0] = dp[n-1][0] + dp[n-1][1]
        // 1은 그 전이 0일 때만 붙일 수 있음. dp[n][1] = dp[n-1][0]

        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i=2;i<=n;i++){
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        System.out.println(dp[n][0] + dp[n][1]);
    }
}
