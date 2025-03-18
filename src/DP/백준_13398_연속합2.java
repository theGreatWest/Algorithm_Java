package DP;

import java.io.*;
import java.util.*;

public class 백준_13398_연속합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long max = list[0];

        // 오른쪽 방향 : 하나도 제거하지 않은 연속 합
        long[] dpL = new long[n];
        dpL[0] = list[0];

        for(int i=1;i<n;i++){
            dpL[i] = Math.max(list[i], dpL[i-1] + list[i]);
            max = Math.max(max, dpL[i]);
        }

        // 왼쪽 방향 : 하나도 제거하지 않은 연속 합
        int last = n - 1;
        long[] dpR = new long[n];
        dpR[last] = list[last];

        for(int i=last-1;i>=0;i--){
            dpR[i] = Math.max(list[i], dpR[i+1] + list[i]);
        }

        // 아...! dpL[i-1] + dpR[i+1] 의 값은 list[i] 값을 제외한 구간 합과 같아!!
        for(int i=1;i<last;i++){
            max = Math.max(max, dpL[i-1] + dpR[i+1]);
        }

        System.out.println(max);
    }
}
