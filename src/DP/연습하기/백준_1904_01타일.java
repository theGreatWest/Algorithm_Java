package DP.연습하기;

import java.io.*;

public class 백준_1904_01타일 {
    static final int MOD = 15746;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n==1) System.out.println(1);
        else if(n==2) System.out.println(2);
        else{
            long[][] dp = new long[n+1][2];
            dp[1][0] = 0;
            dp[1][1] = 1;
            dp[2][0] = 1;
            dp[2][1] = 1;
            for(int i=3;i<=n;i++){
                int m2 = i - 2;
                int m1 = i - 1;

                dp[i][0] = (dp[m2][0] + dp[m2][1])%MOD;
                dp[i][1] = (dp[m1][0] + dp[m1][1])%MOD;
            }

            System.out.println(dp[n][0] + dp[n][1]);
        }
    }
}
