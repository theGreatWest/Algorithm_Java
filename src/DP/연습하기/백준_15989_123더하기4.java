package DP.연습하기;

import java.io.*;
import java.util.*;

public class 백준_15989_123더하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] dp = new int[10001][4]; // J 를 마지막 숫자로 사용하여 I 를 만드는 경우의 수

//  •	dp[1][1] = 1 → 1만 사용해서 1을 만드는 방법은 1개 ({1})
//	•	dp[2][1] = 1 → 1만 사용해서 2를 만드는 방법은 {1,1}
//	•	dp[2][2] = 1 → 2를 마지막 숫자로 써서 만드는 방법은 {2}
//	•	dp[3][1] = 1 → 1만 사용해서 3을 만드는 방법은 {1,1,1}
//	•	dp[3][2] = 1 → 2를 마지막으로 써서 만드는 방법은 {1,2}
//	•	dp[3][3] = 1 → 3을 마지막으로 써서 만드는 방법은 {3}
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for(int n=4;n<=10000;n++){
            dp[n][1] = dp[n-1][1]; // 1 만 사용해서 n을 만드는 방법.
//            dp[n][1] = 1; // 1 만 사용해서 n을 만드는 방법.
            // 항상 1가지 이므로 dp[n-1][1] 값을 그대로 가져와도 된다.

            dp[n][2] = dp[n-2][1] + dp[n-2][2]; // 마지막 숫자가 2일 때, n을 만드는 방법.
//            dp[n][2] = 1 + dp[n-2][2]; // 마지막 숫자가 2일 때, n을 만드는 방법.
            // n-2까지 1과 2를 이용해서 만들기 -> +2 붙이기

            dp[n][3] = dp[n-3][1] + dp[n-3][2] + dp[n-3][3]; // 마지막 숫자가 3일 때, n을 만드는 방법.
//            dp[n][3] = 1 + dp[n-3][2] + dp[n-3][3]; // 마지막 숫자가 3일 때, n을 만드는 방법.
            // n-3 까지 1,2,3을 이용해 만들기 -> +3 붙이기
        }

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            sb.append( dp[n][1] + dp[n][2] + dp[n][3] ).append("\n");
        }

        System.out.print(sb);
    }
}
