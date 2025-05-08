package DailyCheckUp.Date_25_05_N.D08;

import java.util.*;
import java.io.*;

public class SWEA_1284_수도요금경쟁 {
    static int P, Q, R, S, W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            // A사 : 1L 당 P원의 돈
            // B사 : 기본요금 Q원, R리터 이하인 경우 요금은 기본 요금만
            // 초과할 경우 초과량에 대해서 1L 당 S원
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            P = inputs[0];
            Q = inputs[1];
            R = inputs[2];
            S = inputs[3];
            W = inputs[4];

            int a = W * P;
            int b = Q + (Math.max(W - R, 0) * S);

            sb.append("#").append(t).append(" ").append(Math.min(a, b)).append("\n");
        }

        System.out.print(sb);
    }
}
