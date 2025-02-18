package 그래프.위상정렬;

import java.util.*;
import java.io.*;

public class 백준_2252_줄세우기 {
    static int n, m;
    static int[] indegree;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = new ArrayList<>();
        }

        indegree = new int[n+1];
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());

            indegree[back]++;

            arr[front].add(back);
        }

        // 위상정렬 수행
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder()  ;
        while(!q.isEmpty()){
            int current = q.poll();
            sb.append(current).append(" ");

            for(int next : arr[current]){
                if(--indegree[next]==0) q.offer(next);
            }
        }

        System.out.println(sb);
    }
}
