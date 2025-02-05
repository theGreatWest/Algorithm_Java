package 정렬.버블정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_2750_수정렬하기 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // process
        // 버블정렬 : 한 사이클이 끝나면 하나의 자리가 정해진다.
        int cnt = 0;
        while (cnt++ < n) {
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) swap(i, i + 1);
            }
        }

        // 버블 정렬 이중 for 문
        // 연산 수는 더 적은 것 같은데, 이 방법의 수행 시간이 더 크게 나왔다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) swap(j, j + 1);
            }
        }

        // output
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
