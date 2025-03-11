package DailyCheckUp.Date_25_02_N.D12;

import java.io.*;

public class 백준_10026_적록색약 {
    static int n;
    static String[][] arr;
    static boolean[][] visited;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new String[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = input.substring(j, j + 1);
            }
        }

        visited = new boolean[n][n];

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    cnt++;
                    dfs(i, j, false);
                }
            }
        }
        bw.write(cnt+" ");

        cnt = 0;
        visited = new boolean[n][n  ];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    cnt++;
                    dfs(i, j, true);
                }
            }
        }
        bw.write(cnt+" ");
        bw.flush();
        bw.close();
    }

    static void dfs(int i, int j, boolean blind) {
        if (visited[i][j]) return;

        visited[i][j] = true;

        for (int dist = 0; dist < 4; dist++) {
            int x = i + dx[dist];
            int y = j + dy[dist];
            if (!isOutOfRange(x, y) && !visited[x][y]) {
                if (blind) {
                    if ((arr[i][j].equals("R") || arr[i][j].equals("G")) && (arr[x][y].equals("R") || arr[x][y].equals("G"))) dfs(x, y, true);
                    else if (arr[i][j].equals(arr[x][y])) dfs(x, y, true);
                } else {
                    if (arr[i][j].equals(arr[x][y])) dfs(x, y, false);
                }
            }
        }
    }

    static boolean isOutOfRange(int i, int j) {
        return i < 0 || j < 0 || i >= n || j >= n;
    }
}
