package DailyCheckUp.Date_25_02_18;

import java.util.*;
import java.io.*;

public class 백준_14500_테트로미노 {
    static final int[] di = {0, 1, -1, 0};
    static final int[] dj = {1, 0, 0, -1};

    static int n, m, res = 0;
    static int[][] arr;
    static boolean[][] visited;
    static int[] values= new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(0, i, j);
                checkTSpin(i, j);
            }
        }

        System.out.println(res);
    }

    static void dfs(int depth, int currI, int currJ) {
        if (depth == 4) {
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                sum += values[i];
            }
            res = Math.max(sum, res);
            return;
        }

        values[depth] = arr[currI][currJ];

        visited[currI][currJ] = true;

        for (int d = 0; d < 4; d++) {
            int nextI = currI + di[d];
            int nextJ = currJ + dj[d];

            if (!isOutOfRange(nextI, nextJ) && !visited[nextI][nextJ]) {
                dfs(depth + 1, nextI, nextJ);
            }
        }

        visited[currI][currJ] = false; // 백트래킹
    }

    static void dfs_reference(int depth, int currI, int currJ){
        // 4칸을 모두 선택한 경우, 최댓값 업데이트 후 종료
        if (depth == 4) {
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                sum += values[i];
            }
            res = Math.max(sum, res);
            return;
        }

        // 상하좌우 네 방향 탐색
        for (int d = 0; d < 4; d++) {
            int nx = currI + di[d];
            int ny = currJ + dj[d];

            // 배열 범위를 벗어나거나 이미 방문한 경우 건너뛰기
            if(isOutOfRange(nx, ny) || visited[nx][ny]) continue;

            visited[nx][ny] = true;

            // 'ㅗ', 'ㅜ', 'ㅏ', 'ㅓ' 모양을 만들기 위한 추가 탐색
            // 와... 대박...
            if (depth == 2) {
                // 현재 좌표에서 한 번 더 탐색하여 갈림길을 만듦
                // 현재 좌표에서 두 칸을 찾는 것!
                // 대박...!!
                dfs(currI, currJ, depth + 1);
            }

            // 기본 DFS 탐색 (4칸을 선택할 때까지 진행)
            dfs(nx, ny, depth + 1);

            // 백트래킹 (다음 경우의 수를 위해 방문 해제)
            visited[nx][ny] = false;
        }
    }

    static void checkTSpin(int i, int j){
        // T-모양 처리 (ㅗ, ㅏ, ㅜ, ㅓ)
        int[][] tShapes = {
                {0, -1, 0, 1, 1, 0},  // ㅗ
                {0, -1, 0, 1, -1, 0}, // ㅜ
                {-1, 0, 1, 0, 0, -1}, // ㅏ
                {-1, 0, 1, 0, 0, 1}   // ㅓ
        };

        for (int[] shape : tShapes) {
            int sum = arr[i][j];

            boolean valid = true;
            for (int d = 0; d < 3; d++) {
                int ni = i + shape[d * 2];
                int nj = j + shape[d * 2 + 1];

                if (isOutOfRange(ni, nj)) {
                    valid = false;
                    break;
                }

                sum += arr[ni][nj];
            }

            if (valid) res = Math.max(res, sum);
        }
    }

    static boolean isOutOfRange(int i, int j) {
        return i < 0 || j < 0 || i >= n || j >= m;
    }
}
