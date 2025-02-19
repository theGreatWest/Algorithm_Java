package 그래프.다익스트라;

import java.util.*;
import java.io.*;

public class 백준_1916_최소비구하기 {
    static final int INF = Integer.MAX_VALUE;

    static int n, m;
    static int start, end;

    static ArrayList<Node>[] arr;
    static boolean[] visited;

    static int[] result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>(); // 각 인덱스마다 새로운 ArrayList 생성
        }

        visited = new boolean[n+1];

        StringTokenizer st;
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            arr[a].add(new Node(b, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        result = new int[n+1];
        for (int i = 1; i <= n; i++) {
            result[i] = INF; // 각 인덱스마다 새로운 ArrayList 생성
        }
        result[start] = 0;

        dijkstra();

//        System.out.println(Arrays.toString(result));
        System.out.println(result[end]);
    }

    static void dijkstra(){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start, 0));

        while(!q.isEmpty()){
            Node current = q.poll();
//            System.out.println(current.toString());

            if(visited[current.city]) continue;
            visited[current.city] = true;

            for(Node next : arr[current.city]){
                int newCost = next.cost + current.cost;
                if(newCost < result[next.city]){
                    result[next.city] = newCost;
                    q.offer(new Node(next.city, newCost));
                }
            }

//            System.out.println(Arrays.toString(result)+"\n");
        }
    }

    static class Node implements Comparable<Node> {
        int city;
        int cost;

        public Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other){
            return this.cost - other.cost; // 비용을 기준으로 작은 것부터 탐색(priorityQueue 에서 Node를 사용하기 위함)
        }

        @Override
        public String toString() {
            return "Node{" +
                    "city=" + city +
                    ", cost=" + cost +
                    '}';
        }
    }
}
