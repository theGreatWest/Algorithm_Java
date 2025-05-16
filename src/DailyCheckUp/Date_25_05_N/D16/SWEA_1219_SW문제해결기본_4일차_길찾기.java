package DailyCheckUp.Date_25_05_N.D16;

import java.util.*;
import java.io.*;

public class SWEA_1219_SW문제해결기본_4일차_길찾기 {
    static final int TOTAL_NUM = 100;

    static int N;
    static boolean possible;
    static List<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 1; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tc = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            arr = new ArrayList[TOTAL_NUM];
            for (int i = 0; i < TOTAL_NUM; i++) {
                arr[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                arr[start].add(end);
            }

            possible = false;
//            dfs(0);
            bfs();

            sb.append("#").append(tc).append(" ").append(possible ? 1 : 0).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int curr) {
        if (curr == 99) {
            possible = true;
            return;
        }

        for (int next : arr[curr]) {
            dfs(next);
        }
    }

    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int next : arr[curr]){
                if(next==99){
                    possible = true;
                    break;
                }
                q.offer(next);
            }

            if(possible) break;
        }
    }
}
