package DailyCheckUp.Date_25_04_N.D23;

import java.util.*;
import java.io.*;

public class SWEA_5656_모의SW역량테스트_벽돌깨기 {
    static int[] di = {-1, 0, 1, 0}; // 상우하좌
    static int[] dj = {0, 1, 0, -1};

    static int N, W, H;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            int[][] arr = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 시작점을 정하는 것이 중요
            min = Integer.MAX_VALUE;
            dfs(0, arr);

            sb.append("#").append(t).append(" ").append((min==Integer.MAX_VALUE)?0:min).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int n, int[][] arr) {
        if (n == N) {
            min = Math.min(min, countBricks(arr));
            return;
        }

        for (int[] startIdx : findStartIdxs(arr)) {
            int[][] tmp = copyArr(arr);
            shoot(startIdx[0], startIdx[1], tmp);
            setting(tmp);
            dfs(n+1, tmp);
        }
    }

    static void shoot(int i, int j, int[][] arr) {
        int currValue = arr[i][j];

        arr[i][j] = 0;

        if (currValue == 1) return;

        for (int d = 0; d < 4; d++) {
            for (int len = 1; len < currValue; len++) {
                int ni = i + di[d] * len;
                int nj = j + dj[d] * len;

                if (!oor(ni, nj) && arr[ni][nj] > 0) {
                    shoot(ni, nj, arr);
                }
            }
        }
    }

    static void setting(int[][] arr) {
        Queue<Integer> q;
        for (int j = 0; j < W; j++) {
            q = new LinkedList<>();
            for (int i = H - 1; i >= 0; i--) {
                if (arr[i][j] != 0) {
                    q.offer(arr[i][j]);
                    arr[i][j] = 0;
                }
            }
            int i = H - 1;
            while (!q.isEmpty()) {
                arr[i--][j] = q.poll();
            }
        }
    }

    static boolean oor(int i, int j) {
        return i >= H || j >= W || i < 0 || j < 0;
    }

    static int[][] copyArr(int[][] arr) {
        int[][] newArr = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i].clone();
        }
        return newArr;
    }

    static int countBricks(int[][] arr) {
        int cnt = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (arr[i][j] > 0) cnt++;
            }
        }
        return cnt;
    }

    static ArrayList<int[]> findStartIdxs(int[][] arr) {
        ArrayList<int[]> startIdxs = new ArrayList<>();
        for (int j = 0; j < W; j++) {
            for (int i = 0; i < H; i++) {
                if (arr[i][j] > 0) {
                    startIdxs.add(new int[]{i, j});
                    break;
                }
            }
        }
        return startIdxs;
    }

    static void print(int[][] arr) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}