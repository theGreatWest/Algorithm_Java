package DailyCheckUp.Date_25_04_N;

import java.io.*;
import java.util.*;

public class SWEA_5215_햄버거다이어트 {
    static int resourceNum, limitKcal, maxScore = -1;
    static int[] score, kcal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            resourceNum = Integer.parseInt(st.nextToken()); // 재료 개수
            limitKcal = Integer.parseInt(st.nextToken()); // 제한 칼로리

            score = new int[resourceNum];
            kcal = new int[resourceNum];

            for (int i = 0; i < resourceNum; i++) {
                st = new StringTokenizer(br.readLine());
                score[i] = Integer.parseInt(st.nextToken());
                kcal[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0, 0); // DFS 탐색 시작

            sb.append("#").append(t).append(" ").append(maxScore).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int idx, int totScore, int totKcal) {
        if (totKcal > limitKcal) return;

        if (idx == resourceNum) {
            maxScore = Math.max(maxScore, totScore);
            return;
        }

        // 지금 재료(idx) 를 포함할 때
        dfs(idx + 1, totScore + score[idx], totKcal + kcal[idx]);

        // 지금 재료(idx) 를 포함하지 않고, 다음 재료로 넘어갈 때
        dfs(idx + 1, totScore, totKcal);
    }
}