package DailyCheckUp.Date_25_02_N.D15;

import java.util.*;
import java.io.*;

public class 백준_2109_순회강연 {
    public static void main(String[] args) throws IOException {
//  [ Sol 1 ]
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        if (n == 0) { // 예외 처리 추가
//            System.out.println(0);
//            return;
//        }
//
//        List<int[]> lectures = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            int pay = sc.nextInt();
//            int deadline = sc.nextInt();
//            lectures.add(new int[]{pay, deadline});
//        }
//
//        // 1. 마감 기한 기준 정렬 (내림차순)
//        lectures.sort((a, b) -> b[1] - a[1]);
//
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//        int maxDay = lectures.get(0)[1], idx = 0, result = 0;
//
//        // 2. 마감 기한부터 1일까지 역순 탐색
//        for (int day = maxDay; day > 0; day--) {
//            while (idx < n && lectures.get(idx)[1] >= day) {
//                pq.offer(lectures.get(idx++)[0]);
//            }
//            if (!pq.isEmpty()) result += pq.poll();
//        }
//
//        System.out.println(result);
//    }
//}

//  [ Sol 2 ] 내 방식( 데드라인 적은 순서로 정렬 -> 데드라인이 같다면 pay가 큰 순서대로 정렬 ) -> 오답
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int test = Integer.parseInt(br.readLine()) ;
//
//        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{
//            if(o1[1] == o2[1]) return o2[0] - o1[0]; // deadLine이 같다면 페이가 큰 값 정렬
//            else return o1[1]-o2[1]; // deadLine 기준으로 정렬
//        });
//        for(int t=0;t<test;t++){
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int pay = Integer.parseInt(st.nextToken());
//            int deadLine = Integer.parseInt(st.nextToken());
//
//            pq.offer(new int[]{pay, deadLine});
//        }
//
//        if(test==0) System.out.println(0);
//        else {
//            int[] tmp = pq.poll();
//            int deadLineSum = tmp[1];
//            int paySum = tmp[0];
//
//            while(!pq.isEmpty()){
//                int[] next = pq.poll();
//                if(deadLineSum != next[1]){
//                    System.out.println(next[0]);
//                    deadLineSum = next[1];
//                    paySum += next[0];
//                }
//            }
//            System.out.println(paySum);
//        }
//    }
//}
// [ Sol 3 ] pay 내림차순 정렬 후 배열에서 값 찾기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine()) ;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{
            return o2[0]-o1[0];
        });
        for(int t=0;t<test;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int deadLine = Integer.parseInt(st.nextToken());

            pq.offer(new int[]{pay, deadLine});
        }

        if(test==0) System.out.println(0);
        else {
            int[] cal = new int[10001];
            int paySum = 0;
            while(!pq.isEmpty()){
                int[] tmp = pq.poll();
                int pay = tmp[0];
                int deadLine = tmp[1];

                // deadLine이 남았으면 미리 할 수 있다는 걸 전혀 인지하지 못했다. 반성하자!
                // 해당 날짜가 이미 채워져 있는지 확인
                while(deadLine > 0 && cal[deadLine]!=0){
                    deadLine--;
                }

                if(deadLine!=0){
                    cal[deadLine] = pay;
                    paySum += pay;
                }
            }

            System.out.println(paySum);
        }
    }
}