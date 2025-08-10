package DailyCheckUp.Date_25_08_N.D10;

import java.util.*;
import java.io.*;

public class 백준_1920_수찾기 {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();
        for(int i=0; i<m; i++){
            int target = Integer.parseInt(st.nextToken());

            result.append(find(target, 0, arr.length-1)).append("\n");
        }

        System.out.println(result);
    }

    static int find(int target, int left, int right){
        if(left <= right) {
            int mid = (left + right) / 2;

            if(target == arr[mid]) {
                return 1;
            }else if(target < arr[mid]){
                return find(target, left, mid-1);
            }else {
                return find(target, mid+1, right);
            }
        }

        return 0;
    }
}
