package 탐색.BFS;

import java.io.*;
import java.util.*;

public class 백준_2178_미로탐색 {
    static int[][] arr;
    static boolean[][] visited;
    static int n, m;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            int idx = 0;
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(tmp[idx++]);
            }
        }

        visited = new boolean[n][m];

        br.close();

        // process
        BFS(0, 0);


        // output
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(arr[n - 1][m - 1] + "\n");
        bw.flush();
        bw.close();
    }

    static void BFS(int sN, int eN) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{sN, eN});
        visited[sN][eN] = true;

        while (!q.isEmpty()) {
            int[] nowIdx = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int xNextIdx = nowIdx[0] + dx[dir];
                int yNextIdx = nowIdx[1] + dy[dir];
                if (!indexOutOfRange(xNextIdx, yNextIdx)) { // 좌표 범위 검사
                    if (arr[xNextIdx][yNextIdx] == 1 && !visited[xNextIdx][yNextIdx]) { // 갈 수 있는 칸, 방문 여부 검사하기
                        visited[xNextIdx][yNextIdx] = true;
                        arr[xNextIdx][yNextIdx] = arr[nowIdx[0]][nowIdx[1]] + 1; // 깊이 업데이트하기
                        q.offer(new int[]{xNextIdx, yNextIdx});
                    }
                }
            }
        }
    }

    static boolean indexOutOfRange(int i, int j) {
        return i < 0 || i >= n || j < 0 || j >= m;
    }

    static void printarr() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------  ");
    }
}
