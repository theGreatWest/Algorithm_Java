package DailyCheckUp.Date_25_03_N.D07;

import java.util.*;
import java.io.*;

public class 백준_10816_숫자카드2 {
    static int n, m;
    static long[] count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        count = new long[20000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            long input = Long.parseLong(st.nextToken());
            input += 10000000;
            count[(int)input]++;
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++){
            long input = Long.parseLong(st.nextToken());
            input += 10000000;
            sb.append(count[(int)input]).append(" ");
        }

        System.out.println(sb);
    }
}
