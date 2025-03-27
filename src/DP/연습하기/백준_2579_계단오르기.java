package DP.연습하기;

import java.io.*;
import java.util.*;

public class 백준_2579_계단오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] stairs = new int[n];
        for (int i = 0; i < n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

// [1차원 배열]
        if (n == 1) {
            System.out.println(stairs[0]);
            return;
        }

        long[] dp1 = new long[n + 1];
        dp1[1] = stairs[0];
        dp1[2] = stairs[0] + stairs[1];

        for (int i = 3; i <= n; i++) {
            dp1[i] = Math.max(dp1[i - 2], dp1[i - 3] + stairs[i - 2]) + stairs[i - 1];
        }

        System.out.println(dp1[n]);


// [2차원 배열] sq가 1일 때와 2일 때 값 하나씩만 필요하기 때문에, dp 를 2차원 배열로 선언해보자
        long[][] dp = new long[n][3]; // dp[i][1] : 연속 값이 1일 때, dp[i][2]: 연속 값이 2일 때
        dp[n - 1][1] = stairs[n - 1];
        dp[n - 1][2] = stairs[n - 1];

        for (int i = n - 1; i >= 0; i--) {
            int prev1 = i - 1;
            if (prev1 >= 0) {
                dp[prev1][1] = Math.max(dp[i][2], dp[prev1][1]);
                dp[prev1][2] = Math.max(dp[i][1] + stairs[prev1], dp[prev1][2]);
            }

            int prev2 = i - 2;
            if (prev2 >= 0) dp[prev2][1] = Math.max(dp[i][2] + stairs[prev2], dp[prev2][1]);
        }

        System.out.println(Math.max(dp[0][1], dp[0][2]));
    }
}
