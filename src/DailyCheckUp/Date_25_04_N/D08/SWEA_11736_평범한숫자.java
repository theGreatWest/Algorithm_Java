package DailyCheckUp.Date_25_04_N.D08;

import java.io.*;
import java.util.*;

public class SWEA_11736_평범한숫자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for(int t=1;t<=tc;t++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int res = 0;
            for(int i=1;i<n-1;i++){
                int pim1 = arr[i-1];
                int pi = arr[i];
                int pip1 = arr[i+1];

//                if((pi > pim1 && pi < pip1) || (pi < pim1 && pi > pip1)) res++;

                int max = Math.max(pim1, pip1);
                int min = Math.min(pim1, pip1);

                if(pi > min && pi < max) res++;
            }

            sb.append("#").append(t).append(" ").append(res).append("\n");
        }

        System.out.print(sb);
    }
}
