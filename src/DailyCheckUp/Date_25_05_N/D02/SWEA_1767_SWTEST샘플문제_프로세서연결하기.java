package DailyCheckUp.Date_25_05_N.D02;

import java.io.*;
import java.util.*;

public class SWEA_1767_SWTEST샘플문제_프로세서연결하기 {
    static final int[] di = {-1, 0, 1, 0};
    static final int[] dj = {0, 1, 0, -1};

    static int N, minLength, maxCoreNum;
    static int[][] cell;
    static List<int[]> unConnectedCores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine().trim());

            cell = new int[N][N];
            unConnectedCores = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cell[i][j] = Integer.parseInt(st.nextToken());
                    // core 인데 전원과 연결이 되지 않은 경우 list에 넣기
                    if (cell[i][j] == 1 && !isConnected(i, j)) unConnectedCores.add(new int[]{i, j});
                }
            }

            minLength = Integer.MAX_VALUE;
            maxCoreNum = 0;
            dfs(0, 0, 0);

            sb.append("#").append(t).append(" ").append((minLength == Integer.MAX_VALUE) ? 0 : minLength).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int coreNum, int length, int connectNum) {
        if (coreNum == unConnectedCores.size()) {
            if(connectNum < maxCoreNum) return;

            if(connectNum > maxCoreNum){
                maxCoreNum = connectNum; // 최대한 많은 core를 연결해야 한다고 했으므로 MinLength 를 초기화해준다.
                minLength = length;
            }else minLength = Math.min(minLength, length); // 최대 연결 개수가 같다면, 가장 길이가 짧은 것을 minLength 로 바꿔준다.
            return;
        }

        int coreI = unConnectedCores.get(coreNum)[0];
        int coreJ = unConnectedCores.get(coreNum)[1];

        for (int d = 0; d < 4; d++) {
            if (isConnectableToPower(coreI, coreJ, d)) {
                int cnt = connectAndDisconnect(coreI, coreJ, d, true);
                dfs(coreNum + 1, length + cnt, connectNum + 1);
                connectAndDisconnect(coreI, coreJ, d, false);
            }
        }

        dfs(coreNum+1, length, connectNum);
    }

    // 해당 core가 이미 연결된 core일 경우 true를 반환
    static boolean isConnected(int i, int j) {
        int lastIdx = N - 1;
        return i == 0 || j == 0 || i == lastIdx || j == lastIdx;
    }

    // 범위를 벗어나면 true 반환
    static boolean ior(int i, int j) {
        return i < 0 || j < 0 || i >= N || j >= N;
    }

    // 해당 방향으로 쭉 갔을 때 전원과 연결 가능한지 판단
    static boolean isConnectableToPower(int coreI, int coreJ, int d) {
        int x = coreI;
        int y = coreJ;

        while (true) {
            x += di[d];
            y += dj[d];

            if (ior(x, y)) return true;
            if (cell[x][y] == 1) return false;
        }
    }

    // 해당 방향으로 전원 연결 및 해제
    // true: 전원 연결
    // false: 전원 해제
    static int connectAndDisconnect(int coreI, int coreJ, int d, boolean order) {
        int x = coreI + di[d];
        int y = coreJ + dj[d];

        int cnt = 0;
        while (!ior(x, y)) {
            cell[x][y] = (order) ? 1 : 0;
            cnt++;

            x += di[d];
            y += dj[d];
        }

        return cnt;
    }
}
