package 그래프.그래프의표현;

import java.io.*;
import java.util.*;

public class 백준_1707_이분그래프 {
    static int k, v, e;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] colors;
    static boolean isBinaryGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 0; t < k; t++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            // V, E 받음
            visited = new boolean[v + 1];
            colors = new int[v + 1];
            isBinaryGraph = true;

            arr = new ArrayList[v + 1];
            for (int i = 0; i <= v; i++) {
                arr[i] = new ArrayList<>();
            }
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                arr[u].add(v);
                arr[v].add(u);
            }
            // arr, visited 세팅 완료

// dfs
// 주어진 그래프가 1개로 연결되어 있다는 보장 없기 때문에 모든 노드에서 수행
//            for (int node = 1; node <= v; node++) {
//                if (isBinaryGraph) {
//                    if(!visited[node]) dfs(node);
//                } else break;
//            }

// bfs
            isBinaryGraph = true;
            for(int node=1;node<=v;node++){
                if(colors[node]==0){
                    isBinaryGraph = bfs(node, 1);
                }
                if(!isBinaryGraph) break;
            }

            bw.write((isBinaryGraph ? "YES" : "NO") + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static boolean bfs(int current, int color){
        Queue<Integer> q = new LinkedList<>();

        q.add(current);
        colors[current] = color; // 시작 정점을 임의의 색으로 칠하기

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int next : arr[curr]){
                // 다음 노드와 현재 노드의 색이 같으면 이분 그래프가 아님
                if(colors[curr] == colors[next]) return false;

                // 인접 정점이 아직 색칠되어 있지 않다면 현재 정점의 반대 색으로 칠하기
                if(colors[next]==0){
                    colors[next] = colors[curr] * -1;
                    q.add(next);
                }
            }
        }
        return true;
    }

    static void dfs(int current) {
        visited[current] = true;

        for (int next : arr[current]) {
            // 인접한 노드는 같은 집합이 아님 -> 이전 노드와 다른 집합으로 처리
            if (!visited[next]) {
                colors[next] = (colors[current] + 1) %2;
                dfs(next);
            }else if(colors[current]== colors[next]){ // 이미 방문한 노드가 현재 내 노드와 같은 집합이라면
                isBinaryGraph = false;
            }
        }
    }
}
