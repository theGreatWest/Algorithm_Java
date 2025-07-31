package 투포인터;

import java.util.*;
import java.io.*;

public class 백준_3273_두수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int l = 0, r = n - 1, cnt = 0;
        while (l < r) {
            int sum = arr[l] + arr[r];

            if(sum == x) {
                cnt++;
                if(arr[l+1] == arr[l]) l++;
                r--;
            }else if(sum > x) r--;
            else l++;
        }

        System.out.println(cnt);
    }
}
