package DailyCheckUp.Date_25_05_N.D16;

import java.util.*;
import java.io.*;

public class SWEA_1211_SW문제해결기본_2일차_Ladder2 {
    static final int[] dx = {0, 0, 1};
    static final int[] dy = {-1, 1, 0};
    static final int N = 100;

    static int[][] ladder;
    static int minValue, minIdx;
    static boolean update;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 1; t++) {
            br.readLine();

            List<Integer> js = new ArrayList<>();
            ladder = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    if (i == 0 && value == 1) js.add(j);
                    ladder[i][j] = value;
                }
            }

            minValue = Integer.MAX_VALUE;
            visited = new boolean[N][N];
            int i = 0;
            for (int j : js) {
                update = false;
                dfs(0, j, 0);
                if (update) minIdx = j;
            }

            sb.append("#").append(t).append(" ").append(minIdx).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int x, int y, int len) {
        if (len > minValue) return;

        if (x == N - 1) {
            if (len < minValue) {
                minValue = len;
                update = true;
            }
            return;
        }

        boolean branch = false;
        for (int d = 0; d < 3; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (isValidPos(nx, ny) && ladder[nx][ny] == 1) {
                branch = true;
                ladder[nx][ny] = 0;
                dfs(nx, ny, len + 1);
                ladder[nx][ny] = 1;
            }

            if(branch) break;
        }
    }

    static boolean isValidPos(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < N;
    }
}
