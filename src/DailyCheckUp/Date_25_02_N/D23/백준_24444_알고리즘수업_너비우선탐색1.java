package DailyCheckUp.Date_25_02_N.D23;

import java.util.*;
import java.io.*;

public class 백준_24444_알고리즘수업_너비우선탐색1 {
    static int n, m, r;
    static List<Integer>[] arr;
    static boolean[] visited;

    static Map<Integer, Integer> res = new HashMap<>();

    static int[] order;  // 방문 순서 저장 배열

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = new ArrayList<>();
        }

        visited = new boolean[n+1];

        for(int e=0;e<m;e++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[u].add(v);
            arr[v].add(u);
        }

        // 모든 정점을 오름차순 정렬 (한 번만 수행)
        for (int i = 1; i <= n; i++) {
            Collections.sort(arr[i]);
        }

        order = new int[n+1];

        BFS();

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
//            if(res.containsKey(i)){
//                sb.append(res.get(i));
//            }else sb.append("0");
//            sb.append("\n");
            sb.append(order[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void BFS(){
        Queue<Integer> q = new LinkedList<>();

        q.offer(r);
        visited[r] = true;
        int cnt = 1;
        order[r] = cnt;
//        res.put(r, cnt);

        while(!q.isEmpty()){
            int current = q.poll();

//            Collections.sort(arr[current]);
            for(int next : arr[current]){
                if(!visited[next]){
                    q.offer(next);
                    visited[next] = true;
//                    res.put(next, ++cnt);
                    order[next] = ++cnt;
                }
            }
        }
    }
}