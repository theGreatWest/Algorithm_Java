package 그래프.플로이드워셜;

import java.util.*;
import java.io.*;

public class 백준_11404_플로이드 {
    static final Long INF = Long.MAX_VALUE;

    static int n, m;
    static long[][] costs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        costs = new long[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j) costs[i][j] = 0;
                else costs[i][j] = INF;
            }
        }

        // 플루이드 워셜: 시작점과 도착점이 정해지지 않아서 전체 경우를 봐야할 때
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());

            costs[s][e] = Math.min(costs[s][e], cost);

            for(int k=1;k<=n;k++){
                if(costs[s][k] == INF || costs[k][e] == INF) continue;
                costs[s][e] = Math.min(costs[s][e], costs[s][k] + costs[k][e]);
            }
        }

        for(int k=1;k<=n;k++){
            for(int s=1;s<=n;s++){
                for(int e=1;e<=n;e++){
                    if(costs[s][k]==INF || costs[k][e]==INF) continue;


                    costs[s][e] = Math.min(costs[s][e], (costs[s][k] + costs[k][e]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                long value = costs[i][j];
                if(value==INF) sb.append(0);
                else sb.append(value);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
