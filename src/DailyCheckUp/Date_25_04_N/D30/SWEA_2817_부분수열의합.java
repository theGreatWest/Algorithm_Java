package DailyCheckUp.Date_25_04_N.D30;

import java.util.*;
import java.io.*;

public class SWEA_2817_부분수열의합 {
    static int N, K, cnt;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            cnt = 0;
            dfs(0, 0);

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int i, int sum) {
        if (sum == K) {
            cnt++;
            return;
        }
        if (sum > K || i == N) return;

        int nextIdx = i + 1;

        // 해당 인덱스의 값 선택하지 않았을 때
        dfs(nextIdx, sum);

        // 해당 인덱스의 값 선택했을 때
        dfs(nextIdx, sum + A[i]);
    }
}
