package DailyCheckUp.Date_25_05_N.D12;

import java.util.*;
import java.io.*;

public class SWEA_1953_모의SW역량테스트_탈주범검거 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N, M, R, C, L;
    static int[][] map;
    static Map<Integer, int[]> ds = new HashMap<>();
    static {
        ds.put(1, new int[]{0, 1, 2, 3});
        ds.put(2, new int[]{0, 1});
        ds.put(3, new int[]{2, 3});
        ds.put(4, new int[]{0, 3});
        ds.put(5, new int[]{1, 3});
        ds.put(6, new int[]{1, 2});
        ds.put(7, new int[]{0, 2});
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken()); // 뚜껑 x
            C = Integer.parseInt(st.nextToken()); // 뚜껑 y
            L = Integer.parseInt(st.nextToken()); // 소요시간

            map = new int[N][M];
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    map[n][m] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("#").append(t).append(" ").append(bfs()).append("\n");
        }

        System.out.print(sb);
    }

    static int bfs() {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();

        visited[R][C] = true;
        q.offer(new int[]{R, C, 1}); // (R, C)위치에 도달하기까지 1시간 소요

        int res = 0;
        while (!q.isEmpty()) {
            int[] currPosition = q.poll();

            res++;

            if (currPosition[2] >= L) continue;

            for (int d : ds.get(map[currPosition[0]][currPosition[1]])) {
                int nx = currPosition[0] + dx[d];
                int ny = currPosition[1] + dy[d];

                if (isValidPos(nx, ny) && map[nx][ny] != 0 && !visited[nx][ny]) {
                    if (canConnect(d, map[nx][ny])) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny, currPosition[2] + 1});
                    }
                }
            }
        }

        return res;
    }

    static boolean canConnect(int d, int nextD) {
        int[] opposite = {1, 0, 3, 2}; // 반대 방향

        for(int nd : ds.get(nextD)){
            if(nd == opposite[d]) return true; // -->(받는 방향)  /  <--(진행 방향)
        }

        return false;

//        if (d == 0) {
//            return nextD != 3 && nextD != 4 && nextD != 7;
//        } else if (d == 1) {
//            return nextD != 3 && nextD != 5 && nextD != 6;
//        } else if (d == 2) {
//            return nextD != 2 && nextD != 6 && nextD != 7;
//        }else{
//            return nextD != 2 && nextD != 4 && nextD != 5;
//        }
    }

    static boolean isValidPos(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < M;
    }
}
