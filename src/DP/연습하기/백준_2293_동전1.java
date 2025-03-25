package DP.연습하기;

import java.util.*;
import java.io.*;

public class 백준_2293_동전1 {
    static int n, k;
    static Integer[] coins;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coins = new Integer[n];
        for (int c = 0; c < n; c++) {
            coins[c] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins);

        // 5 -> dp[i-5] + 1;
        long[] dp = new long[k+1]; // i 원을 만드는 방법의 수 저장
        dp[0] = 1; // 0 원 만드는 방법 1가지 - 아무것도 사용하지 않을 때
//        System.out.println("초기값: "+ Arrays.toString(dp));

        for(int coin : coins){ // 작은 동전부터 탐색 -> 중복 타운트 없이 DP 배열 갱신
//            System.out.println("coin = " + coin);
            for(int j=coin; j<=k; j++){ // 현재 동전을 사용했을 때, 가짓수가 1씩 증가할 수 있는 케이스의 가짓수 더해주기
//                System.out.println("+next = dp_" + (j-coin));
                dp[j] += dp[j - coin];
            }
//            System.out.println(Arrays.toString(dp));
        }

        System.out.println(dp[k]);

    }
}
