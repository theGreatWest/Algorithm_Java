package DailyCheckUp.Date_25_05_N.D05;

import java.io.*;
import java.util.*;

public class SWEA_1226_미로1 {
    static final int[] di = {-1, 0, 1, 0};
    static final int[] dj = {0, 1, 0, -1};

    static int[][] map;
    static int[] start;
    static boolean can;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 1;
        for (int t = 1; t <= T; t++) {
            br.readLine();

            map = new int[16][16];
            start = new int[2];
            for (int i = 0; i < 16; i++) {
                String input = br.readLine();
                for (int j = 0; j < 16; j++) {
                    map[i][j] = input.charAt(j) - '0';
                    if (map[i][j] == 2) {
                        start[0] = i;
                        start[1] = j;
                    }
                }
            }

//            can = false;
//            dfs(start[0], start[1]);

//            sb.append("#").append(t).append(" ").append((can) ? 1 : 0).append("\n");
            sb.append("#").append(t).append(" ").append(bfs(start[0], start[1])).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int i, int j) {
        if (can) return;

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if (isValidPosition(ni, nj)) {
                if (map[ni][nj] == 3) {
                    can = true;
                    return;
                }

                if (map[ni][nj] == 0) {
                    map[ni][nj] = 1;
                    dfs(ni, nj);
                }
            }
        }
    }

    // 최단 경로 찾기 || 도달 여부 확인은 BFS가 효율적이다.
    static int bfs(int i, int j) {
        boolean[][] visited = new boolean[16][16];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int d = 0; d < 4; d++) {
                int ni = curr[0] + di[d];
                int nj = curr[1] + dj[d];

                if (isValidPosition(ni, nj) && !visited[ni][nj]) {
                    if(map[ni][nj]==0){
                        visited[ni][nj] = true;
                        q.offer(new int[]{ni, nj});
                    }else if(map[ni][nj]==3) return 1;
                }
            }
        }

        return 0;
    }

    static boolean isValidPosition(int i, int j) {
        return i >= 0 && i < 16 && j >= 0 && j < 16;
    }
}
