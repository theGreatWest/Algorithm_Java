package DP.연습하기;

import java.util.*;
import java.io.*;

public class 백준_24416_알고리즘수업_피보나치수1 {
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        fibo_rec(n);
        System.out.print(cnt+" ");

        System.out.println(fibo_dp(n));
    }

    static int fibo_rec(int x){
        if(x<=2) {
            cnt++;
            return 1;
        }
        return fibo_rec(x-1) + fibo_rec(x-2);
    }

    static int fibo_dp(int x){
        if(x == 1) return 1;
        if(x == 2) return 2;

        long[] dp = new long[100000];
        dp[1] = dp[2] = 1; // 이렇게 이어써 줄 수 있구나
        int cnt = 0;

        for(int i=3;i<=x;i++){
            dp[i] = dp[i-1] + dp[i-2];
            cnt++;
        }

        return cnt;
    }
}
