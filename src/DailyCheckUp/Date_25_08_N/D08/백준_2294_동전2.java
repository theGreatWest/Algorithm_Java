package DailyCheckUp.Date_25_08_N.D08;

import java.util.*;
import java.io.*;

public class 백준_2294_동전2 {
    static int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coinValue = new int[n];
        for(int i=0; i<n; i++){
            coinValue[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coinValue);

        int[] dp = new int[k+1];
        Arrays.fill(dp, MAX);
        dp[k] = 0;

        for(int sum=k; sum>0; sum--){
            if(dp[sum] == MAX) continue;

            for(int cv=0; cv<n; cv++){
                int nextSum = sum - coinValue[cv];

                if(nextSum < 0) break;

                dp[nextSum] = Math.min(dp[nextSum], dp[sum] + 1);
            }
        }

        System.out.println((dp[0]==MAX) ? -1 : dp[0]);
    }
}
