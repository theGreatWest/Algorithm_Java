package DailyCheckUp.Date_25_04_N.D27;

import java.io.*;
import java.util.*;

public class SWEA_모의SW역량테스트_보호필름 {
    static int D, W, K, res;
    static int[][] film;
    static boolean find;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            film = new int[D][W];
            for (int i = 0; i < D; i++) { // A: 0, B: 1
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }

//            bfs();

            res = Integer.MAX_VALUE;
            find = false;
            dfs(0, 0);

            sb.append("#").append(t).append(" ").append(res).append("\n");
        }

        System.out.print(sb);
    }

    static boolean isPass(int[][] film) {
        for (int j = 0; j < W; j++) {
            int[] dp = new int[D];
            dp[0] = 1;
            int max = 0;
            for (int i = 1; i < D; i++) {
                dp[i] = (film[i][j] == film[i - 1][j]) ? dp[i - 1] + 1 : 1;
                max = Math.max(max, dp[i]);
            }
            if (max < K) {
                return false;
            }
        }
        return true;
    }

    static int[][] deepCopy(int[][] arr){
        int[][] res = new int[D][];
        for(int i=0;i<D;i++){
            res[i] = arr[i].clone();
        }
        return res;
    }

    static void change(int i, int value, int[][] arr){
        for(int j=0; j<W; j++){
            arr[i][j] = value;
        }
    }

    // 메모리 초과
    static void bfs(){
        Queue<Tmp> q = new LinkedList<>();
        q.offer(new Tmp(film, 0));

        while(!q.isEmpty()){
            Tmp tmp = q.poll();

            if(isPass(tmp.film)){
                res = tmp.depth;
                return;
            }

            for(int i=0;i<D;i++){
                for(int value=0; value<=1; value++){
                    int[][] tmpArr = deepCopy(tmp.film);
                    change(i, value, tmpArr);
                    q.offer(new Tmp(tmpArr, tmp.depth+1));
                }
            }
        }
    }

    static void dfs(int row, int cnt){
        if(cnt >= res) return;

        if(row==D) {
            if(isPass(film)) res = cnt;
            return;
        }

        dfs(row+1, cnt); // 아무것도 안 바꾸고 진행

        int[] origin = film[row].clone();

        Arrays.fill(film[row], 0);  // 해당 줄을 전부 0으로 바꾸고 진행
        dfs(row+1, cnt+1);

        Arrays.fill(film[row], 1); // 해당 줄을 전부 1로 바꾸고 진행
        dfs(row+1, cnt+1);

        film[row] = origin; // 복구
    }

    static class Tmp {
        int[][] film;
        int depth;

        public Tmp(int[][] film, int depth) {
            this.film = film;
            this.depth = depth;
        }
    }
}
