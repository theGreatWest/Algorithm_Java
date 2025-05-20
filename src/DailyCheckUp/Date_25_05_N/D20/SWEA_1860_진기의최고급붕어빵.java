package DailyCheckUp.Date_25_05_N.D20;

import java.util.*;
import java.io.*;

public class SWEA_1860_진기의최고급붕어빵 {
    static int N, M, K;
    static int[] arriveTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            arriveTime = new int[N];
            int maxT = 0;
            for (int i = 0; i < N; i++) {
                arriveTime[i] = Integer.parseInt(st.nextToken());
                maxT = Math.max(maxT, arriveTime[i]);
            }

            int[] time = new int[maxT+1];
            for(int v : arriveTime){
                time[v]++;
            }

            int bread = 0;
            boolean possible = true;
            for (int tt = 0; tt <= maxT; tt++) {
                if (tt>0 && tt % M == 0) {
                    bread += K;
                }

                bread -= time[tt];

                if(bread<0) {
                    possible = false;
                    break;
                }
            }

            sb.append("#").append(t).append(" ").append(possible ? "Possible" : "Impossible").append("\n");
        }

        System.out.print(sb);
    }
}
