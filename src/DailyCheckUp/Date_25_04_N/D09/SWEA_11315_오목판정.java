package DailyCheckUp.Date_25_04_N.D09;

import java.util.*;
import java.io.*;

public class SWEA_11315_오목판정 {
    static final int[][] di = {{0,0}, {-1,1}, {-1,1}, {-1,1}}; // 가로, 세로, 슬래쉬, 백슬래쉬
    static final int[][] dj = {{-1,1}, {0,0}, {1,-1}, {-1,1}};

    static int n, cnt;
    static int[][] arr;
    static boolean[][] visited;
    static boolean find;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            for(int i=0;i<n;i++){
                String[] tmp = br.readLine().split("");
                for(int j=0;j<n;j++){
                    arr[i][j] = (tmp[j].equals(".")) ? 0 : 1;
                }
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(arr[i][j]==1){
                        // DFS 를 이용한 양방향 재귀호출은 오히려 불필요한 방문, 호출, 복잡도가 있다.
                        for(int d=0;d<4;d++){
                            visited = new boolean[n][n];
                            visited[i][j] = true;
                            find = false;
                            cnt = 1;

                            dfs(i, j, d); // x좌표, y좌표, 방향

                            if(find) break;
                        }
                    }
                    if(find) break;
                }
                if(find) break;
            }

            sb.append("#").append(t).append(" ").append((find) ? "YES" : "NO").append("\n");
            find = false;
        }

        System.out.print(sb);
    }

    static void dfs(int i, int j, int d){
        if(cnt==5) {
            find = true;
            return;
        }

        for(int dd=0; dd<=1; dd++){ // 아.. 방문한 곳 또 들릴 수도..?
            int nextI1 = i + di[d][dd], nextJ1 = j + dj[d][dd];
            if(!oor(nextI1, nextJ1) && arr[nextI1][nextJ1]==1 && !visited[nextI1][nextJ1]) {
                cnt++;
                visited[nextI1][nextJ1] = true;
                dfs(nextI1, nextJ1, d);
            }
        }
    }

    static boolean oor(int i, int j){
        return i<0 || j<0 || i>=n || j>=n;
    }
}
