package 탐색.이진탐색;

import java.io.*;
import java.util.*;

public class 백준_2343_기타레슨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        int e = arr[0];
        int s = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > s) s = arr[i];
            e += arr[i];
        }

        // process
        while(s <= e){
            int mid = (s+ e)   / 2;
            int tmpSum = 0;
            int blueCnt = 0;
            for(int i=0;i<n;i++){ // mid 값으로 모든 레슨 저장 가능한지 확인
                if(tmpSum + arr[i] > mid){
                    blueCnt++;
                    tmpSum = 0;
                }
                tmpSum += arr[i];
            }
            if(tmpSum!=0) blueCnt++; // tmpSum이 0이 아니면 블루레이가 1개 더 필요하므로 더함

//            if(blueCnt==m) System.out.println(mid);
            if(blueCnt > m) s = mid + 1;
            else e = mid - 1;
        }

        System.out.println(s);

    }
}
