package 정렬.병합정렬;

import java.util.*;
import java.io.*;

public class 백준_2751_수정렬하기2_연습 {
    static int[] arr, tmpArr;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        tmpArr = new int[n];

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
        if (S >= E) return; // 종료 조건

        // 중간 값을 기준으로 나누어 줄 예정
        int m = S + ((E - S) / 2);

        // 재귀함수로 미리 호출
        mergeSort(S, m);
        mergeSort(m + 1, E);

        // 임시 배열에 지금 배열 저장 : 지금 배열에서 sort 할 예정
        for (int i = S; i <= E; i++) {
            tmpArr[i] = arr[i];
        }

        /* 구조는 아래와 같다. idx1/idx2 는 각각 sub 배열을 합칠 때 사용하는 것이다.
                [8, 3, 7, 4, 9, 2, 6, 5]   (원래 배열)
                   ↓
                [8, 3, 7, 4]   [9, 2, 6, 5]   (중간에서 분할)
                   ↓
                [8, 3]   [7, 4]   [9, 2]   [6, 5]   (반으로 계속 나눔)
         */

        // subArr 정렬을 하기 위한 요소 선언
        int k = S; // subArr 이 원래 배열에서 나타내는 index를 의미
        // subArr 에서 값을 비교하기 위한 수단
        int idx1 = S; // 왼쪽 sub 배열에서의 첫 번째 요소 Index
        int idx2 = m + 1; // 오른쪽 sub 배열에서의 첫 번째 요소 Index

        while (idx1 <= m && idx2 <= E) {
            // 더 큰 값을 arr 속, subArr 맨 앞자리에 순서대로 채워주기
            if (tmpArr[idx1] > tmpArr[idx2]) arr[k++] = tmpArr[idx2++];
            else arr[k++] = tmpArr[idx1++];
        }
        // 남은 값들을 그대로 복사하는 경우
        while (idx1 <= m) arr[k++] = tmpArr[idx1++];

        while (idx2 <= E) arr[k++] = tmpArr[idx2++];
    }
}
