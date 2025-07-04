package DailyCheckUp.Date_25_07_N.D04;

import java.util.*;
import java.io.*;

public class 백준_10950_AplusBminus3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for(int n=0;n<N;n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write((a+b)+"\n");
        }

        bw.flush();
    }
}
