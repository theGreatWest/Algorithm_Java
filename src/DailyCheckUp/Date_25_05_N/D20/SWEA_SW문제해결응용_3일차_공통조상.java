package DailyCheckUp.Date_25_05_N.D20;

import java.util.*;
import java.io.*;

public class SWEA_SW문제해결응용_3일차_공통조상 {
    static int V, E, a, b;
    static List<Integer>[] tree;
    static int[] parentInfo;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            parentInfo = new int[V+1];
            tree = new ArrayList[V+1];
            for(int i=1;i<=V;i++){
                tree[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<E;i++){
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                tree[parent].add(child);
                parentInfo[child] = parent;
            }

            visited = new boolean[V+1];
            // a가 지나가는 길을 true로 처리
            for(int i=a;i!=0;i=parentInfo[i]){
                visited[i] = true;
            }
            // 가장 가까운 조상 찾기
            int h = 1;
            for(int i=b;i!=0;i=parentInfo[i]){
                if(visited[i]) {
                    h = i;
                    break;
                }
            }

            // 서브트리 개수 구하기
            int subNum = bfs(h);

            sb.append("#").append(t).append(" ").append(h).append(" ").append(subNum).append("\n");
        }

        System.out.print(sb);
    }

    static int bfs(int h){
        Queue<Integer> q = new LinkedList<>();
        q.offer(h);
        int cnt = 0;

        while(!q.isEmpty()){
            int curr = q.poll();
            cnt++;

            for(int next : tree[curr]){
                q.offer(next);
            }
        }

        return cnt;
    }
}
