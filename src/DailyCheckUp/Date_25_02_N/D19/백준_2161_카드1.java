package DailyCheckUp.Date_25_02_N.D19;

import java.util.*;
import java.io.*;

public class 백준_2161_카드1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> d = new LinkedList<>();
        for(int i=1;i<=n;i++){
            d.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!d.isEmpty()){
            sb.append(d.poll()).append(" ");
            if(d.size()>=2) d.offer(d.poll());
        }

        System.out.println(sb);
    }
}
