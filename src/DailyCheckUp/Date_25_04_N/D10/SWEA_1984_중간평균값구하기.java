package DailyCheckUp.Date_25_04_N.D10;

import java.util.*;
import java.io.*;

public class SWEA_1984_중간평균값구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for(int t=1;t<=T;t++){
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(arr);

            double res = 0.0;
            for(int i=1;i<arr.length-1;i++){
                res += arr[i];
            }
            res = res/(arr.length-2);

            sb.append("#").append(t).append(" ").append(String.format("%.0f", res)).append("\n");
        }

        System.out.print(sb);
    }
}
