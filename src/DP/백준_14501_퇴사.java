package DP;

import java.io.*;
import java.util.*;

public class 백준_14501_퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] t = new int[n+1], p = new int[n+1];
        for(int date=1;date<=n;date++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[date] = Integer.parseInt(st.nextToken());
            p[date] = Integer.parseInt(st.nextToken());
        }

        // 풀이는 마지막 날부터 시작하고 있다.
        // 퇴사일까지 끝나지 않는 경우 : D[i] = D[i+1]
        // 퇴사일 안에 끝나는 경우 : Math.max(D[i+1], D[i + T[i]] + P[i])

        int[] dp = new int[n+2]; // 원래 범위보다 +1

        for(int i=n;i>0;i--){
            int finishDate = i + t[i];
            int next = dp[i+1];

            if(finishDate > n + 1) dp[i] = next;
            else dp[i] = Math.max(next, dp[finishDate] + p[i]);
        }

        System.out.println(dp[1]);
    }
}
