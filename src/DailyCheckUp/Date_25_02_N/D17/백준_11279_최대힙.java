package DailyCheckUp.Date_25_02_N.D17;

import java.io.*;
import java.util.*;

public class 백준_11279_최대힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            long value = Long.parseLong(br.readLine());
            if (value == 0) sb.append((pq.isEmpty()) ? "0" : Long.toString(pq.poll())).append("\n");
            else pq.offer(value);
        }

        System.out.print(sb);
    }
}
