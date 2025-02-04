package 자료구조.슬라이딩_윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_12891_DNA비밀번호 {
    private static final int a = 0;
    private static final int c = 1;
    private static final int g = 2;
    private static final int t = 3;

    private static int s, p;
    private static List<String> dna = new ArrayList<>();
    private static int[] curr = new int[4];
    private static int[] min = new int[4];

    public static void main(String[] args) {
        input();
        process();
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        try {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for (String s : br.readLine().split("")) {
                dna.add(s);
                if (++cnt <= p) {
                    if (s.equalsIgnoreCase("a")) curr[a]++;
                    else if (s.equalsIgnoreCase("c")) curr[c]++;
                    else if (s.equalsIgnoreCase("g")) curr[g]++;
                    else curr[t]++;
                }
            }

            st = new StringTokenizer(br.readLine());
            min[a] = Integer.parseInt(st.nextToken());
            min[c] = Integer.parseInt(st.nextToken());
            min[g] = Integer.parseInt(st.nextToken());
            min[t] = Integer.parseInt(st.nextToken());
        } catch (IOException e) {/**/}
    }

    private static void process() {
        int result = 0;
        for (int i = 0; i <= s - p; i++) {
            int nextEndIdx = i + p;

            if (curr[a] >= min[a] && curr[c] >= min[c] && curr[g] >= min[g] && curr[t] >= min[t]) result++;

            if(checkRange(nextEndIdx)){
                decision(dna.get(i), curr, false);
                decision(dna.get(nextEndIdx), curr, true);
            }
        }
        System.out.println(result);
    }

    private static boolean checkRange(int idx) {
        return idx >= 0 && idx < s;
    }

    private static void decision(String dna, int[] curr, boolean operation) {
        if (operation) {
            if (dna.equalsIgnoreCase("a")) curr[a]++;
            else if (dna.equalsIgnoreCase("c")) curr[c]++;
            else if (dna.equalsIgnoreCase("g")) curr[g]++;
            else curr[t]++;
        } else {
            if (dna.equalsIgnoreCase("a")) curr[a]--;
            else if (dna.equalsIgnoreCase("c")) curr[c]--;
            else if (dna.equalsIgnoreCase("g")) curr[g]--;
            else curr[t]--;
        }
    }
}
