package DailyCheckUp.Date_25_05_N.D01;

import java.util.*;
import java.io.*;

public class SWEA_1952_모의SW역량테스트_수영장_dp {
    static int[] fee;
    static int[] plan;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            fee = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            plan = new int[13]; // 해당 달에 수영장을 이용할 날의 수
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[13];

            // 1일권 & 1개월권
            for (int i = 1; i <= 12; i++) {
                boolean isUse = plan[i] > 0;

                if(isUse) {
                    int day = fee[0] * plan[i];
                    int month = fee[1];
                    dp[i] = dp[i-1] + Math.min(day, month);

                    if(i>=3) dp[i] = Math.min(dp[i], dp[i-3] + fee[2]);
                }else dp[i] = dp[i-1];
            }

            sb.append("#").append(t).append(" ").append(Math.min(fee[3], dp[12])).append("\n");
        }

        System.out.print(sb);
    }
}
