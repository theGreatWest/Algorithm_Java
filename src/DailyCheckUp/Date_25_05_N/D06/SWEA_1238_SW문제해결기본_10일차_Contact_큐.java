package DailyCheckUp.Date_25_05_N.D06;

import java.util.*;
import java.io.*;

public class SWEA_1238_SW문제해결기본_10일차_Contact_큐 {
    static List<Integer>[] connectInfo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 10;
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dataLen = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            connectInfo = new ArrayList[101];
            for(int i=1;i<=100;i++){
                connectInfo[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<dataLen;i+=2){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                connectInfo[from].add(to);
            }

            sb.append("#").append(t).append(" ").append(bfs(start)).append("\n");
        }

        System.out.print(sb);
    }

    // class를 만들어 큐에 삽입할 데이터를 class로 만들어 관리하고 우선순위 큐를 사용하면, 가독성이 높아지지만 메모리 사용량이 증가하며 실행시간이 오래 걸린다.
    static int bfs(int start){
        boolean[] visited = new boolean[101];
        Queue<int[]> q = new LinkedList<>();
        int resDepth = -1, resNum = -1;

        visited[start] = true;
        q.offer(new int[]{start, 0}); // num, depth

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int currNum = tmp[0];
            int currDepth = tmp[1];

            if(currDepth > resDepth) {
                resDepth = currDepth;
                resNum = currNum;
            }else if(currDepth == resDepth) resNum = Math.max(resNum, currNum);


            for(int next : connectInfo[currNum]){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new int[]{next, currDepth + 1});
                }
            }
        }

        return resNum;
    }
}
