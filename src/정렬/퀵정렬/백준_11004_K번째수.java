package 정렬.퀵정렬;

import java.io.*;
import java.util.*;

public class 백준_11004_K번째수 {
    static List<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // process
        quickSort(A, 0, N - 1, K - 1);

        // output
        System.out.println(A[K - 1]);
    }

    static void quickSort(int[] A, int StartIdx, int EndIdx, int K) {
        if (StartIdx < EndIdx) {
            int pivot = partition(A, StartIdx, EndIdx);
            if (pivot == K) return;
            else if (pivot > K) quickSort(A, StartIdx, pivot - 1, K); // 피벗이 K보다 크면, 왼쪽만 봐주기
            else quickSort(A, pivot + 1, EndIdx, K); // 피벗이 K보다 작으면, 오른쪽만 봐주기
        }
    }

    static int partition(int[] A, int StartIdx, int EndIdx) {
        // 요소가 2개일 때
        if (StartIdx + 1 == EndIdx) {
            if (A[StartIdx] > A[EndIdx]) swap(A, StartIdx, EndIdx);
            return EndIdx;
        }

        // 요소가 2개 이상일 때
        int MidIdx = (StartIdx + EndIdx) / 2;
        swap(A, StartIdx, MidIdx); // 중앙 값을 1번째 요소로 이동시켜주기 <= i(startIdx), j(endIdx)의 이동을 편하게 하기 위해

        int partitionPivot = A[StartIdx];
        int partitionStartIdx = StartIdx + 1;
        int partitionEndIdx = EndIdx;

        while (partitionStartIdx <= partitionEndIdx) {
            // pivot보다 작은 수가 나올 때까지 endIdx--
            while (partitionEndIdx >= StartIdx + 1 && partitionPivot < A[partitionEndIdx]) partitionEndIdx--;
            // pivot보다 큰 수가 나올 때까지 startIdx++
            while (partitionStartIdx <= EndIdx && partitionPivot > A[partitionStartIdx]) partitionStartIdx++;

            if (partitionStartIdx <= partitionEndIdx) {
                swap(A, partitionStartIdx++, partitionEndIdx--);
            }
        }

        // pivot 데이터를 나눠진 두 그룹의 index에 저장하기
        A[StartIdx] = A[partitionEndIdx];
        A[partitionEndIdx] = partitionPivot;

        return partitionEndIdx;
    }

    static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
