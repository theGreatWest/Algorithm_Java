package 정렬.퀵정렬;

import java.util.*;
import java.io.*;

public class 백준_11004_K번째수_퀵정렬_연습 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // process : 퀵 정렬 수행
        quickSort(arr, 0, n - 1, k - 1);

        // output
        System.out.println(arr[k - 1]);
    }

    // 정렬 범위 설정
    // 재귀 호출로 퀵 정렬 수행
    static void quickSort(int[] arr, int start, int end, int k) {
        if (start < end) {
            int pivot = position(arr, start, end);
            if (k == pivot) return;
            else if (k < pivot) quickSort(arr, start, pivot - 1, k);// 찾는 값이 pivot 보다 왼쪽에 있을 때: 왼쪽만 봐주기
            else quickSort(arr, pivot + 1, end, k); // 찾는 값이 pivot 보다 오른쪽에 있을 때: 오른쪽만 봐주기
        }
    }

    // pivot 의 위치 반환(자기 자리가 확정된 요소의 index 반환)
    static int position(int[] arr, int start, int end) {
        if (end - 1 == start) {
            if (arr[start] > arr[end]) swap(arr, start, end);
            return end;
        }

        int mid = (start + end)/2;
        swap(arr, start, mid); // 중앙값을 Pivot 으로 설정 -> 맨 앞의 숫자와 바꿔 줌 => 값의 이동 직관적으로 확인 가능

        // pivot 보다 큰 값은 pivot의 오른쪽에, 보다 작은 값은 왼쪽에 분리하는 작업
        int pivot = arr[start];
        int sIdx = start + 1;
        int eIdx = end;
        while(sIdx <= eIdx){
            while(sIdx <= end && arr[sIdx] < pivot) sIdx++;
            while(eIdx >= start+1 && arr[eIdx] > pivot) eIdx--;

            if(sIdx <= eIdx){
                swap(arr, sIdx, eIdx);
                sIdx++;
                eIdx--;
            }
        }

        // eIdx 값과 pivot 값의 위치를 바꿔주어 원상태로 돌려놓기
        arr[start] = arr[eIdx];
        arr[eIdx] = pivot;

        return eIdx;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
