package DailyCheckUp.Date_25_04_N.D07;

import java.io.*;
import java.util.*;

public class SWEA_2814_최장경로 {
    static int n, m, maxLength=1;
    static List<Integer>[] info;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            info = new ArrayList[n+1];
            for(int i=1;i<=n;i++){
                info[i] = new ArrayList<>();
            }

            for(int i=0;i<m;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                info[a].add(b);
                info[b].add(a);
            }

            for(int i=1;i<=n;i++){
                visited = new boolean[n+1];
                visited[i] = true;
                dfs(i, 1);
            }

            sb.append("#").append(t).append(" ").append(maxLength).append("\n");

            maxLength = 1;
        }

        System.out.print(sb);
    }

    static void dfs(int curr, int cnt){
        maxLength = Math.max(maxLength, cnt);

        for(int next : info[curr]){
            if(!visited[next]){
                visited[next] = true;
                dfs(next, cnt+1);
                visited[next] = false;
            }
        }
    }
}
