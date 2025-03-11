package DailyCheckUp.Date_25_02_N.D25;

import java.util.*;
import java.io.*;

public class 백준_11779_최소비용구하기2 {
//    static final int INF = Integer.MAX_VALUE;
    static final long INF = Long.MAX_VALUE; // totCost 배열이 long 형이라 Long.MAX_VALUE 를 사용해야 오버플로우 위험이 없어진다.

    static int n, m, s, e;
    static long[] totCost;
    static int[] prevCity;
    static List<Node>[] arr;

    public static void main(String[] args) throws IOException{
        input();
        Dijkstra();
        print();
    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = new ArrayList<>();
        }

        prevCity = new int[n+1];

        StringTokenizer st;
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken() );
            int e = Integer.parseInt(st.nextToken() );
            int cost = Integer.parseInt(st.nextToken() );

            arr[s].add(new Node(e, cost));
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        totCost = new long[n+1];
        for(int i=1;i<=n;i++){
            totCost[i] = INF;
        }
    }

    static void Dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s, 0));
        totCost[s] = 0;

        while(!pq.isEmpty()){
            Node currentCity = pq.poll();

            if(currentCity.num==e) break; // 사이클이 없다고 가정했기 때문에 이 처리를 해줘야 함

            for(Node nextCity : arr[currentCity.num]){
                int nCost = currentCity.cost + nextCity.cost;
                if(nCost < totCost[nextCity.num]){
                    totCost[nextCity.num]   = nCost;
                    prevCity[nextCity.num] = currentCity.num;
                    pq.offer(new Node(nextCity.num, nCost));
                }
            }
        }
    }

    static void print(){
        StringBuilder sb = new StringBuilder();
        sb.append(totCost[e]).append("\n");

        int cnt = 0, currentCity = e;
        List<String> list = new ArrayList<>();
        while(true){
            cnt++;
            list.add(0, String.valueOf(currentCity));

            if(prevCity[currentCity] == 0) break;
            currentCity = prevCity[currentCity];
        }

        sb.append(cnt).append("\n");
        sb.append(String.join(" ", list));

        System.out.println(sb);
    }

    static class Node implements Comparable<Node>{
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other){
//            return this.cost - other.cost;
            return Integer.compare(this.cost, other.cost);
            // int 범위 초과 시 오버플로우 방지 가능하다.
        }
    }
}
