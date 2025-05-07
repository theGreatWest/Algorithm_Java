package DailyCheckUp.Date_25_05_N.D07;

import java.util.*;
import java.io.*;

public class SWEA_7465_창용마을무리의개수 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 마을에 사는 사람 수
            M = Integer.parseInt(st.nextToken()); // 서로 알고 있는 관계 수

            arr = new int[N+1];
            for(int i=1;i<=N;i++){
                arr[i] = i;
            }

            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            Set<Integer> set = new HashSet<>();
            for(int i=N;i>0;i--){
                set.add(find(i));
            }

            sb.append("#").append(t).append(" ").append(set.size()).append("\n");
        }

        System.out.print(sb);
    }

    static int find(int a){
        if(arr[a] == a) return a;

        return arr[a] = find(arr[a]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a!=b) arr[b] = a;
    }
}
