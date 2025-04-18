package DailyCheckUp.Date_25_04_N.D18;

import java.util.*;
import java.io.*;

// 전형적인 순열을 이용한 완전 탐색 문제

public class SWEA_1247_SW문제해결응용_3일차_최적경로 {
    static int N, min;
    static int[] company = new int[2], home = new int[2], tmp;
//    static Map<Integer, int[]> map;
    static boolean[] visited;
    static int[][] customers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            company[0] = Integer.parseInt(st.nextToken());
            company[1] = Integer.parseInt(st.nextToken());
            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());
//            map = new HashMap<>();
//            for (int i = 0; i < N; i++) {
//                map.put(i, new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
//            }
            customers = new int[N][2];
            for(int i=0;i<N;i++){
                customers[i][0] = Integer.parseInt(st.nextToken());
                customers[i][1] = Integer.parseInt(st.nextToken());
            }

            min = Integer.MAX_VALUE;
            tmp = new int[N];
            visited = new boolean[N];
//            for (int i = 0; i < N; i++) {
//                visited[i] = true;
//                dfs(i, 0);
//                visited[i] = false;
//            }
            dfs2(0);

            sb.append("#").append(t).append(" ").append(min).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs2(int depth){
        if(depth==N){
            compareMin(tmp);
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;

                tmp[depth] = i;
                dfs2(depth+1);

                visited[i] = false;
            }
        }
    }

    // 순열
    static void dfs(int curr, int idx) {
        tmp[idx] = curr;

        if (idx == N - 1) {
            compareMin(tmp);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, idx + 1);
                visited[i] = false;
            }
        }
    }

    static int getDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    static void compareMin(int[] tmp){
        int res = 0;
//        res += getDist(company, map.get(tmp[0]));
        res += getDist(company, customers[tmp[0]]);
        for(int i=0;i<N-1; i++){
//            res += getDist(map.get(tmp[i]), map.get(tmp[i+1]));
            res += getDist(customers[i], customers[i+1]);
        }
//        res += getDist(map.get(tmp[N-1]), home);
        res += getDist(customers[tmp[N-1]], home);

        min = Math.min(min, res);
    }
}