package DailyCheckUp.Date_25_05_N.D19;

import java.util.*;
import java.io.*;

// 41분 소요
public class SWEA_8382_방향전환 {
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    static int x1, y1, x2, y2;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            x1 = input[0];
            y1 = input[1];
            x2 = input[2];
            y2 = input[3];

            int min = bfs(0);
            min = Math.min(min, bfs(2));

            sb.append("#").append(t).append(" ").append(min).append("\n");
        }

        System.out.print(sb);
    }

    // bfs, dfs를 모두 사용해도 제한시간 초과가 나온다.
    static int bfs(int ds) {
        Queue<Node> q = new LinkedList<>();
        visited = new boolean[202][202];

        visited[x1 + 100][y1 + 100] = true;
        q.offer(new Node(x1, y1, ds, 0));

        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.i == x2 && curr.j == y2) {
                min = Math.min(min, curr.depth);
                continue;
            }

            for (int d = curr.ds; d < curr.ds + 2; d++) {
                int ni = curr.i + dx[d];
                int nj = curr.j + dy[d];

                if (isValidPos(ni, nj) && !visited[ni+100][nj+100]) {
                    visited[ni+100][nj+100] = true;
                    q.offer(new Node(ni, nj, (curr.ds == 0) ? 2 : 0, curr.depth + 1));
                }
            }
        }
        return min;
    }

    static boolean isValidPos(int i, int j) {
        return i >= -100 && i <= 100 && j >= -100 && j <= 100;
    }

    static class Node {
        int i;
        int j;
        int ds;
        int depth;

        public Node(int i, int j, int ds, int depth) {
            this.i = i;
            this.j = j;
            this.ds = ds;
            this.depth = depth;
        }
    }
}
