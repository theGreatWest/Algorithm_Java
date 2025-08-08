package DailyCheckUp.Date_25_08_N;

import java.util.*;
import java.io.*;

public class 백준_16236_아기상어 {
    static final int[] di = {-1,0,1,0}; // 상,좌,하,우
    static final int[] dj = {0,-1,0,1};

    static int N;
    static int[][] map;
    static int sharkI, sharkJ;
    static int fishCnt = 0, eatFishCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int value = Integer.parseInt(st.nextToken());

                if(value == 9) {
                    sharkI = i;
                    sharkJ = j;
                    map[i][j] = 2;
                    continue;
                }

                map[i][j] = value;

                if(isFish(i, j)) fishCnt++;
            }
        }

        int result = 0;
        while(fishCnt-- != 0){
            int bfsResult = bfs();

            if(bfsResult == -1) break;

            result += bfsResult;
        }

        System.out.println(result);
    }

    // 상어와 가장 가까이 위치하는 물고기(가장 위, 가장 왼쪽) 찾아 상어 위치 없데이트
    static int bfs() {
        PriorityQueue<Shark> q = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][N];

        q.offer(new Shark(sharkI, sharkJ, 0));
        visited[sharkI][sharkJ] = true;

        while(!q.isEmpty()){
            Shark curr = q.poll();

            if(isFish(curr.i, curr.j) && status(curr.i, curr.j)==2){ // 먹기O + 지나가기O => 상어 위치 업데이트
                map[curr.i][curr.j] = map[sharkI][sharkJ];
                map[sharkI][sharkJ] = 0;

                sharkI = curr.i;
                sharkJ = curr.j;

                if(map[sharkI][sharkJ] == ++eatFishCnt){
                    eatFishCnt = 0;
                    map[sharkI][sharkJ]++;
                }

                return curr.dist;
            }

            for(int d=0; d<4; d++){
                int nI = curr.i + di[d];
                int nJ = curr.j + dj[d];

                if(isValidPos(nI, nJ) && status(nI, nJ)!=0 && !visited[nI][nJ]){
                    visited[nI][nJ] = true;
                    q.offer(new Shark(nI, nJ, curr.dist+1));
                }
            }
        }

        return -1;
    }

    // 0: 지나갈 수 없음, 1: 먹을 수 없지만 지나갈 수 있음, 2: 먹을 수 있고 지나갈 수 있음
    static int status(int i, int j){
        int sharkSize = map[sharkI][sharkJ];
        int fishSize = map[i][j];

        if(sharkSize > fishSize) return 2;

        if(sharkSize == fishSize) return 1;

        return 0;
    }

    static boolean isFish(int i, int j) {
        return map[i][j] >= 1 && map[i][j] <= 6;
    }

    static boolean isValidPos(int i, int j){
        return i>=0 && i<N && j>=0 && j<N;
    }

    static class Shark implements Comparable<Shark> {
        int i;
        int j;
        int dist;

        public Shark(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }

        @Override
        public int compareTo(Shark o){
            if(this.dist == o.dist){
                if(this.i == o.i) return this.j - o.j;
                return this.i - o.i;
            }
            return this.dist - o.dist;
        }
    }
}
