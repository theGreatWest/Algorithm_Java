package DailyCheckUp.Date_25_05_N.D16;

import java.util.*;
import java.io.*;

public class SWEA_1218_SW문제해결기본_4일차_괄호짝짓기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            br.readLine();

            Stack<Character> stack = new Stack<>();
            for (char c : br.readLine().toCharArray()) {
                if (!stack.isEmpty() && isPair(c, stack.peek())) {
                    stack.pop();
                    continue;
                }
                stack.push(c);
            }

            sb.append("#").append(t).append(" ").append(stack.isEmpty() ? 1 : 0).append("\n");
        }

        System.out.print(sb);
    }

    static boolean isPair(char c1, char c2) {
        if (c1 == '}' && c2 == '{') return true;
        if (c1 == ']' && c2 == '[') return true;
        if (c1 == ')' && c2 == '(') return true;
        return c1 == '>' && c2 == '<';
    }
}
