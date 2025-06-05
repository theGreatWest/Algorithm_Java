package DailyCheckUp.Date_25_06_N.D05;

import java.io.*;
import java.util.*;

public class SWEA_1493_수의새로운연산2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int[] p1 = getPair(p);
            int[] p2 = getPair(q);

            int[] sumP = sum(p1, p2);

            int calcStar = getNum(sumP);

            bw.write("#" + t + " " + calcStar + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

/*

대각선1: 좌표 (1,1) → 1
대각선2: 좌표 (1,2) → 2, (2,1) → 3
대각선3: 좌표 (1,3) → 4, (2,2) → 5, (3,1) → 6
대각선4: 좌표 (1,4) → 7, (2,3) → 8, (3,2) → 9, (4,1) → 10
...

*/

    // (x, y) → number
    static int getNum(int[] pair) {
        int x = pair[0];
        int y = pair[1];

        int n = x + y - 1;
        return n * (n - 1) / 2 + x;
    }

    // number → (x, y)
    static int[] getPair(int num) {
        int n = 1;
        while (n * (n + 1) / 2 < num) n++;
        int sum = n * (n - 1) / 2;
        int x = num - sum;
        int y = n - x + 1;
        return new int[]{x, y};
    }

    static int[] sum(int[] p1, int[] p2){
        return new int[]{p1[0]+p2[0], p1[1]+p2[1]};
    }
}
