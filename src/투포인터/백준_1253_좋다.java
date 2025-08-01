package 투포인터;

import java.util.*;
import java.io.*;

public class 백준_1253_좋다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(arr);

        long cnt = 0;
        for(int ti=n-1; ti>=0; ti--){
            long target = arr[ti];

            int l = 0, r = n-1;
            while(l < r) {
                if(ti==l) {
                    l++;
                    continue;
                }

                if(ti==r){
                    r--;
                    continue;
                }

                long sum = arr[l] + arr[r];

                if(sum == target){
                    cnt++;
                    break;
                }else if(sum > target) r--;
                else l++;
            }
        }

        System.out.println(cnt);
    }
}
