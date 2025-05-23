package DailyCheckUp.Date_25_05_N.D23;

import java.util.*;
import java.io.*;

// 출력 형식을 꼼꼼히 보지 않아 오래 걸린 문제!
public class SWEA_24001_로봇언어 {
    static int max;
    static char[] order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            order = br.readLine().toCharArray();

            Set<Integer> set = new HashSet<>();
            set.add(0);
            max = 0;
            for (char od : order) {
                set = getSet(od, set);
            }

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }

    static Set<Integer> getSet(char order, Set<Integer> set){
        Set<Integer> nSet = new HashSet<>();

        for (int currValue : set) {
            if (order == 'L' || order == '?') {
                nSet.add(currValue - 1);
                max = Math.max(max, Math.abs(currValue -1));
            }
            if (order == 'R' || order == '?') {
                nSet.add(currValue + 1);
                max = Math.max(max, Math.abs(currValue + 1));
            }
        }

        return nSet;
    }
}
