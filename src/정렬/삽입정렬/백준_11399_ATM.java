package 정렬.삽입정렬;

import java.io.*;
import java.util.*;

public class 백준_11399_ATM {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add( Integer.parseInt(st.nextToken()));
        }

        // process
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr.get(i) < arr.get(j)) {
                    int tmp = arr.get(i);
                    arr.remove(i);
                    arr.add(j, tmp);
                    break;
                }
            }
        }

        int[] fixSum = new int[n];
        fixSum[0] = arr.get(0);
        for(int i=1;i<n;i++){
            fixSum[i] = fixSum[i-1] + arr.get(i);
        }

        int res = 0;
        for(int i=0;i<n;i++){
            res += fixSum[i];
        }

        // output
        System.out.println(res);
    }
}
