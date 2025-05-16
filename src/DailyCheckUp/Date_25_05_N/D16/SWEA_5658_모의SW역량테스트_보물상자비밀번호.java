package DailyCheckUp.Date_25_05_N.D16;

import java.util.*;
import java.io.*;

public class SWEA_5658_모의SW역량테스트_보물상자비밀번호 {
    static int N, K, parseN;
    static Set<Long> set;
    static Deque<String> d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 숫자의 개수
            K = Integer.parseInt(st.nextToken()); // 크기 순서

            d = new ArrayDeque<>();
            for (String s : br.readLine().split("")) {
                d.offerLast(s);
            }

            parseN = N / 4;
            set = new HashSet<>();
            for (int i = 0; i < parseN; i++) {
                String curr = String.join("", d);

                for (int j = N; j >= parseN; j -= parseN) {
                    String sub = curr.substring(j - parseN, j);
                    set.add(Long.parseLong(sub, 16));
//                    set.add(calculation(sub));
                }

                rotate();
            }

            List<Long> list = new ArrayList<>(set);
            list.sort(Collections.reverseOrder());
            sb.append("#").append(t).append(" ").append(list.get(K-1)).append("\n");
        }

        System.out.print(sb);
    }

    static long calculation(String sub) {
        /*
        * N진수 --> 10진수
            String str = "1A3F";
            long decimal = Long.parseLong(str, 16);
            System.out.println(decimal); // 출력: 6719
        */


        char first = sub.charAt(0);
        long res = (Character.isDigit(first)) ? (first - '0') : charToInt(first);

        for (int i = 1; i < parseN; i++) {
            char nc = sub.charAt(i);
            int valueNC = (Character.isDigit(nc)) ? (nc - '0') : charToInt(nc);

            res = res * 16 + valueNC;
        }

        return res;
    }

    static int charToInt(char c) {
        if (c == 'A') return 10;
        if (c == 'B') return 11;
        if (c == 'C') return 12;
        if (c == 'D') return 13;
        if (c == 'E') return 14;
        return 15;
    }

    static void rotate() {
        String lastV = d.pollLast();
        d.offerFirst(lastV);
    }
}
