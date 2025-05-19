package DailyCheckUp.Date_25_05_N.D19;

import java.util.*;
import java.io.*;

public class 예상문제2 {
    static int N, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 1;
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            D = Integer.parseInt(br.readLine());

            sb.append("#").append(t).append(" ");
            for (int s = 1; s < N; s++) {
                int rest = N, readLine = s;

                while(readLine!=0 && rest!=0){
                    rest -= readLine;
                    readLine = readLine / D;
                }

                if(rest==0) {
                    sb.append(s).append("\n");
                    break;
                }
            }
        }

        System.out.print(sb);
    }
}
