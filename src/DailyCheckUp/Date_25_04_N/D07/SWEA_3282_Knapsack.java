package DailyCheckUp.Date_25_04_N.D07;

import java.io.*;
import java.util.*;

public class SWEA_3282_Knapsack {
    static int T, N, K;
    static int maxValue = -1;
    static int[] volumes, values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            volumes = new int[N + 1];
            values = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                volumes[i] = Integer.parseInt(st.nextToken());
                values[i] = Integer.parseInt(st.nextToken());
            }

//            dfs(0, 0, 0); // 시간 초과 : 2^n이 되기 때문에

//            long[] dp = new long[K+1];
//            for(int n=1;n<=N;n++){
//                for(int v = K; v >=volumes[n]; v--){ // dp를 뒤에서 부터 돌아야 딱 한 번만 고려할 수 있다.
//                    // dp[v - volumes[n]] : 지금 물건(n)을 넣기 전 상태를 의미한다.
//                    dp[v] = Math.max(dp[v], dp[v - volumes[n]] + values[n]);
//                }
//                System.out.printf("[ n = %d ] [ volume = %d ] [ value = %d ] ", n, volumes[n], values[n]);
//                System.out.println(Arrays.toString(dp));
//            }

            long[][] dp = new long[N + 1][K + 1];
            for (int n = 1; n <= N; n++) {
                for (int k = 0; k <= K; k++) {
                    int prevNum = n - 1;
                    if (k < volumes[n]) { // 전체 부피가 해당 제품의 부피보다 작아서 담지 못 하는 경우
                        dp[n][k] = dp[prevNum][k]; // 현재 물건 n 을 넣지 않았을 때
                    } else {
                        // 현재 물건 n 을 넣었을 때
                        dp[n][k] = Math.max(dp[prevNum][k], dp[prevNum][k - volumes[n]] + values[n]);
                    }
                }
            }

            long max = 0;
            for (int k = 0; k <= K; k++) {
                if (dp[N][k] > max) max = dp[N][k];
            }

            sb.append("#").append(t).append(" ").append(max).append("\n");

//            maxValue = -1;
        }

        System.out.print(sb);
    }

    static void dfs(int productNum, int totVolume, int totValue) {
        if (totVolume == K) {
            maxValue = Math.max(maxValue, totValue);
            return;
        }

        int nextProductNum = productNum + 1;
        if (nextProductNum > N) return;

        dfs(nextProductNum, totVolume, totValue); // 해당 상품을 구매하지 않고, 다음 상품을 살펴보려고 할 때

        int nextVolume = totVolume + volumes[nextProductNum];
        if (nextVolume > K) return;
        dfs(nextProductNum, nextVolume, totValue + values[nextProductNum]); // 해당 상품을 구매할 때
    }
}
