package DailyCheckUp.Date_25_04_N.D25;

import java.util.*;
import java.io.*;

public class SWEA_2817_부분수열의합 {
    static int N, K, res;
    static int[] nums, idxs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            nums = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            res = 0;

            for (int len = 1; len <= N; len++) {
                idxs = new int[len];
                dfs(0, 0, len);
            }

            sb.append("#").append(t).append(" ").append(res).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int idx, int position, int len) {
        if (position == len) {
//            System.out.println(Arrays.toString(idxs));
            int sum = 0;
            for(int ie : idxs){
                sum+=nums[ie];
            }
            if(sum==K) res++;
            return;
        }

        for(int i=idx; i<N;i++){
            idxs[position] = i;
            dfs(i+1, position+1, len);
        }
    }
}
