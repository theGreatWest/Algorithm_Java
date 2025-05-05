package DailyCheckUp.Date_25_05_N.D05;

import java.io.*;
import java.util.*;

public class SWEA_1249_SW문제해결응용_4일차_보급로 {
    static final int[] di = {0, 0, -1, 1};
    static final int[] dj = {-1, 1, 0, 0};

    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = input.charAt(j) - '0';
                }
            }

            sb.append("#").append(t).append(" ").append(bfs(0, 0, arr[0][0])).append("\n");
        }

        System.out.print(sb);
    }

    // 비용 기반의 문제는 단순 visited 배열로는 풀 수 없다.
    // dist 배열(각 노드에 도달하는 최소 비용 저장 배열)과 우선순위 큐, BFS 를 활용해야 한다.

    // 📌 이 문제를 단순 BFS로 풀 수 없는 이유
    // 단순 BFS는 모든 간선의 가중치가 동일할 때만 최단 경로를 보장한다.
    // 이렇게 노드마다 비용이 다를 경우엔, 최소 비용을 보장하기 위해 다익스트라(우선순위 큐+BFS)를 이용해야 한다.
    static int bfs(int startI, int startJ, int startCost){
        int[][] cost = new int[N][N];
        for(int i=0;i<N;i++){ // 각 노드에 도달하는 최소 비용을 관리하는 배열
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        cost[startI][startJ] = startCost;

        PriorityQueue<Cost> pq = new PriorityQueue<>();
        pq.offer(new Cost(startI, startJ, startCost));

        while (!pq.isEmpty()){
            Cost curr = pq.poll();

            // 꺼낸 노드가 기존의 비용보다 클 경우엔, 아래의 과정 스킵
            if(curr.cost > cost[curr.i][curr.j]) continue;

            for(int d=0;d<4;d++){
                int ni = curr.i + di[d];
                int nj = curr.j + dj[d];

                if(isValidPosition(ni, nj)){
                    int nCost = curr.cost + arr[ni][nj];

                    if(nCost < cost[ni][nj]){ // 더 적은 비용으로 도달 가능한 경우만 우선순위 큐에 삽입
                        cost[ni][nj] = nCost;
                        pq.offer(new Cost(ni, nj, nCost));
                    }
                }
            }
        }

        return cost[N-1][N-1];
    }

    static boolean isValidPosition(int i, int j){
        return i>=0 && i<N && j>=0 && j<N;
    }

    static class Cost implements Comparable<Cost>{
        int i;
        int j;
        int cost;

        public Cost(int i, int j, int cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;
        }

        @Override
        public int compareTo(Cost o) {
            return this.cost - o.cost; // 작은 거 순서로
        }
    }
}
