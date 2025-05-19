package DailyCheckUp.Date_25_05_N.D19;

import java.util.*;
import java.io.*;

public class SWEA_2105_모의SW역량테스트_디저트카페 {
    static final int[] di = {-1, 1, 1, -1};
    static final int[] dj = {1, 1, -1, -1};

    static int N, max, x, y;
    static int[][] cafes;
    static Set<Integer> selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine().trim());
            cafes = new int[N][N];
            for (int i = 0; i < N; i++) {
                cafes[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            max = -1;
            selected = new HashSet<>();
            for (int i = 1; i < N - 1; i++) {
                for (int j = 0; j < N - 1; j++) {
                    x = i;
                    y = j;
                    selected.add(cafes[x][y]);
                    dfs(i, j, 0);
                    selected.remove(cafes[x][y]);
                }
            }

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int i, int j, int d) {
        for (int nd : new int[]{d, d + 1}) {
            if (nd > 3) return;

            int ni = i + di[nd];
            int nj = j + dj[nd];

            if(ni==x && nj==y) {
                max = Math.max(max, selected.size());
                return;
            }

            if (isValidPos(ni, nj)) {
                int value = cafes[ni][nj];
                if(!selected.contains(value)){
                    selected.add(value);
                    dfs(ni, nj, nd);
                    selected.remove(value);
                }
            }
        }
    }

    static boolean isValidPos(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < N;
    }
}
