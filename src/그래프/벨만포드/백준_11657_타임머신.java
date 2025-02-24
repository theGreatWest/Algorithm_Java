package 그래프.벨만포드;

import java.util.*;
import java.io.*;

public class 백준_11657_타임머신 {
    static final int INF = Integer.MAX_VALUE;

    static int n, m;
    //    static ArrayList<Node>[] arr;
    static Edge[] edges;
    static long[] res;
    static boolean cycle = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

//        arr = new ArrayList[n+1];
//        for(int i=1;i<=n;i++){
//            arr[i] = new ArrayList<>();
//        }

        edges = new Edge[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

//            arr[a].add(new Node(b, c));

            edges[i] = new Edge(a, b, c);
        }

        res = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = INF;
        }

        // 벨만포드 알고리즘
        bellmanFord();

        if (cycle) System.out.println(-1);
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= n; i++) {
                sb.append((res[i] == INF) ? -1 : res[i]).append("\n");
            }
            System.out.print(sb);
        }
    }

    static void bellmanFord() {
        // Dijkstra 알고리즘과 다른 점!
        // 우선순위 큐를 사용하지 않고, 그냥 n-1번 돌려주기

// 다익스트라 알고리즘
//        PriorityQueue<Node> pq = new PriorityQueue<>();
//
//        pq.offer(new Node(1, 0));
//        res[1] = 0;
//
//        while(!pq.isEmpty()){
//            Node current = pq.poll();
//
//            for(Node next : arr[current.num]){
//                if(res[current.num]!=INF){ // 현재 노드의 결과값이 무한대가 아닐 때
//                    int newTime = current.time + next.time; // 해당 노드의 시간(누적값) + 다음노드까지 걸리는 시간
//                    if(newTime < res[next.num]){ // 업데이트 값이 도착지점의 기존 값보다 작다면
//                        res[next.num] = newTime; // 업데이트
//                        pq.offer(new Node(next.num, newTime)); // 다음 노드 pq에 넣기
//                    }
//                }
//            }
//        }

// 벨만포드 알고리즘
        res[1] = 0;
        for (int i = 1; i < n; i++) { // n-1 번 반복하며 최단거리 찾기
            for (int e = 0; e < m; e++) { // 모든 엣지 돌기
                Edge edge = edges[e];

                // 더 작은 최단 거리가 있을 때 업데이트하기
                if (res[edge.start] != INF) {
                    long newTime = res[edge.start] + edge.time;
                    if (newTime < res[edge.end]) {
                        res[edge.end] = newTime;
                    }
                }
            }
        }

        // 사이클 존재 여부 판단 -> 벨만포드
        // 모든 노드 연결 정보 다시 한 번 돌려봤을 때 업데이트 되면 사이클 O
        for (int e = 0; e < m; e++) {
            Edge edge = edges[e];
            if (res[edge.start] != INF) {
                long newTime = res[edge.start] + edge.time;
                if (newTime < res[edge.end]) {
                    cycle = true;
                    return;
                }
            }
        }
    }

    static class Edge {
        int start;
        int end;
        int time;

        public Edge(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }

//    static class Node implements Comparable<Node>{
//        int num;
//        int time;
//
//        public Node(int num, int time) {
//            this.num = num;
//            this.time = time;
//        }
//
//        @Override
//        public int compareTo(Node other){
//            return this.time - other.time;
//        }
//    }
}
