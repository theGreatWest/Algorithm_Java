package DailyCheckUp.Date_25_04_N.D15;

import java.io.*;

public class SWEA_1222_SW문제해결기본_6일차_계산기1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 후위 표기식
        // ((((3 4 +)5 +)6 +)7 +) ==> (표기) 34+5+6+7+

        for (int t = 1; t <= 2; t++) {
            Integer.parseInt(br.readLine());
            int sum = 0;
            for (char c : br.readLine().toCharArray()) {
                if(Character.isDigit(c)) sum += c - '0';
            }
            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }

        System.out.print(sb);
    }
}
