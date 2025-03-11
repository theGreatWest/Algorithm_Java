package DailyCheckUp.Date_25_02_N.D18;

import java.util.*;
import java.io.*;

public class 백준_15652_N과M4 {
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dfs(new int[m], 0);

        System.out.print(sb);
    }

    static void dfs(int[] arr, int idx) {
        if (idx == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int startNum = (idx == 0) ? 1 : arr[idx-1];
        for (int i = startNum; i <= n; i++) {
            arr[idx] = i;
            dfs(arr, idx + 1);
        }
    }
}
