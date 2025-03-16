package DP;

import java.util.*;
import java.io.*;

public class 백준_11726_2N타일링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(n==1) System.out.println(1);
        else if(n==2) System.out.println(2);
        else{
            long[] dp = new long[n+1];
            dp[1] = 1;
            dp[2] = 2;

            for(int i=3;i<=n;i++){
                dp[i] = (dp[i-1] + dp[i-2]) % 10007;
            }

            System.out.println(dp[n]);
        }
    }
}
