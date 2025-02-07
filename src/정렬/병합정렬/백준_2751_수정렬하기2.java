package 정렬.병합정렬;

import java.io.*;

public class 백준_2751_수정렬하기2 {
//
//    public static void main(String[] args) throws IOException {
//        // input
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for (int i = 0; i < n; i++) {
//            pq.offer(Integer.parseInt(br.readLine()));
//        }
//
//        // output
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        while (!pq.isEmpty()) {
//            bw.write(pq.poll() + "\n");
//        }
//        bw.flush();
//        bw.close();
//    }

    static int[] arr, tmpArr;

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
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            res.append(arr[i]).append("\n");
        }
        System.out.println(res);

    }

    static void mergeSort(int startIdx, int endIdx) {
        if (startIdx >= endIdx) return;

        int mid = startIdx + (endIdx - startIdx) / 2;

        // 재귀함수로 구현
        mergeSort(startIdx, mid);
        mergeSort(mid + 1, endIdx);

        for (int i = startIdx; i <= endIdx; i++) tmpArr[i] = arr[i];

        int k = startIdx;
        int idx1 = startIdx;
        int idx2 = mid + 1;

        while (idx1 <= mid && idx2 <= endIdx) {
            if (tmpArr[idx1] > tmpArr[idx2]) arr[k++] = tmpArr[idx2++];
            else arr[k++] = tmpArr[idx1++];
        }

        while (idx1 <= mid) arr[k++] = tmpArr[idx1++];

        while (idx2 <= endIdx) arr[k++] = tmpArr[idx2++];
    }
}