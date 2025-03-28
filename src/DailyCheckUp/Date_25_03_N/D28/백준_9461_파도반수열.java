package DailyCheckUp.Date_25_03_N.D28;

import java.util.*;
import java.io.*;

public class 백준_9461_파도반수열 {
    // Solution2. 배열 이용하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        StringBuilder sb = new StringBuilder();
        int lastIdx = 5;
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            if(n > lastIdx){
                for(int i=lastIdx+1;i<=n;i++){
                    dp[i] = dp[i-1] + dp[i-5];
                }
                lastIdx = n;
            }

            sb.append(dp[n]).append("\n");
        }

        System.out.print(sb);
    }

// Solution 1. List 이용하기
//        public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//
//        List<Long> list = new ArrayList<>();
//        list.add(1L);
//        list.add(1L);
//        list.add(1L);
//        list.add(2L);
//        list.add(2L);
//        list.add(3L);
//        list.add(4L);
//        list.add(5L);
//        list.add(7L);
//        list.add(9L);
//
//        StringBuilder sb = new StringBuilder();
//        while(T-- > 0){
//            int n = Integer.parseInt(br.readLine());
//
//            if(n > list.size()) {
//                for(int i=list.size();i<n;i++){
//                    list.add(list.get(i-5) + list.get(i-1));
//                }
//            }
//
//            sb.append(list.get(n-1)).append("\n");
//        }
////        System.out.println(list);
//        System.out.print(sb);
//    }
}
