package DailyCheckUp.Date_25_05_N.D22;

import java.io.*;

public class SWEA_1986_지그재그숫자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            int res = 0;
            for(int n = 1; n <=N; n++){
                if(n % 2==0) res -= n;
                else res += n;
            }

            sb.append("#").append(t).append(" ").append(res).append("\n");
        }

        System.out.print(sb);
    }
}
