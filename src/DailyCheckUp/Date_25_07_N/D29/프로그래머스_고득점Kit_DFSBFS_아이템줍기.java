package DailyCheckUp.Date_25_07_N.D29;

import java.util.*;

public class 프로그래머스_고득점Kit_DFSBFS_아이템줍기 {
    static final int MAXSIZE = 102; // 좌표 확장하므로 최대*2
    static final int[] dx = {-1,0,1,0};
    static final int[] dy = {0,1,0,-1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[MAXSIZE][MAXSIZE];

        // 모서리가 인접한 경우 에러 발생
        // 좌표를 2배 확장해야
        for (int[] rec : rectangle) {
            int fx = rec[0] * 2, fy = rec[1] * 2;
            int tx = rec[2] * 2, ty = rec[3] * 2;

            for (int i = fx; i <= tx; i++) {
                for (int j = fy; j <= ty; j++) {
                    if(map[i][j] == 1) continue;

                    if(i==fx || i==tx || j==fy || j==ty) map[i][j] = 2;
                    else map[i][j] = 1;
                }
            }
        }

        return bfs(map, characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }

    boolean isValid(int x, int y) {
        return x >= 0 && x < MAXSIZE && y >= 0 && y < MAXSIZE;
    }

    int bfs(int[][] map, int sx, int sy, int ex, int ey) {
        boolean[][] visited = new boolean[MAXSIZE][MAXSIZE];
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(sx, sy, 0));
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.x == ex && curr.y == ey) return curr.dist/2;

            for (int d = 0; d < 4; d++) {
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];

                if (isValid(nx, ny) && map[nx][ny] == 2 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny, curr.dist + 1));
                }
            }
        }
        return -1;
    }

    class Node {
        int x, y, dist;

        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
