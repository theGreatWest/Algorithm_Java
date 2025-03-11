package DailyCheckUp.Date_25_02_N.D12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1654_랜선자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        long n = Integer.parseInt(st.nextToken());

        long[] lens = new long[k];
        long e = Integer.MIN_VALUE; // e 가 자를 수 있는 길이의 최댓값이어야 하므로 아래와 같이 해줘야 한다.
        for (int i = 0; i < k; i++) {
            lens[i] = Long.parseLong(br.readLine());
            if(lens[i] > e) e = lens[i];
        }

        // 일단 완전탐색으로 1~1000를 모두 확인해야 되는 문제
        long s = 1, maxLen = 0; // MaxLen 을 Integer.MinValue로 놓으면, 최대 자르는 길이(mid)가 1이나 0일 경우엔 업데이트되지 않음.
        // max, min 값을 초기화 할 땐, 안전하게 0이나 1로 할 것
        while (s <= e) {
            long mid = (s + e) / 2;

            long cnt = 0;
            for (long len : lens) {
                cnt += len / mid;
            }

            if (cnt >= n) {
                maxLen = Math.max(maxLen, mid);
                s = mid + 1;
            }else e = mid - 1;
        }

        System.out.println(maxLen);
    }
}
