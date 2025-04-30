package DailyCheckUp.Date_25_04_N.D30;

import java.util.*;
import java.io.*;

public class SWEA_1952_모의SW역량테스트_수영장 {
    static int[] fee;
    static int[] plan;
    static long minFee;

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

            minFee = Long.MAX_VALUE;
            dfs(1, 0);

            sb.append("#").append(t).append(" ").append(Math.min(minFee, fee[3])).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int month, int totalFee) {
        if (totalFee >= minFee) return;

        if (month > 12) {
            minFee = Math.min(minFee, totalFee);
            return;
        }

        int nextMonth = month + 1;
        boolean isNextAvailable = nextMonth <= 12 && plan[nextMonth] != 0;

        int nextNextMonth = nextMonth + 1;
        boolean isNextNextAvailable = nextNextMonth <= 12 && plan[nextNextMonth] != 0;

        if (plan[month] != 0) {
            dfs(nextMonth, totalFee + (fee[0] * plan[month])); // 1일권 선택
            dfs(nextMonth, totalFee + fee[1]); // 1개월권 선택

            if (isNextAvailable && isNextNextAvailable)
                dfs(nextNextMonth + 1, totalFee + fee[2]); // 앞으로 3개월동안 연속해서 이용한다면, 3개월권도 선택 가능
        } else {
            dfs(nextMonth, totalFee); // 1일권, 1개월권, 3개월권 선택 X

            if (isNextNextAvailable)
                dfs(nextNextMonth + 1, totalFee + fee[2]); // 해당 달에 값이 없지만, 이후 이틀 후 수영장을 이용한다면 선택
        }
    }
}
