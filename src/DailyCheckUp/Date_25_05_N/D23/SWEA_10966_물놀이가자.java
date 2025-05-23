package DailyCheckUp.Date_25_05_N.D23;

import java.util.*;
import java.io.*;

public class SWEA_10966_물놀이가자 {
    static final int[] dx = {-1,0,1,0};
    static final int[] dy = {0,1,0,-1};

    static int N, M;
    static char[][] pool;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            pool = new char[N][M];
            Queue<int[]> q = new LinkedList<>();
            for(int i=0;i<N;i++){
                String input = br.readLine();
                for(int j=0;j<M;j++){
                    pool[i][j] = input.charAt(j);
                    // 최단거리 + BFS 일 때
                    // 시작점을 모두 Queue 에 미리 넣어주는 아이디어!
                    if(pool[i][j]=='W') q.offer(new int[]{i, j, 0});
                }
            }

            dp = new int[N][M];
            bfs(q);

            int res = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(pool[i][j]=='L') res += dp[i][j];
                }
            }
            sb.append("#").append(t).append(" ").append(res).append("\n");
        }

        System.out.print(sb);
    }

    static void bfs(Queue<int[]> q){
        boolean[][] visited = new boolean[N][M];

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int depth = curr[2];

            visited[x][y] = true;
            dp[x][y] = depth;

            for(int d=0;d<4;d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(isValidPos(nx, ny) && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, depth +1});
                }
            }
        }
    }

    static boolean isValidPos(int i, int j){
        return i>=0 && i<N && j>=0 && j<M;
    }
}
