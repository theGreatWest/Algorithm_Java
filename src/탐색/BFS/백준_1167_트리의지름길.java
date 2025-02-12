package 탐색.BFS;

import java.io.*;
import java.util.*;

public class 백준_1167_트리의지름길 {
    // 트리 ( 끝점이 2개인 구조 )
    // 아무 노드에서 시작 -> 끝점 구하기
    // 끝점에서 시작 -> 가장 먼 곳이 또 다른 끝점

    static int v;
    static ArrayList<Node>[] arr;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());

        arr = new ArrayList[v + 1];
        for (int i = 0; i <= v; i++) {
            arr[i] = new ArrayList<>();
        }

        visited = new boolean[v + 1];
        dist = new int[v + 1];

        for (int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sN = Integer.parseInt(st.nextToken());
            while (true) {
                int n = Integer.parseInt(st.nextToken());
                if (n == -1) break;
                int value = Integer.parseInt(st.nextToken());
                arr[sN].add(new Node(n, value));
            }
        }

        // process
        BFS(1);

        // 다음 노드 구하기
        int max = Integer.MIN_VALUE, maxIdx = 0;
        for (int i = 1; i <= v; i++) {
            if (dist[i] > max) {
                max = dist[i];
                maxIdx = i;
            }
        }

        // visited, dist 모두 초기화
        visited = new boolean[v+1];
        dist = new int[v+1];

        BFS(maxIdx);

        // output
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Arrays.sort(dist);
        bw.write(dist[v] + "\n");
        bw.flush();
        bw.close();
    }

    static void BFS(int startNode) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(startNode);
        visited[startNode] = true;

        while (!q.isEmpty()) {
            int startN = q.poll();
            ArrayList<Node> nodes = arr[startN];
            for (Node node : nodes) {
                if (!visited[node.n]) {
                    q.offer(node.n);
                    visited[node.n] = true;
                    dist[node.n] += node.value + dist[startN];
                }
            }
        }
    }

    static class Node {
        int n;
        int value;

        public Node(int n, int value) {
            this.n = n;
            this.value = value;
        }
    }
}
