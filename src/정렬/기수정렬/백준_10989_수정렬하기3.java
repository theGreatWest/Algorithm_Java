package 정렬.기수정렬;

import java.io.*;

public class 백준_10989_수정렬하기3 {
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
        radixSort(maxSize);

        // output
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void radixSort(int maxSize) {
        int[] processedArr = new int[arr.length]; // 정렬 결과를 저장할 배열
        int pointer = 1; // 자릿수

        for (int i = 0; i < maxSize; i++) { // 최대 자릿수 만큼 반복(자릿수 기준 저장 -> 정렬)
            int[] numbers = new int[10]; // 들어갈 수 있는 숫자: 0~9

            for (int j = 0; j < arr.length; j++) {
                numbers[arr[j] / pointer % 10]++; // index와 해당 자리의 값이 같다면 +1
            }

            for (int j = 1; j < 10; j++) {
                numbers[j] += numbers[j - 1]; // 합 배열(누적합) 이용해 index 계산
            }

            // 현재 자릿수 기준으로 정렬
            for (int j = arr.length - 1; j >= 0; j--) {
                processedArr[numbers[(arr[j] / pointer % 10)] - 1] = arr[j];
                numbers[(arr[j] / pointer) % 10]--;
            }

            for (int j = 0; j < arr.length; j++) {
                arr[j] = processedArr[j]; // 다음 자릿수로 이동하기 위해 현재 자릿수 기준 정렬 데이터 저장
            }
            pointer *= 10; // 자릿수 증가 시키기
        }
    }
}
