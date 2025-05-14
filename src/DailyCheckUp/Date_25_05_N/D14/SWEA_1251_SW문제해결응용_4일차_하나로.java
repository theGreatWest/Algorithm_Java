package DailyCheckUp.Date_25_05_N.D14;

import java.io.*;
import java.util.*;

public class SWEA_1251_SW문제해결응용_4일차_하나로 {
    static int N;
    static double E;
    static int[] X, Y, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            // input
            N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            X = new int[N];
            for (int i = 0; i < N; i++) {
                X[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            Y = new int[N];
            for(int i=0;i<N;i++){
                Y[i] = Integer.parseInt(st.nextToken());
            }

            E = Double.parseDouble(br.readLine());

            // solve
            // 부담금 : E * 터널길이^2 => 최소
            // 총 환경 부담금을 최소로 지불, N개의 모든 섬을 연결
            arr = new int[N]; // union-find 배열
            for(int i=1;i<N;i++){
                arr[i] = i;
            }

            PriorityQueue<ConnectInfo> pq = new PriorityQueue<>();
            for(int i=0;i<N;i++){
                for(int j=i+1;j<N;j++){
                    pq.offer(new ConnectInfo(i, j));
                }
            }

            double resE = 0.0;
            while(!pq.isEmpty()){
                ConnectInfo ci = pq.poll();

                if(find(ci.num1)==find(ci.num2)) continue;

                union(ci.num1, ci.num2);
                resE += ci.e;
            }

            // output
            sb.append("#").append(t).append(" ").append(String.format("%.0f", resE)).append("\n");
        }

        System.out.print(sb);
    }

    static int find(int a){
        if(arr[a]==a) return a;

        return arr[a] = find(arr[a]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a!=b) arr[b] = a;
    }

    static class ConnectInfo implements Comparable<ConnectInfo> {
        int num1;
        int num2;
        double e;

        public ConnectInfo(int a, int b) {
            this.num1 = a;
            this.num2 = b;
            this.e = calculationE();
        }

        private double calculationE(){
            int ax = X[num1], ay = Y[num1];
            int bx = X[num2], by = Y[num2];

            return (Math.pow((ax-bx),2) + Math.pow((ay-by),2)) * E;
        }

        @Override
        public int compareTo(ConnectInfo o) { // 환경 부담 세율이 작은 것부터 출력
            return Double.compare(this.e, o.e);
        }
    }
}
