package DailyCheckUp.Date_25_03_N.D17;

import java.util.*;
import java.io.*;

public class 백준_11727_2N타일링2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n==1) System.out.println(1);
        else if(n==2) System.out.println(3);
        else{
            long[] dp = new long[n+1];
            dp[1] = 1;
            dp[2] = 3;
            for(int i=3;i<=n;i++){
                long prev = dp[i-2] * 4;

                dp[i] = (i%2==0) ? (prev - 1) : (prev + 1);

                dp[i] %= 10007;
            }
            System.out.println(dp[n]);
        }
    }
}
