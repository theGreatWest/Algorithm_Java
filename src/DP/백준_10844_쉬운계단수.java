package DP;

import java.io.*;

public class 백준_10844_쉬운계단수 {
    static final long DIV = 1000000000L;

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n + 1][10]; // 길이가 N 인 계단에서, H 로 끝나는 계단의 수 저장
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int num = 2; num <= n; num++) {
            int prevNum = num - 1;

            dp[num][0] = dp[prevNum][1];
            dp[num][9] = dp[prevNum][8];

            for (int i = 1; i <= 8; i++) {
                dp[num][i] = dp[prevNum][i - 1] + dp[prevNum][i + 1];
            }
        }


        long res = 0;
        for (int i = 0; i <= 9; i++) {
            res = (res+dp[n][i])%DIV;
        }
        System.out.println(res);
    }
}
