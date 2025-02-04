package 정렬.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_2018_수들의합 {
    public static void main(String[] args) {
        int n = input();
        if (n != -1) process(n);
    }

    private static int input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            return -1;
        }
    }

    private static void process(int n) {
        int[] nArr = new int[n];
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            nArr[i] = cnt++;
        }

        int result = 1, startIdx = 0, endIdx = 0, sum = 1;
        while (endIdx != (n - 1)) {
            if (sum == n) {
                endIdx++;
                sum += nArr[endIdx];
                result++;
            } else if (sum < n) {
                endIdx++;
                sum += nArr[endIdx];
            } else {
                sum -= nArr[startIdx];
                startIdx++;
            }
        }
        System.out.println(result);
    }
}
