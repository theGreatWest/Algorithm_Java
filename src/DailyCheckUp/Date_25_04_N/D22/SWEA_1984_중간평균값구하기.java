package DailyCheckUp.Date_25_04_N.D22;

import java.util.*;
import java.io.*;

public class SWEA_1984_중간평균값구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(arr);
            int len = 0, sum = 0, minValue = arr[0], maxValue = arr[arr.length-1];
            for(int i=1;i<arr.length-1;i++){
                if(arr[i]== minValue || arr[i]==maxValue) continue;

                sum+=arr[i];
                len++;
            }

            sb.append("#").append(t).append(" ").append(String.format("%.0f", (double)sum/len)).append("\n");
        }

        System.out.print(sb);
    }
}
