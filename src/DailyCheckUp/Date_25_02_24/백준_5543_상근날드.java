package DailyCheckUp.Date_25_02_24;

import java.io.*;
import java.util.*;

public class 백준_5543_상근날드 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] burgers =new int[3];
        burgers[0] = Integer.parseInt(br.readLine());
        burgers[1] = Integer.parseInt(br.readLine());
        burgers[2] = Integer.parseInt(br.readLine());

        int[] beverages = new int[2];
        beverages[0] = Integer.parseInt(br.readLine());
        beverages[1] = Integer.parseInt(br.readLine());

// 우선 순위 큐를 이용한 방법
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for(int i=0;i<3;i++){
//            int burger = burgers[i];
//
//            for(int j=0;j<2;j++){
//                int beverage = beverages[j];
//
//                pq.offer(burger + beverage - 50);
//            }
//        }
//
//        System.out.println(pq.poll());

// 단순 비교를 이용한 방법
        int min = Integer.MAX_VALUE;
        for(int i=0;i<3;i++){
            int burger = burgers[i];

            for(int j=0;j<2;j++){
                int beverage = beverages[j];

                min = Math.min(min, burger+beverage-50);
            }
        }

        System.out.println(min);

    }
}
