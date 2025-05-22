package DailyCheckUp.Date_25_05_N.D22;

import java.util.*;
import java.io.*;

public class SWEA_9317_석찬이의받아쓰기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            char[] answer = br.readLine().toCharArray();
            char[] write = br.readLine().toCharArray();

            int correctNum = 0;
            for(int i=0;i<write.length;i++){
                char ans = answer[i];
                char w = write[i];

                if(ans==w) correctNum++;
            }

            sb.append("#").append(t).append(" ").append(correctNum).append("\n");
        }

        System.out.print(sb);
    }
}
