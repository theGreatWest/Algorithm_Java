package DP;

import java.io.*;
import java.util.*;

public class 백준_9252_LCS2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] str1 = br.readLine().split("");
        String[] str2 = br.readLine().split("");

        int size1 = str1.length, size2  = str2.length;

        int[][] dp = new int[size1+1][size2+1];
        for(int i=1;i<=size1;i++){
            for(int j=1;j<=size2;j++){
                int minusI = i - 1, minusJ = j - 1;
                dp[i][j] = ( str1[minusI].equals(str2[minusJ]) ) ? dp[minusI][minusJ] + 1 : Math.max(dp[i][minusJ], dp[minusI][j]);
            }
        }

        int i = size1, j = size2;
        List<String> result = new ArrayList<>();
        while(i>0 && j>0){
            int minusI = i - 1, minusJ = j - 1;

            if(str1[minusI].equals(str2[minusJ])){
                result.add(str1[minusI]);
                i = minusI;
                j = minusJ;
            }else{
                int dpI = dp[minusI][j], dpJ = dp[i][minusJ];

                if(dpI > dpJ) i = minusI;
                else j = minusJ;
            }
        }

        int lcs = dp[size1][size2];
        sb.append(lcs).append("\n");
        if(lcs!=0){
            for(int k= result.size()-1; k>=0;k--){
                sb.append(result.get(k));
            }
        }
        System.out.println(sb);
    }
}
