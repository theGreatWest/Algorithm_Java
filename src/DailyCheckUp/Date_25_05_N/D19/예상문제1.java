package DailyCheckUp.Date_25_05_N.D19;

import java.io.*;

public class 예상문제1 {
    static int N, snack, totSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 1;
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            totSum = ((N + 1) * N) / 2;
            snack = Integer.parseInt(br.readLine());

            int round = 1;
            boolean end = false;
            while (!end) {
                if (snack >= totSum) {
                    snack -= totSum;
                    round++;
                    continue;
                }

                int s = 1, e = N, step = 1;
                if (round++ % 2 == 0) {
                    s = N;
                    e = 1;
                    step = -1;
                }

                for (int i = s; i != e + step; i += step) {
                    int nextV = snack - i;
                    if (nextV >= 0) {
                        snack = nextV;
                    } else {
                        end = true;
                        break;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(snack).append("\n");
        }

        System.out.print(sb);
    }
}
