package DailyCheckUp.Date_25_03_N.D03;

import java.util.*;
import java.io.*;

public class 백준_11047_동전O {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i=n-1;i>=0;i--){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for(int i=0; ( i<n || k!=0 );i++){
            cnt += (k/arr[i]);
            k %= arr[i];
        }

        System.out.println(cnt);
    }
}
