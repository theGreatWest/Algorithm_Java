package DailyCheckUp.Date_25_02_15;

import java.util.*;
import java.io.*;

public class 백준_9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<String> stack;

        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            stack = new Stack<>();
            String[] inputs = br.readLine().split("");

            boolean res = true;
            for (String current : inputs) {
                if (current.equals(")")) {
                    if (stack.isEmpty()) {
                        res = false;
                        break;
                    } else stack.pop();
                } else stack.push(current);
            }

            bw.write((stack.isEmpty() && res? "YES" : "NO") + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
