package DailyCheckUp.Date_25_05_N.D12;

import java.util.*;
import java.io.*;

public class SWEA_4128_모의SW역량테스트_요리사 {
    static int N, min, cnt;
    static int[][] S;
    static int[] set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            S = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    S[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            min = Integer.MAX_VALUE;
            set = new int[N / 2];
            dfs(0, 0);

            sb.append("#").append(t).append(" ").append(min).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int idx, int position) {
        if (position >= N / 2) {
            boolean[] selected = new boolean[N];
            for(int i : set){
                selected[i] = true;
            }

            int[] set2 = new int[N/2];
            int ii = 0;
            for(int i=0;i<N;i++){
                if(!selected[i]) set2[ii++] = i;
            }

            min = Math.min(min, Math.abs(favor(set) - favor(set2)));

            return;
        }

        for (int i = idx; i < N; i++) {
            set[position] = i;
            dfs(i + 1, position + 1);
        }
    }

    static int favor(int[] set) {
        int v = 0;

        for (int i = 0; i < set.length; i++) {
            for (int j = i + 1; j < set.length; j++) {
                v += S[set[i]][set[j]];
                v += S[set[j]][set[i]];
            }
        }

        return v;
    }
}
