package DailyCheckUp.Date_25_08_N;

import java.util.*;
import java.io.*;

public class 백준_7453_합이0인네정수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] a = new long[n], b = new long[n], c = new long[n], d = new long[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
        }

        // 두개씩 배열 합치기
        long[] ab = new long[n * n], cd = new long[n * n];
        int idx = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                ab[idx] = a[i] + b[j];
                cd[idx++] = c[i] + d[j];
            }
        }
        Arrays.sort(ab);
        Arrays.sort(cd);

        // 투 포인터
        int left = 0, right = cd.length - 1;
        long cnt = 0L;
        while(left < ab.length && right >= 0){
            long sum = ab[left] + cd[right];

            if(sum < 0) left++;
            else if(sum > 0) right--;
            else {
                long sameAbCnt = 1L;
                while(left + 1 < ab.length && ab[left]==ab[left+1]){
                    sameAbCnt++;
                    left++;
                }

                long sameCdCnt = 1L;
                while(right - 1 >= 0 && cd[right]==cd[right-1]){
                    sameCdCnt++;
                    right--;
                }

                cnt += (sameAbCnt * sameCdCnt);

                left++;
                right--;
            }
        }

        System.out.println(cnt);
    }
}