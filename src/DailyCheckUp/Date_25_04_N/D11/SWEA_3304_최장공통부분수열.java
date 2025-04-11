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

/* LIS( Longest Increasing Subsequence ) 코드
public static void main(String[] args) {
        int[] arr = {10, 20, 10, 30, 20, 50};
        List<Integer> lis = new ArrayList<>();

        for (int num : arr) {
            int idx = Collections.binarySearch(lis, num);

            // 값이 없으면 삽입 위치 반환 -> 음수로 나옴
            if (idx < 0) idx = -idx - 1;

            if (idx == lis.size()) lis.add(num); // 제일 큰 값이면 뒤에 붙임
            else lis.set(idx, num);              // 아니면 교체
        }

        System.out.println("LIS 길이: " + lis.size());
    }
*/