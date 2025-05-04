package DailyCheckUp.Date_25_05_N.D04;

import java.util.*;
import java.io.*;

public class SWEA_1861_정사각형방_DFS_DP {
    static final int[] di = {-1, 0, 1, 0};
    static final int[] dj = {0, 1, 0, -1};

    static int N;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            visited = new boolean[N][N]; // 해당 노드에서 시작했을 때 이동 가능한 방의 개수 저장

            int max = -1, room = -1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int tmp = dfs(i, j, 1);

                        if(tmp > max){
                            max = tmp;
                            room = arr[i][j];
                        }else if(tmp==max) room = Math.min(room, arr[i][j]);
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(room).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }

    static int dfs(int i, int j, int cnt) {
        visited[i][j] = true;

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if (!ior(ni, nj) && isMove(ni, nj, i, j)) {
                return dfs(ni, nj, cnt + 1);
            }
        }

        return cnt;
    }

    static boolean ior(int i, int j) {
        return i < 0 || j < 0 || i >= N || j >= N;
    }

    static boolean isMove(int ni, int nj, int i, int j) {
        return arr[ni][nj] == arr[i][j] + 1;
    }
}
