package DailyCheckUp.Date_25_04_N.D23.모의고사;

import java.util.*;
import java.io.*;

public class SWEA_1984_중간평균값구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(arr);
            int min = arr[0];
            int max = arr[arr.length-1];
            int sum = 0, cnt = 0;
            for(int i=1;i<arr.length-1;i++){
                if(arr[i]!=min && arr[i]!=max){
                    cnt++;
                    sum += arr[i];
                }
            }

            sb.append("#").append(t).append(" ").append(String.format("%.0f", (sum/(double)cnt))).append("\n");
        }

        System.out.print(sb);
    }
}
