package DailyCheckUp.Date_25_02_N.D09;

import java.io.*;
import java.util.*;

public class 백준_2512_예산 {
    public static void main(String[] args) throws IOException {
// input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long M = Long.parseLong(br.readLine());
        br.close();

// process
        Arrays.sort(arr);

        int cutLine = arr[n-1];
        long sum = Arrays.stream(arr).sum();
        while(sum > M){
            sum = 0;
            cutLine--;
            for(int i=0;i<n;i++){
                if(arr[i] <= cutLine) sum += arr[i];
                else sum += cutLine;
            }
        }

// output
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(cutLine + "\n");
        bw.flush();
        bw.close();
    }
}
