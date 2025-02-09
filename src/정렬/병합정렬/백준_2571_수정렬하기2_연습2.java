package 정렬.병합정렬;

import java.util.*;
import java.io.*;

public class 백준_2571_수정렬하기2_연습2 {
    static int[] arr;
    static int[] tmpArr;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        tmpArr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // process
        mergeSort(0, n - 1);

        // output
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void mergeSort(int S, int E) {
        if (S >= E) return;

        int m = S + (E - S) / 2;

        mergeSort(S, m);
        mergeSort(m + 1, E);

        // 현재 값 임시 배열에 저장
        for (int i = S; i <= E; i++) {
            tmpArr[i] = arr[i];
        }

        int k = S;
        int idx1 = S;
        int idx2 = m + 1;

        // 2개의 배열을 작은 숫자 먼저 오도록 병합
        while (idx1 <= m && idx2 <= E) {
            if (tmpArr[idx1] > tmpArr[idx2]) arr[k++] = tmpArr[idx2++];
            else arr[k++] = tmpArr[idx1++];
        }

        // 위에서 정렬하고 남은 수들을 차례대로 원래 배열에 넣어주기
        while (idx1 <= m) arr[k++] = tmpArr[idx1++];
        while (idx2 <= E) arr[k++] = tmpArr[idx2++];

    }
}
