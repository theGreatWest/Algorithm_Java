package DailyCheckUp.Date_25_05_N.D01;

import java.util.*;
import java.io.*;

public class SWEA_3431_준환이의운동관리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int U = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            int res = 0;
            if (X > U) res = -1;
            else if (X < L) res = L - X;

            sb.append("#").append(t).append(" ").append(res).append("\n");
        }

        System.out.print(sb);
    }
}
