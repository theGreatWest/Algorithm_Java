package 자료구조.슬라이딩_윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_21921_블로그 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // process
        int max = 0, len = 1;
        for (int i = 0; i < x; i++) {
            max += arr[i];
        }

        int curr = max;
        for (int i = 1; i <= n - x; i++) {
            curr -= arr[i - 1];
            int nextIdx = i + x - 1;
            if (nextIdx >= n) break;
            curr += arr[nextIdx];
            if (curr > max) {
                max = curr;
                len = 1;
            } else if (curr == max) len++;
        }
        System.out.println((max == 0) ? "SAD" : max + "\n" + len);
    }
}
