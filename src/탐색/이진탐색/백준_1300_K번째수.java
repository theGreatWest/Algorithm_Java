package 탐색.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_1300_K번째수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        long k = Integer.parseInt(br.readLine());
        br.close();

        // 이진 탐색
        // 문제 이해, 중앙 값보다 작은 수의 개수 세기( 작은 수의 개수가 k-1인 중앙값 구하기 )
        long s = 1, e = n*n;
        long answer = 0;

        while (s <= e) {
            long mid = (s + e) / 2;

            // mid 보다 작거나 같은 수의 개수 구하기
            long cnt = 0;
            for(int i=1;i<=n;i++){
                cnt += Math.min(mid/i, n); // [ i * j <= mid ]  ---(변경)---> [ j <= mid / i ] 를 만족하는 j의 수를 count.
                // i, j의 범위가 1 ~ n 이므로 n과 비교하는 것이다.
            }

            if (cnt < k) s = mid + 1; // 더 큰 값을 찾아야 함
            else {
                answer = mid; // 현재 mid가 후보, 더 작은 값도 가능한지 확인
                e = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
