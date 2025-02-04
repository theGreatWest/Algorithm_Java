package 자료구조.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_2470_두용액 {
    private static int n;
    private static List<Long> ns = new ArrayList<>();

    public static void main(String[] args) {
        input();
        process();
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                ns.add(Long.parseLong(st.nextToken()));
            }
            Collections.sort(ns);
        } catch (IOException e) {/**/}
    }

    private static void process() {
        long[] res = new long[2];

        long min = Long.MAX_VALUE;
        int i1 = 0, i2 = n - 1;
        while (i1 < i2) {
            long sum = ns.get(i1) + ns.get(i2);

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                res[0] = ns.get(i1);
                res[1] = ns.get(i2);

                if(sum==0) break;
            }

            if (sum < 0) i1++; // 합이 음수면 더 큰 값 찾아야
            else i2--; // 합이 양수면 더 작은 값 찾아야
        }
        System.out.println(res[0]+" "+res[1]);
    }
}

/*

9
-3 -2 -1 1 2 5 7 8 9

5
1 2 3 4 5

5
-1 -22 -3 -14 -35

*/