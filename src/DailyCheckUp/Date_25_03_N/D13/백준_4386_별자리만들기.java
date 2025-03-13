package DailyCheckUp.Date_25_03_N.D13;

import java.io.*;
import java.util.*;

// n 개의 별 이어 별자리 하나 만들기.
// 모든 별들은 별자리 위의 선을 통해 서로 직/간접적으로 이어져 있어야.
// 두 별 사이의 거리만큼 비용이 든다 -> 최소비용

public class 백준_4386_별자리만들기 {

    static int n;

    static double[][] stars;
    static int[] uArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        // 별자리 위치 입력 : index - 별자리 고유 번호 , [0],[1] - 각각 x,y 좌표
        stars = new double[n][2];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j <2; j++){
                stars[i][j] = Double.parseDouble(st.nextToken());
            }
        }

        // 별자리의 고유 번호
        uArr = new int[n];
        for(int i=0;i<n;i++){
            uArr[i] = i;
        }

        // 우선순위 큐에 모든 경우의 수 넣어주기
        PriorityQueue<Star> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                pq.offer(new Star(i, j));
            }
        }

        // 별자리에서 길이가 짧은 것 순서로 잇고, 집합이 아닐 경우 집합으로 만들어주기
        double minLength = 0.0;
        while(!pq.isEmpty()){
            Star curr = pq.poll();

            if(find(curr.s) != find(curr.e)){
                minLength += curr.length;
                union(curr.s, curr.e);
            }
        }

        // 출력
        System.out.printf("%.2f", minLength);
    }

    static int find(int a){
        int value = uArr[a];

        if(value==a) return a;
        return uArr[a] = find(value);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a!=b) uArr[b] = a;
    }

    static class Star implements Comparable<Star> {
        int s;
        int e;
        double length;

        public Star(int s, int e) {
            this.s = s;
            this.e = e;
            this.length = calculator(s, e);
        }

        private double calculator(int s, int e){
            double sx = stars[s][0], sy = stars[s][1];
            double ex = stars[e][0], ey = stars[e][1];

            return Math.sqrt(Math.pow((sx - ex), 2) + Math.pow((sy - ey), 2));
        }

        @Override
        public int compareTo(Star o){
            return Double.compare(this.length, o.length);
        }
    }
}
