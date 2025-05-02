package DailyCheckUp.Date_25_05_N.D02;

import java.util.*;
import java.io.*;

public class SWEA_3499_퍼팩트셔플 {
    static int N;
    static String[] cardName;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            cardName = br.readLine().split(" ");

            int mid = N / 2;
            int q1Len = (N % 2 == 0) ? mid : mid + 1;
            Queue<String> q1 = new LinkedList<>();
            for (int i = 0; i < q1Len; i++) {
                q1.offer(cardName[i]);
            }
            Queue<String> q2 = new LinkedList<>();
            for (int j = q1Len; j < N; j++) {
                q2.offer(cardName[j]);
            }

            StringBuilder res = new StringBuilder();
            for (int i = 0; i < N; i++) {
                res.append((i % 2 == 0) ? q1.poll() : q2.poll()).append(" ");
            }
            sb.append("#").append(t).append(" ").append(res).append("\n");
        }

        System.out.print(sb);
    }
}
