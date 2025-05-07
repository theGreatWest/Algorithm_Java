package DailyCheckUp.Date_25_05_N.D07;

import java.util.*;
import java.io.*;

public class 백준_14501_퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] info = new int[N + 1][2]; // 기간, 금액
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 2];
        for (int i = N; i > 0; i--) {
            int period = info[i][0];
            int money = info[i][1];

            int prev = i + period;
            if(prev-1 > N) dp[i] = dp[i+1]; // 이전 결과값이 존재하지 않는 경우: 상담일이 N을 벗어나는 경우
            else dp[i] = Math.max(dp[i+1], dp[prev] + money); // 이전 결과값이 존재하는 경우
        }

        System.out.println(dp[1]);
    }
}
