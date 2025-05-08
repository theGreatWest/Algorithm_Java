package DailyCheckUp.Date_25_05_N.D08;

import java.util.*;
import java.io.*;

public class SWEA_3499_퍼펙트셔플 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
// index 사용한 방법
            // 0,1,2,3,4,5 (3) -> 0,3, 1,4, 2,5
            // 0,1,2,3,4 (2) -> 0,3, 1,4, 2
            int mid = n/2;
            String[] res = new String[n];
            int idx = -1;
            for(int i=0;i<mid;i++){
                res[++idx] = input[i];
                res[++idx] = input[mid + i + ((n%2==0) ? 0 : 1)];
            }
            if(n%2!=0) res[n-1] = input[mid];
// Queue 사용한 방법
//            Queue<String> q1 = new LinkedList<>();
////            int mid = Integer.parseInt(String.format("%.0f", n/2.0));
//            int mid = (n+1)/2; // 반올림한 숫자 구하는 다른 방법 중 하나
//            for(int i=0;i<mid;i++){
//                q1.offer(input[i]);
//            }
//            Queue<String> q2 = new LinkedList<>();
//            for(int i=mid;i<n;i++){
//                q2.offer(input[i]);
//            }
//
//            String[] res = new String[n];
//            for(int i=0;i<n;i++){
//                res[i] = (i%2==0) ? q1.poll() : q2.poll();
//            }
            sb.append("#").append(t).append(" ").append(String.join(" ", res)).append("\n");
        }

        System.out.print(sb);
    }
}
