package 그래프.플로이드워셜;

import java.util.*;
import java.io.*;

public class 백준_1389_케빈베이컨의6단계법칙 {
    static int[][] res;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        res = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j) res[i][j] = 0;
                else res[i][j]  = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            res[a][b] = 1;
            res[b][a] = 1;
        }

//  플로이드워셜 알고리즘 이용
        for(int k=1;k<=n;k++){
            for(int s=1;s<=n;s++){
                for(int e=1;e<=n;e++){
                    int r1 = res[s][k], r2 = res[k][e];
                    if(r1==Integer.MAX_VALUE || r2==Integer.MAX_VALUE) continue;
                    res[s][e] = Math.min(res[s][e], r1 + r2);
                }
            }
        }

        int kevin = 0, min = Integer.MAX_VALUE;
        for(int s=1;s<=n;s++){
            int sum = 0;

            for(int e=1;e<=n;e++){
                if(s==e) continue;

                sum += res[s][e];
            }

            if(sum < min){
                min = sum;
                kevin = s;
            }
        }

//        for(int i=1;i<=n;i++){
//            for(int j=1;j<=n;j++){
//                System.out.print(res[i][j]+" ");
//            }
//            System.out.println();
//        }

        System.out.println(kevin);

//  Sol 1 > BFS 를 이용한 방법
//        int kevin = 0, min = Integer.MAX_VALUE;
//        for (int s = 1; s <= n; s++) {
//            int sum = 0;
//            for (int e = 1; e <= n; e++) {
//                if (s == e) continue;
//                sum += bfs(s, e);
//            }
//            if(sum < min){
//                kevin = s;
//                min = sum;
//            }
//        }
//
//        System.out.println(kevin);
    }

//    Sol 1 > BFS 를 이용한 방법 -> 메모리 초과
//    static int bfs(int s, int e) {
//        boolean[] visited = new boolean[n + 1];
//        Deque<int[]> pq = new ArrayDeque<>();

//     위의 두개를 int[] dist = new int[n+1];
//    Arrays.fill(dist, -1); // 방문하지 않은 노드는 -1로 표시
//    dist[start] = 0;

//        pq.offer(new int[]{s, 0}); // 현재 노드, depth
//
//        while (!pq.isEmpty()) {
//            int[] current = pq.poll();
//            visited[current[0]] = true;
//
//            if (current[0] == e) {
//                return current[1];
//            }
//
//            for (int next : arr[current[0]]) {
//                if (!visited[next]) {
//                    pq.offer(new int[]{next, current[1] + 1});
//                }
//            }
//        }
//
//        return -1;
//    }
}
