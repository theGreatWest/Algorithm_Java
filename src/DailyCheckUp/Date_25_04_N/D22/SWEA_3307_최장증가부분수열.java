package DailyCheckUp.Date_25_04_N.D22;

import java.util.*;
import java.io.*;

public class SWEA_3307_최장증가부분수열 {
    static int N;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            dp = new int[N];
            Arrays.fill(dp, 1);
            for(int i=1;i<N;i++){
                for(int j=0;j<i;j++){
                    if(arr[i] >= arr[j]) dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }

            sb.append("#").append(t).append(" ").append(Arrays.stream(dp).max().getAsInt()).append("\n");
        }

        System.out.print(sb);
    }
}
