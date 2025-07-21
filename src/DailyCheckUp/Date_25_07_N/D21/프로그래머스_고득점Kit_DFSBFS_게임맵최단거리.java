package DailyCheckUp.Date_25_07_N.D21;

import java.util.*;

public class 프로그래머스_고득점Kit_DFSBFS_게임맵최단거리 {
    public int main(int[][] maps) {
        int n = maps.length, m = maps[0].length, res = Integer.MAX_VALUE;
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};

        boolean[][] visited = new boolean[n][m];
        Queue<Position> q = new LinkedList<>();
        visited[0][0] = true;
        q.offer(new Position(0, 0, 1));
        while (!q.isEmpty()) {
            Position currPos = q.poll();

            if (currPos.i == n - 1 && currPos.j == m - 1) {
                res = Math.min(currPos.cnt, res);
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nextI = currPos.i + di[d];
                int nextJ = currPos.j + dj[d];

                if (isValid(nextI, nextJ, n, m, visited, maps)) {
                    visited[nextI][nextJ] = true;
                    q.offer(new Position(nextI, nextJ, currPos.cnt + 1));
                }
            }
        }

        return (res == Integer.MAX_VALUE) ? -1 : res;
    }


    boolean isValid(int i, int j, int n, int m, boolean[][] visited, int[][] maps) {
        return i >= 0 && j >= 0 && i < n && j < m && maps[i][j] == 1 && !visited[i][j];
    }

    class Position {
        int i;
        int j;
        int cnt;

        public Position(int i, int j, int cnt) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }
    }
}
