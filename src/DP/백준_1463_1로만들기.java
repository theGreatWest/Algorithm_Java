package DP;

import java.util.*;
import java.io.*;

public class 백준_1463_1로만들기 {
    static int n;
    static int[] dp; // 해당 값까지의 최소 연산 횟수 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        for(int i=2;i<=n;i++){
            dp[i] = Math.min(dp[i], dp[i-1]+1);
            if(i%2==0) dp[i] = Math.min(dp[i], dp[i/2]+1);
            if(i%3==0) dp[i] = Math.min(dp[i], dp[i/3]+1); // 이전 값에 대한 횟수 + 1 = 현재까지 연산 수
        }

        System.out.println(dp[n]);
    }

// Sol 1 > 내 풀이 : BFS 를 이용한 방식
//    static int n;
//    static int[] dp; // 연산 횟수 저장
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        n = Integer.parseInt(br.readLine());
//
//        dp = new int[n+1];
//        Arrays.fill(dp, -1);
//
//        Queue<int[]> q = new LinkedList<>();
//        q.offer(new int[]{1, 0});
//        dp[1] = 0;
//        while(!q.isEmpty()){
//            int[] curr = q.poll();
//
//            if(dp[n]!=-1) break;
//
//            for(int next : new int[]{curr[0]+1, curr[0]*2, curr[0]*3}){
//                if(next <=n && dp[next]==-1){
//                    dp[next] = curr[1] + 1;
//                    q.offer(new int[]{next, curr[1]+1});
//                }
//            }
//        }
//
//        System.out.println(dp[n]);
//    }
}
