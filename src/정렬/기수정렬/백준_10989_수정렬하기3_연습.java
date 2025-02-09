package 정렬.기수정렬;

import java.io.*;

public class 백준_10989_수정렬하기3_연습 {
    // PriorityQueue 는 메모리 초과가 나서 카운팅 정렬 사용
    static int[] arr;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        int maxSize = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.length() > maxSize) maxSize = input.length();
            arr[i] = Integer.parseInt(input);
        }
        br.close();

        // process
        countingSort();

        // output
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void countingSort() {
        int maxSize = 10000001;
        int[] tmp = new int[maxSize];
        for (int i = 0; i < arr.length; i++) {
            tmp[arr[i]]++;
        }

        int idx = 0;
        for(int i=0;i<maxSize;i++){
            if(tmp[i]==0) continue;

            for(int j=0;j<tmp[i];j++){
                arr[idx++] = i;
            }
        }
    }
}
