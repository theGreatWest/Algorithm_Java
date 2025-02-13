package 그래프.그래프의표현;

import java.io.*;
import java.util.*;

// visited, Queue<int[]> q (NodeNum, Depth) 이용해 구현

public class 백준_18352_특정거리의도시찾기 {
    static int n, m, k, x;
    static ArrayList<Node>[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        arr = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeS = Integer.parseInt(st.nextToken());
            int nodeE = Integer.parseInt(st.nextToken());
            arr[nodeS].add(new Node(nodeE, 1));
        }
        br.close();

        // process : bfs
        bfs();
    }

    static void bfs() throws IOException{
        List<Integer> res = new ArrayList<>();

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, 0}); // node 번호, depth
        visited[x] = true;

        while (!q.isEmpty()) {
            int[] currentNode = q.poll();
            int num = currentNode[0];
            int depth = currentNode[1];

            for (Node nextNode : arr[num]) {
                if (!visited[nextNode.num]) {
                    if (depth + 1 == k) res.add(nextNode.num);

                    visited[nextNode.num] = true;
                    q.offer(new int[]{nextNode.num, depth + 1});
                }
            }
        }

        if (res.isEmpty()) System.out.println("-1");
        else {
            Collections.sort(res);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for(int num : res){
                bw.write(num+"\n");
            }
            bw.flush();
            bw.close();
        }
    }

    static class Node {
        int num;
        int distance;

        public Node(int num, int distance) {
            this.num = num;
            this.distance = distance;
        }
    }
}

// dist[] 이용해 구현

//package 그래프.그래프의표현;
//
//import java.io.*;
//import java.util.*;
//
//public class 백준_18352_특정거리의도시찾기 {
//    static int n, m, k, x;
//    static ArrayList<Node>[] arr;
//    static int[] distance;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        k = Integer.parseInt(st.nextToken());
//        x = Integer.parseInt(st.nextToken());
//        distance = new int[n + 1];
//        Arrays.fill(distance, -1);
//        arr = new ArrayList[n + 1];
//        for (int i = 0; i <= n; i++) {
//            arr[i] = new ArrayList<>();
//        }
//        for (int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine());
//            int nodeS = Integer.parseInt(st.nextToken());
//            int nodeE = Integer.parseInt(st.nextToken());
//            arr[nodeS].add(new Node(nodeE, 1));
//        }
//        br.close();
//
//        // process : bfs
//        bfs();
//
//        // output : k 거리에 있는 값들 출력
//        List<String> res = new ArrayList<>();
//        for(int i=1;i<=n;i++){
//            if(distance[i]==k) res.add(String.valueOf(i));
//        }
//
//        if(res.isEmpty()) System.out.println("-1");
//        else {
//            Collections.sort(res);
//            System.out.println(String.join("\n", res));
//        }
//    }
//
//    static void bfs() {
//        Queue<Integer> q = new LinkedList<>();
//        q.offer(x);
//        distance[x] = 0; // 시작 노드의 거리는 0
//
//        while(!q.isEmpty()){
//            int currentNode = q.poll();
//
//            for(Node nextNode : arr[currentNode]){
//                if(distance[nextNode.num] == -1){ // 다음 노드가 방문하지 않은 노드라면
//                    distance[nextNode.num]   = distance[currentNode] + nextNode.distance;
//                    q.offer(nextNode.num);
//                }
//            }
//        }
//    }
//
//    static class Node {
//        int num;
//        int distance;
//
//        public Node(int num, int distance) {
//            this.num = num;
//            this.distance = distance;
//        }
//    }
//}
