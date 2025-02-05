package 정렬.선택정렬;

import java.io.*;
import java.util.Arrays;

public class 백준_1427_소트인사이드 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nStr = br.readLine();
        int len = nStr.length();
        arr = new int[len];
        // for문 : str.substring(i, i+1)을 Integer.parseInt()로 감싸 정수형으로 변환해 주기
        int k = 0;
        for(String s : nStr.split("")){
            arr[k++] = Integer.parseInt(s);
        }

        // process
        int sIdx = 0;
        while (sIdx < len) {
            int maxIdx = searchMaxIdx(sIdx, len);
            swap(maxIdx, sIdx++);
        }

        // output
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<len;i++){
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }

    static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static int searchMaxIdx(int sIdx, int eIdx) {
        int max = Integer.MIN_VALUE, maxIdx = 0;
        for (int i = sIdx; i < eIdx; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}
