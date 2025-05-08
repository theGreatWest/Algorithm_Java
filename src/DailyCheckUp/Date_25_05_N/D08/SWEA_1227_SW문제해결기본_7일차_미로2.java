package DailyCheckUp.Date_25_05_N.D08;

import java.util.*;
import java.io.*;

public class SWEA_1227_SW문제해결기본_7일차_미로2 {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    static int[][] map;
    static boolean find;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 10;
        for (int tc = 1; tc <= T; tc++) {
            int t = Integer.parseInt(br.readLine());

            // 1: 벽, 0:길, 2: 출발점, 3:도착점
            map = new int[100][100];
            int x = 0, y = 0;
            for (int i = 0; i < 100; i++) {
                String input = br.readLine();
                for (int j = 0; j < 100; j++) {
                    map[i][j] = input.charAt(j) - '0';
                    if (map[i][j] == 2) {
                        x = i;
                        y = j;
                    }
                }
            }

//            sb.append("#").append(t).append(" ").append((bfs(x, y) ? 1 : 0)).append("\n");

            find = false;
            map[x][y] = 1;
            dfs(x, y);

            sb.append("#").append(t).append(" ").append((find) ? 1 : 0).append("\n");
        }

        System.out.print(sb);
    }

    static boolean bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = curr[0] + dx[d];
                int ny = curr[1] + dy[d];

                if (isValidPosition(nx, ny) && map[nx][ny] != 1) {
                    if (map[nx][ny] == 3) return true;
                    map[nx][ny] = 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return false;
    }

    static void dfs(int i, int j) {
        if (find) return;

        for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];

            if (isValidPosition(nx, ny) && map[nx][ny]!=1) {
                if(map[nx][ny]==3) {
                    find = true;
                    return;
                }

                map[i][j] = 1;
                dfs(nx, ny);
            }
        }
    }

    static boolean isValidPosition(int i, int j) {
        return i >= 0 && i < 100 && j >= 0 && j < 100;
    }
}
