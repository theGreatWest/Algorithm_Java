package DailyCheckUp.Date_25_02_N.D15;

import java.util.*;
import java.io.*;

public class 백준_1715_카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        if (pq.size() == 1) System.out.println(0);
        else {
            int res = 0;
            while (!pq.isEmpty()) {
                if(pq.size()==1) break;
                else{
                    int tmpSum = pq.poll() + pq.poll();
                    res += tmpSum;
                    pq.offer(tmpSum);
                }
            }
            System.out.println(res);
        }
    }
}
