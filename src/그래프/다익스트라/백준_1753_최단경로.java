package 그래프.다익스트라;

import java.util.*;
import java.io.*;

public class 백준_1753_최단경로 {
    static final int INF = Integer.MAX_VALUE;

    static int v, e, start;
    static int[] res;
//    static int[][] weight;
    static ArrayList<Node>[] list;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        res = new int[v + 1];
        Arrays.fill(res, INF);

        start = Integer.parseInt(br.readLine());
        res[start] = 0;

//        weight = new int[v + 1][v + 1];
        list = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, w));
//            weight[u][v] = w;
        }

//        Dijkstra1(start);
        Dijkstra2(start);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            sb.append((res[i] == INF) ? "INF" : res[i]).append("\n");
        }
        System.out.print(sb);
    }

//    재귀호출을 이용한 다익스트라 : 시간 초과
//    static void Dijkstra1(int start) {
//        for (int end : list[start]) {
//            res[end] = Math.min(res[end], res[start] + weight[start][end]);
//            Dijkstra1(end);
//        }
//    }

//    큐를 이용한 다익스트라
    static void Dijkstra2(int start){
        visited = new boolean[v+1];

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
//        res[start] = 0;

        while(!q.isEmpty()){
            Node curr = q.poll();
            int nowIdx = curr.num;
            int nowCost = curr.weight;

            if(visited[nowIdx]) continue; // 이미  방문한 적이 있는 노드는 처리 X
            visited[nowIdx] = true;

            for(Node next : list[nowIdx]){
                int cost = res[nowIdx] + next.weight;
                if(cost < res[next.num]){
                    res[next.num] = cost;
                    q.add(new Node(next.num, res[next.num]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int num;
        int weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return this.weight - other.weight; // 비용이 작은 순서대로 정렬
            // 다익스트라에서는 비용이 적은 노드부터 탐색하기 때문에 필수적
        }
    }
}
