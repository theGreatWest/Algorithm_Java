package DailyCheckUp.Date_25_07_N.D10;

import java.util.*;
import java.io.*;

public class 백준_17271_리그오브레전설Small {
    static final long MOD = 1000000007;

    static int n, a = 1, b;
    static long res = 0L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 싸움 시간
        b = Integer.parseInt(st.nextToken()); // B 스킬 시전 시간

//        dfs(0);
//        System.out.println(res);

//        System.out.println(bfs());

        System.out.println(dp());
    }

    static long dp() {
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int prevA = i - a;
            if (prevA >= 0) dp[i] = (dp[i] + dp[prevA]) % MOD;

            int prevB = i - b;
            if (prevB >= 0) dp[i] = (dp[i] + dp[prevB]) % MOD;
        }

        return dp[n];
    }

    static long bfs() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long res = 0L;

        pq.offer(a);
        pq.offer(b);
        while (!pq.isEmpty()) {
            int curr = pq.poll();

            if (curr == n) {
                res = (res + 1) % MOD;
                continue;
            }

            int nextA = curr + a;
            if (nextA <= n) pq.offer(nextA);

            int nextB = curr + b;
            if (nextB <= n) pq.offer(nextB);
        }

        return res;
    }

    static void dfs(int currentTime) {
        int nextA = currentTime + a;
        if (nextA == n) res = (res + 1) % MOD;
        else if (nextA < n) dfs(currentTime + a); // A 선택할 때

        int nextB = currentTime + b;
        if (nextB == n) res = (res + 1) % MOD;
        if (nextB < n) dfs(currentTime + b); // B 선택할 때
    }
}
