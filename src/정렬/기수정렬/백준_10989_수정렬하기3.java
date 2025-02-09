package 정렬.기수정렬;

import java.io.*;
import java.util.Arrays;

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
        int pointer = 1; // 자릿수( 1의 자리부터 시작해서 10단위로 증가 )

        for (int i = 0; i < maxSize; i++) { // 최대 자릿수 만큼 반복( Ex. 최댓값이 1110이면 4번 반복 )
            int[] numbers = new int[10]; // 0~9의 숫자가 몇 번 나왔는지 카운트

            // [ 1 단계 ] 현재 자릿수를 기준으로 각 숫자의 개수 세기
            for (int j = 0; j < arr.length; j++) {
                numbers[arr[j] / pointer % 10]++; // index와 해당 자리의 값이 같다면 +1
            }

            // [ 2 단계 ] 누적합 계산 -> 실제로 정렬될 위치 파악을 위해
            for (int j = 1; j < 10; j++) {
                numbers[j] += numbers[j - 1]; // 합 배열(누적합) 이용해 index 계산
            }

            // [ 3 단계 ] 현재 자릿수를 기준으로 정렬( 역순으로 순회 )
            for (int j = arr.length - 1; j >= 0; j--) {
                int index = arr[j] / pointer % 10;
                processedArr[numbers[index] - 1] = arr[j];
                numbers[index]--;
                // 이 단계에서 굳이 같은 기수끼리 정렬할 필요 없다( 순서대로 그냥 내보내기 )
                System.out.print("processedArr = " + Arrays.toString(processedArr));
                System.out.print(" / numbers = " + Arrays.toString(numbers)+"\n");
            }

            // [ 4 단계 ] 현재 자릿수 기준으로 정렬된 결과를 원본 배열에 복사
            for (int j = 0; j < arr.length; j++) {
                arr[j] = processedArr[j]; // 다음 자릿수로 이동하기 위해 현재 자릿수 기준 정렬 데이터 저장
            }

            // [ 5 단계 ] 자릿수 증가
            pointer *= 10;
        }
    }
}
