package DailyCheckUp.Date_25_02_N.D17;

import java.util.*;
import java.io.*;

public class 백준_10828_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            if (input.length == 2) {
                stack.push(Integer.parseInt(input[1]));
            } else {
                String order = input[0];
                if (order.equals("pop")) bw.write((stack.isEmpty()) ? "-1" : String.valueOf(stack.pop()));
                else if (order.equals("size")) bw.write(String.valueOf(stack.size()));
                else if (order.equals("empty")) bw.write((stack.isEmpty()) ? "1" : "0");
                else bw.write((stack.isEmpty()) ? "-1" : String.valueOf(stack.peek()));
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
