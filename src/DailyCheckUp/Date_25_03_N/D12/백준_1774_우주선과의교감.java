package DailyCheckUp.Date_25_03_N.D12;

import java.util.*;
import java.io.*;

public class 백준_1774_우주선과의교감 {
    static int n, m;
    static long[][] godsPosition;
    static int[] unionArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 신들의 위치 & 번호 저장
        godsPosition = new long[n+1][2];
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            long x = Integer.parseInt(st.nextToken());
            long y = Integer.parseInt(st.nextToken());

            godsPosition[i] = new long[]{x, y};
        }

        // 이미 연결된 통로 저장 -> union find 로 연결해주기
        unionArr = new int[n+1];
        for(int i=1;i<=n;i++){
            unionArr[i] = i;
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            union(s, e);
        }

        // 우선순위 큐에 s -> e 전체 쌍 넣어주기
        PriorityQueue<Distance> pq = new PriorityQueue<>();
        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                pq.offer(new Distance(i, j));
            }
        }

        // 값이 가장 작은 것을 뽑은 뒤, 이미 연결 되었으면 pass, 아니면 연결 + 값 더해주기
        double totLength = 0;
        while(!pq.isEmpty()){ // 사이클이 있을 때, 초기 연결 상태를 완전히 반영하지 않기 때문에 cnt 조건은 빼주기
            Distance curr = pq.poll();

            if(find(curr.s) != find(curr.e)){
                totLength += curr.distance;
                union(curr.s, curr.e);
            }
        }

        System.out.printf("%.2f", totLength);
    }

    static int find(int a){
        int value = unionArr[a];

        if(value == a) return a;
        return unionArr[a] = find(value);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a!=b){
            unionArr[b] = a;
        }
    }

    static class Distance implements Comparable<Distance> {
        int s, e;
        double distance;

        public Distance(int s, int e) {
            this.s = s;
            this.e = e;
            this.distance = calculator(s, e);
        }

        public double calculator(int s, int e){
            long sx = godsPosition[s][0], sy = godsPosition[s][1];
            long ex = godsPosition[e][0], ey = godsPosition[e][1];

            return Math.sqrt(Math.pow((sx-ex), 2) + Math.pow((sy-ey), 2));
        }

        @Override
        public int compareTo(Distance o) {
            return Double.compare(this.distance, o.distance);
        }
    }
}
