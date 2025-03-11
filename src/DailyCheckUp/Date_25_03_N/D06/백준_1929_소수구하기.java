package DailyCheckUp.Date_25_03_N.D06;

import java.io.*;

public class 백준_1929_소수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);

        for (int i = a; i <= b; i++) {
            if (i == 1) continue;

            if (prime(i)) sb.append(i).append("\n");
        }

        System.out.print(sb);
    }

    static boolean prime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}
