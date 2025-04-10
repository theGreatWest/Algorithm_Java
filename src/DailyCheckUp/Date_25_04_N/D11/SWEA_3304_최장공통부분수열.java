package DailyCheckUp.Date_25_04_N.D11;

import java.util.*;
import java.io.*;

public class SWEA_3304_최장공통부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String ss = st.nextToken();
            String ls = st.nextToken();

            int[][] dp = new int[ss.length()+1][ls.length()+1];
            for(int i=1;i<=ss.length();i++){
                int ssValue = ss.charAt(i-1);
                for(int j=1; j<=ls.length(); j++){
                    int lsValue = ls.charAt(j-1);

                    if(ssValue == lsValue) dp[i][j] = dp[i-1][j-1] + 1;
                    else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }

//            for(int i=1;i<=ss.length();i++){
//                for(int j=1; j<=ls.length(); j++){
//                    System.out.print(dp[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();


//            int res = 0, startIdx = 0;
//            String s = "";
//            for (int i = 0; i < ss.length(); i++) {
//                char ssValue = ss.charAt(i);
////                System.out.println("i = " + i);
//                for (int j = startIdx; j < ls.length(); j++) {
//                    char lsValue = ls.charAt(j);
//                    if (ssValue == lsValue) {
//                        res++;
//                        startIdx = j+1;
//                        s+=lsValue;
////                        System.out.print("j = " + j);
////                        System.out.println(" -> visited = " + Arrays.toString(visited));
//                        break;
//                    }
//                }
//            }
//            System.out.println("s = " + s);

            // 역추적: 경로 추적
            int i = ss.length();
            int j = ls.length();
            StringBuilder lcs = new StringBuilder();

            while (i > 0 && j > 0) {
                if (ss.charAt(i - 1) == ls.charAt(j - 1)) {
                    lcs.append(ss.charAt(i - 1));
                    i--;
                    j--;
                } else if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
            System.out.println(lcs.reverse());

            sb.append("#").append(t).append(" ").append(dp[ss.length()][ls.length()]).append("\n");
        }

        System.out.print(sb);
    }
}
