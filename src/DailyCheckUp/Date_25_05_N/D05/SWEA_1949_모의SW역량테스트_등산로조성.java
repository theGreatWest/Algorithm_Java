package DailyCheckUp.Date_25_05_N.D05;

import java.util.*;
import java.io.*;

public class SWEA_1949_모의SW역량테스트_등산로조성 {
    static final int[] di = {-1, 0, 1, 0};
    static final int[] dj = {0, 1, 0, -1};

    static int N, K, maxLen;
    static int[][] mountain;
    //    static List<int[]> tops;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            mountain = new int[N][N];
//            tops = new ArrayList<>();
            int max = -1;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    mountain[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, mountain[i][j]);

//                    if (mountain[i][j] > max) {
//                        tops.clear();
//                        tops.add(new int[]{i, j});
//                        max = mountain[i][j];
//                    } else if (mountain[i][j] == max) {
//                        tops.add(new int[]{i, j});
//                    }
                }
            }

            maxLen = -1;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (mountain[i][j] == max) {
                        visited[i][j] = true;
                        dfs(i, j, 1, false);
                        visited[i][j] = false;
                    }
                }
            }
//            for (int[] top : tops) {
//                visited[top[0]][top[1]] = true;
//                dfs(top[0], top[1], 1, false);
//                visited[top[0]][top[1]] = false;
//            }

            sb.append("#").append(t).append(" ").append(maxLen).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int i, int j, int len, boolean cut) {
        maxLen = Math.max(maxLen, len);

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if (isValidPosition(ni, nj) && !visited[ni][nj]) {
                // 해당 지형을 K 범위 내에서 깎았을 때(cut이 false 일 때만 가능하고, 깎은 뒤 true로 변경)
                if (!cut) {
                    for (int k = 1; k <= K; k++) {
                        int nH = mountain[ni][nj] - k;

                        if (nH < 0) break;

                        if (nH < mountain[i][j]) {
                            mountain[ni][nj] -= k;
                            visited[ni][nj] = true;
                            dfs(ni, nj, len + 1, true);
                            visited[ni][nj] = false;
                            mountain[ni][nj] += k;
                        }
                    }
                }

                // 해당 지형을 깎지 않았을 때
                if (mountain[ni][nj] < mountain[i][j]) {
                    visited[ni][nj] = true;
                    dfs(ni, nj, len + 1, cut);
                    visited[ni][nj] = false;
                }
            }
        }
    }

    static boolean isValidPosition(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < N;
    }
}
