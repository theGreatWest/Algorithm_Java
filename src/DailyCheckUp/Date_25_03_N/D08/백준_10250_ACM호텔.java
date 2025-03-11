package DailyCheckUp.Date_25_03_N.D08;

import java.util.*;
import java.io.*;

public class 백준_10250_ACM호텔 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T =  Integer.parseInt(br.readLine());
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());

            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int tmp1 = N%H;
            int tmp2 = N/H;
            int i = (tmp1 ==0) ? H : tmp1; // 층수
            int j = (tmp1 ==0) ? tmp2 : tmp2 + 1; // 호수

            sb.append(i).append(String.format("%02d", j)).append("\n");
        }
        System.out.print(sb);
    }
}
