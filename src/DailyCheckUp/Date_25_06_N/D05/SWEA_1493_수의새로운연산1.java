package DailyCheckUp.Date_25_06_N.D05;

import java.util.*;
import java.io.*;

public class SWEA_1493_수의새로운연산1 {
    static Map<String, Integer> pairToNum = new HashMap<>();
    static Map<Integer, int[]> numToPair = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            andToPair(Math.max(p, q));
            int[] p1 = numToPair.get(p);
            int[] p2 = numToPair.get(q);

            int[] p1PlusP2 = sum(p1, p2);

            int res = pairToAnd(p1PlusP2);

            bw.write("#" + t + " " + res + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void andToPair(int p) {
        int an = 0;
        for (int x = 1; x < 142; x++) {
            an += x;

            int value = an, d = x;
            for (int y = 1; y < 142; y++) {
                String key = x+","+y;
                if (!pairToNum.containsKey(key)) {
                    pairToNum.put(key, value);
                    numToPair.put(value, new int[]{x, y});
                }

                if (value > p) break;
                if (value == p) return;

                value += d++;
            }
        }
    }

    static int pairToAnd(int[] p) {
        return pairToNum.get(p[0]+","+p[1]);
    }

    static void getValue(int[] p){
        int an = 0;
        for (int x = 1; x <= p[0]; x++) {
            an += x;

            int value = an, d = x;
            for (int y = 1; y <= p[1]; y++) {
                String key = x+","+y;
                if (!pairToNum.containsKey(key)) {
                    pairToNum.put(key, value);
                    numToPair.put(value, new int[]{x, y});
                }
                value += d++;
            }
        }
    }

    static int[] sum(int[] p1, int[] p2) {
        int nx = p1[0] + p2[0];
        int ny = p1[1] + p2[1];

        int[] np = new int[]{nx, ny};
        if(!pairToNum.containsKey(nx+","+ny)) getValue(np);
        return np;
    }
}
