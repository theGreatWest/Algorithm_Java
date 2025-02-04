package 자료구조.구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_10986_나머지합구하기 {
    public static int n;
    public static int m;
    public static long[] nArr;

    public static void main(String[] args) {
        input();
        process();
    }

    public static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            nArr = new long[n];

            st = new StringTokenizer(br.readLine());
            int i = 0;
            while (st.hasMoreTokens()) {
                nArr[i++] = Integer.parseInt(st.nextToken());
            }
        } catch (IOException e) {/*pass*/}
    }

    public static void process() {
        // 구간 합 & 나머지 활용 문제
        //// 무조건 2개를 뽑아서 빼주는 것이 구간 합이므로, nC2를 활용해 경우의 수를 구하라.
        //// 나눗셈의 나머지 문제는, 원래 값이 아닌 나머지를 활용해 문제를 해결하라.

        long[] sn = new long[n];
        sn[0] = nArr[0];

        long[] rest = new long[m];
        rest[(int)(sn[0] % m)]++;

        for (int i = 1; i < n; i++) {
            sn[i] = (nArr[i] + sn[i - 1]);
            rest[(int)(sn[i] % m)]++;
        }

        long result = rest[0];
        for (int i = 0; i < m; i++) {
            if (rest[i] > 1) result += (rest[i] * (rest[i] - 1) / 2);
        }

        System.out.println(result);
    }
}
