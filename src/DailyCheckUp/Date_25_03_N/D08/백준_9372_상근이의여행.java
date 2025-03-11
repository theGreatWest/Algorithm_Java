package DailyCheckUp.Date_25_03_N.D08;

import java.util.*;
import java.io.*;

public class 백준_9372_상근이의여행 {
    static int countryTot, flightTot;
    static int[] unionArr;

    // 그냥 n-1 을 답으로 내도 되지만 union-find 이용해 보자

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            st = new StringTokenizer(br.readLine());
            countryTot = Integer.parseInt(st.nextToken());
            flightTot = Integer.parseInt(st.nextToken());

            Queue<Edge> q = new LinkedList<>();
            for(int o=0;o<flightTot;o++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                q.offer(new Edge(a, b));
            }

            unionArr = new int[countryTot+1];
            for(int i=1;i<=countryTot;i++){
                unionArr[i] = i;
            }

            int flight = 0;
            while(!q.isEmpty()){
                Edge curr = q.poll();

                if(find(curr.s) != find(curr.e)){
                    flight++;
                    union(curr.s, curr.e);
                }
            }

            sb.append(flight).append("\n");
        }

        System.out.print(sb);
    }

    static int find(int a){
        if(unionArr[a] == a) return a;

        return unionArr[a] = find(unionArr[a]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        unionArr[b] = a;
    }

    static class Edge {
        int s;
        int e;

        public Edge(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}
