package DailyCheckUp.Date_25_02_N.D06;

import java.io.*;
import java.util.*;

public class 백준_1927_최소힙 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // original process : 작은 값 부터 정렬되어야 한다면?
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 기본적으로 작은 값부터 나오게 되어있음

        // + process 1 : 만약 절댓값 기준 작은 값부터 정렬되어야 한다면?
//        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
//            int absO1 = Math.abs(o1);
//            int absO2 = Math.abs(o2);
//
//            if(absO1==absO2) return o1-o2;
//            else return absO1 - absO2;
//        });

        // + process 2 : 만약 절댓값 기준 큰 값부터 정렬되어야 한다면?
//        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
//            int absO1 = Math.abs(o1);
//            int absO2 = Math.abs(o2);
//
//            if(absO1==absO2) return o2-o1;
//            else return absO2-absO1;
//        });

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
