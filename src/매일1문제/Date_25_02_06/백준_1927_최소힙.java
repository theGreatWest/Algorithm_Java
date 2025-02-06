package 매일1문제.Date_25_02_06;

import java.io.*;
import java.util.*;

public class 백준_1927_최소힙 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // process
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 기본적으로 작은 값부터 나오게 되어있음
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (pq.isEmpty()) sb.append(0);
                else sb.append(pq.poll());
                sb.append("\n");
            }else pq.offer(x);
        }

        // output
        System.out.println(sb);
    }
}
