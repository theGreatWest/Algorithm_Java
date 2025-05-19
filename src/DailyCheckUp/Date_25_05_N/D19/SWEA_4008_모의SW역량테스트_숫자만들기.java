package DailyCheckUp.Date_25_05_N.D19;

import java.util.*;
import java.io.*;

public class SWEA_4008_모의SW역량테스트_숫자만들기 {
        static int N, max, min;
    static int[] ops, nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            ops = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            dfs(0, '+', 0);

            sb.append("#").append(t).append(" ").append(max - min).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int num, char op, int res) {
        if (num == 2 * N - 2) {
            res = calculation(res, nums[num/2], op);
            max = Math.max(max, res);
            min = Math.min(min, res);
            return;
        }

        if (num % 2 == 0) {
            dfs(num + 1, op, calculation(res, nums[num/2], op));
        }else{
            for(int i=0;i<4;i++){
                if(ops[i]==0) continue;

                ops[i]--;
                dfs(num+1, intToChar(i), res);
                ops[i]++;
            }
        }
    }

    static char intToChar(int i){
        if(i==0) return '+';
        if(i==1) return '-';
        if(i==2) return '*';
        return '/';
    }

    static int calculation(int a, int b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        if (op == '*') return a * b;
        return a / b;
    }
}
