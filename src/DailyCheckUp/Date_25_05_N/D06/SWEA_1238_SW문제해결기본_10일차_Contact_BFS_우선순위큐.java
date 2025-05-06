package DailyCheckUp.Date_25_05_N.D06;

import java.util.*;
import java.io.*;

public class SWEA_1238_SW문제해결기본_10일차_Contact_BFS_우선순위큐 {
    static List<Integer>[] connectInfo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 10;
        for (int t = 1; t <= T; t++) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int length = tmp[0];
            int start = tmp[1];

            connectInfo = new ArrayList[101];
            for(int i=1;i<=100;i++){
                connectInfo[i] = new ArrayList<>();
            }
            tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int i=0;i<length;i+=2){
                int from = tmp[i];
                int to = tmp[i+1];

                connectInfo[from].add(to);
            }

            sb.append("#").append(t).append(" ").append(bfs(start)).append("\n");
        }

        System.out.print(sb);
    }

    static int bfs(int start){
        PriorityQueue<Info>  pq = new PriorityQueue<>();
        boolean[] visited = new boolean[101];
        int resDepth = -1;
        int resNum = -1;

        visited[start] = true;
        pq.offer(new Info(start, 0));

        while(!pq.isEmpty()){
            Info curr = pq.poll();

            if(curr.depth > resDepth) {
                resDepth = curr.depth;
                resNum = curr.num;
            }

            for(int next : connectInfo[curr.num]){
                if(!visited[next]){
                    visited[next] = true;
                    pq.offer(new Info(next, curr.depth+1));
                }
            }
        }

        return resNum;
    }

    static class Info implements Comparable<Info> {
        int num;
        int depth;

        public Info(int num, int depth) {
            this.num = num;
            this.depth = depth;
        }

        @Override
        public int compareTo(Info o) {
            if(this.depth == o.depth) return o.num - this.num;
            return this.depth - o.depth;
        }
    }
}
