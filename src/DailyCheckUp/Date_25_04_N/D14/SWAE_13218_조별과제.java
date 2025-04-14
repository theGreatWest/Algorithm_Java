package DailyCheckUp.Date_25_04_N.D14;

import java.util.*;
import java.io.*;

public class SWAE_13218_조별과제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            int studentNum = Integer.parseInt(br.readLine());

            sb.append("#").append(t).append(" ").append(studentNum/3).append("\n");
        }

        System.out.print(sb);
    }
}
