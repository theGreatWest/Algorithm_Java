package DailyCheckUp.Date_25_05_N.D26;

import java.io.*;
import java.util.*;

public class SWEA_2383_모의SW역량테스트_점심식사시간2 {
    static int N, res;
    static int[][] room;
    static List<int[]> person, stair;
    static int[] useStairNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            person = new ArrayList<>();
            stair = new ArrayList<>();
            room = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    room[i][j] = Integer.parseInt(st.nextToken());

                    if (room[i][j] == 1) person.add(new int[]{i, j});
                    else if (room[i][j] > 1) stair.add(new int[]{i, j, room[i][j]});
                }
            }

            // 각 사람이 이용할 계단을 dfs로 완전 탐색 - 백트래킹
            res = Integer.MAX_VALUE;
            useStairNum = new int[person.size()];
            dfs(0);

            sb.append("#").append(t).append(" ").append(++res).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int idx) {
        if (idx == person.size()) {
            lunch();
            return;
        }

        int nextIdx = idx + 1;

        // 0번 계단 선택할 때
        useStairNum[idx] = 0;
        dfs(nextIdx);

        // 1번 계단 선택할 때
        useStairNum[idx] = 1;
        dfs(nextIdx);
    }

    static void lunch() {
        List<Integer> stair0 = new ArrayList<>();
        List<Integer> stair1 = new ArrayList<>();

        for (int i = 0; i < person.size(); i++) {
            int[] p = person.get(i);
            int[] s = stair.get(useStairNum[i]);
            int dist = Math.abs(p[0] - s[0]) + Math.abs(p[1] - s[1]);
            if (useStairNum[i] == 0) stair0.add(dist);
            else stair1.add(dist);
        }

        int len0 = stair.get(0)[2];
        int len1 = stair.get(1)[2];

        Collections.sort(stair0);
        Collections.sort(stair1);

        for (int i = 3; i < stair0.size(); i++) {
            if (stair0.get(i - 3) + len0 > stair0.get(i)) {
                stair0.set(i, stair0.get(i - 3) + len0);
            }
        }

        for (int i = 3; i < stair1.size(); i++) {
            if (stair1.get(i - 3) + len1 > stair1.get(i)) {
                stair1.set(i, stair1.get(i - 3) + len1);
            }
        }

        int end0 = stair0.isEmpty() ? 0 : stair0.get(stair0.size() - 1) + len0;
        int end1 = stair1.isEmpty() ? 0 : stair1.get(stair1.size() - 1) + len1;

        res = Math.min(res, Math.max(end0, end1));
    }
}
