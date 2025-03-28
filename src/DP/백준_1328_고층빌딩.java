package DP;

import java.io.*;
import java.util.*;

public class 백준_1328_고층빌딩 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        long[][][] dp = new long[N + 1][L + 1][R + 1]; // [건물 수][왼쪽에서 보이는 건물 수][오른쪽에서 보이는 건물의 수] = 경우의 수 -> 오 여기까지는 맞았다!

        dp[1][1][1] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= L; j++) {
                for (int k = 1; k <= R; k++) {
                    int prevBuildingNum = i-1;

                    // 가장 작은 빌딩을 N 번째에 위치시킨다고 가정하면, 전체 경우의 수를 아래의 세 가지 케이스로 분리할 수 있음
                    dp[i][j][k] = (
                                    dp[prevBuildingNum][j - 1][k] // 가장 작은 빌딩을 왼쪽에 놓는 경우
                                    + dp[prevBuildingNum][j][k] * (i - 2) // 가장 작은 빌딩을 중간에 놓는 경우
                                    + dp[prevBuildingNum][j][k - 1] // 가장 작은 빌딩을 오른쪽에 놓는 경우
                            ) % 1000000007;
                }
            }
        }

        System.out.println(dp[N][L][R]);
    }
}
