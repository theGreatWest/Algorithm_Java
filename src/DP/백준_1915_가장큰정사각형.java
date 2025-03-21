package DP;

import java.io.*;
import java.util.*;

public class 백준_1915_가장큰정사각형 {
    static int n, m;
    static long max = -1;
    static int[][] arr;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            int[] tmp = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = tmp[j-1];
            }
        }

//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }

        dp = new long[n + 1][m + 1]; // 오른쪽 아래 꼭지점으로 정하고, 그릴 수 있는 정사각형의 길이를 저장하자.
//        dp[1][1] = 1;
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                int mI = i - 1, mJ = j - 1;
//                dp[i][j] = (dp[mI][j] == dp[i][mJ]) ? dp[mI][mJ] + 1 : Math.max(dp[mI][j], dp[i][mJ]);
//            }
//        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
//                System.out.println(i+", "+j);
                int mI = i - 1, mJ = j - 1;
                if (arr[i][j] == 1) dp[i][j] = Math.min(dp[mI][mJ], Math.min(dp[mI][j], dp[i][mJ])) + 1;
                if (dp[i][j] > max) max = dp[i][j];
            }
        }

        System.out.println(max * max);
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                for(int len=1; len<=dp[i][j]; len++){
//                    if(isSq(i-1, j-1, len)) max = Math.max(max, (int)Math.pow(len, 2));
//                }
//            }
//        }
//
//        System.out.println(max);
    }

//    static boolean isSq(int endI, int endJ, int len) {
//        int nL = len - 1;
//        int startI = endI - nL, startJ = endJ - nL;
//
//        for (int i = startI; i <= endI; i++) {
//            for (int j = startJ; j <= endJ; j++) {
//                if (arr[i][j] == 0) return false;
//            }
//        }
//
//        return true;
//    }
}
