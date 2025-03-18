package DailyCheckUp.Date_25_03_N.D18;

import java.io.*;

public class 백준_10162_전자레인지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totTime = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int div : new int[]{300, 60, 10}){
            sb.append(totTime / div).append(" ");
            totTime %= div;
        }

        if(totTime==0) System.out.println(sb);
        else System.out.println(-1);
    }
}
