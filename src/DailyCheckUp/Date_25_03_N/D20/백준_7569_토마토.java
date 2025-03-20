package DailyCheckUp.Date_25_03_N.D20;

import java.io.*;
import java.util.*;

public class 백준_7569_토마토 {
    static final int[] dh = {0, 0, 0, 0, -1, 1};
    static final int[] dn = {0, 0, -1, 1, 0, 0};
    static final int[] dm = {-1, 1, 0, 0, 0, 0};

    static int M, N, H, days;
    static int[][][] tomatoes;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = inputs[0];
        N = inputs[1];
        H = inputs[2];

        tomatoes = new int[H][N][M];
        boolean hasZero = false;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for(int m=0; m<M;m++){
                    tomatoes[h][n][m] = tmp[m];
                    if(tmp[m]==1) q.offer(new int[]{h, n, m}); // 처음부터 익은 토마토를 Queue 에 모두 넣어준 후, BFS() 를 시작하는 것이 핵심!!
                    if(tmp[m]==0) hasZero = true;
                }
            }
        }

        if(!hasZero) {
            System.out.println(0);
            return;
        }

        bfs();

        if(checkStatus()){
            System.out.println(-1);
            return;
        }

        System.out.println(--days);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int currH = current[0], currN = current[1], currM = current[2];

            for (int d = 0; d < 6; d++) {
                int nextH = currH + dh[d];
                int nextN = currN + dn[d];
                int nextM = currM + dm[d];

                if (!oor(nextH, nextN, nextM) && tomatoes[nextH][nextN][nextM] == 0) {
                    int nextDepth = tomatoes[currH][currN][currM] + 1;
                    q.offer(new int[]{nextH, nextN, nextM});
                    tomatoes[nextH][nextN][nextM] = nextDepth;
                    days = Math.max(days, nextDepth);
                }
            }
        }
    }

    static boolean checkStatus() {
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if(tomatoes[h][n][m]==0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean oor(int h, int n, int m) {
        return h < 0 || n < 0 || m < 0 || h >= H || n >= N || m >= M;
    }
}
