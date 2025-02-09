package 정렬.병합정렬;

import java.util.*;
import java.io.*;

public class 백준_1517_버블소트 {
    static int[] arr;
    static int[] tmp;
    static long res;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        tmp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // process
        mergeSort(0, n - 1);

        // output
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(res+"\n");
        bw.flush();
        bw.close();
    }

    static void mergeSort(int S, int E) {
        if (S >= E) return;

        int m = S + (E - S) / 2;

        mergeSort(S, m);
        mergeSort(m + 1, E);

        for (int i = S; i <= E; i++) {
            tmp[i] = arr[i];
        }

        int k = S;
        int idx1 = S;
        int idx2 = m + 1;
        while (idx1 <= m && idx2 <= E) {
            if (tmp[idx1] > tmp[idx2]) {
                arr[k] = tmp[idx2];
                res+= (idx2++ - k++); // swap이 일어난다고 가정 -> swap 횟수는 앞쪽에 이미 채워져 있는 요소의 수와 같음
            }
            else arr[k++] = tmp[idx1++];
        }

        while (idx1 <= m) arr[k++] = tmp[idx1++];
        while (idx2 <= E) arr[k++] = tmp[idx2++];
    }
}
