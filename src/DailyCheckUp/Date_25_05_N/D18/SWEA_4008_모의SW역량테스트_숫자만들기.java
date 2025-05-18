package DailyCheckUp.Date_25_05_N.D18;

import java.util.*;
import java.io.*;

public class SWEA_4008_모의SW역량테스트_숫자만들기 {
    static int N, max, min;
    static int[] ops, nums;
    static Deque<String> d;

    // 값만 누적하는 방식으로 리팩토링해볼 것

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            ops = new int[4]; // +, -, *, /
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                ops[i] = Integer.parseInt(st.nextToken());
            }

            nums = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            d = new ArrayDeque<>();
            dfs(0);

            sb.append("#").append(t).append(" ").append(max - min).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int numIdx) {
        if (numIdx == N - 1) {
            d.offerLast(Integer.toString(nums[numIdx]));
            int result = result();
            max = Math.max(max, result);
            min = Math.min(min, result);
            d.pollLast();
            return;
        }

        d.offerLast(Integer.toString(nums[numIdx]));
        for (int i = 0; i < 4; i++) {
            if (ops[i] == 0) continue;

            ops[i]--;
            d.offerLast(intToString(i));
            dfs(numIdx + 1);
            d.pollLast();
            ops[i]++;
        }
        d.pollLast();
    }

    static String intToString(int i) {
        if (i == 0) return "+";
        if (i == 1) return "-";
        if (i == 2) return "*";
        return "/";
    }

    static int calculation(int a, int b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        if (op == '*') return a * b;
        return a / b;
    }

    static int result() {
        Deque<String> nd = new ArrayDeque<>(d);

        while (nd.size() > 1) {
            int v1 = Integer.parseInt(nd.pollFirst());
            char op = nd.pollFirst().charAt(0);
            int v2 = Integer.parseInt(nd.pollFirst());

            nd.offerFirst(Integer.toString(calculation(v1, v2, op)));
        }

        return Integer.parseInt(nd.poll());
    }
}
