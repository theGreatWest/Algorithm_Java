package DailyCheckUp.Date_25_02_17;

import java.util.*;
import java.io.*;

public class 백준_7662_이중우선순위큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
// sol 3 > TreeMap( 양방향 삽입/삭제 + 우선 순위 ) 사용한 풀이
            TreeMap<Long, Long> tm = new TreeMap<>(Comparator.reverseOrder()); // 키 값 기준 내림차순(큰 것 부터 나열) 정렬

            int k = Integer.parseInt(br.readLine());
            for (int o = 0; o < k; o++) {
                st = new StringTokenizer(br.readLine());
                String order = st.nextToken();
                Long value = Long.parseLong(st.nextToken());

                if (order.equals("I")) {
                    tm.put(value, tm.getOrDefault(value, 0L) + 1);
                } else {
                    if (tm.isEmpty()) continue;

                    if (value == 1) {
                        long bigValue = tm.firstKey();
                        if (tm.get(bigValue) <= 1) tm.remove(bigValue);
                        else tm.replace(bigValue, tm.get(bigValue) - 1);
                    } else {
                        long smallValue = tm.lastKey();
                        if (tm.get(smallValue) <= 1) tm.remove(smallValue);
                        else tm.replace(smallValue, tm.get(smallValue) - 1);
                    }
                }
            }

            if(tm.isEmpty()) sb.append("EMPTY");
            else sb.append(tm.firstKey()).append(" ").append(tm.lastKey());
            sb.append("\n");


//  Sol 2 > PriorityQueue 를 사용한 풀이
//            PriorityQueue<Long> pqB = new PriorityQueue<>(Comparator.reverseOrder());
//            PriorityQueue<Long> pqS = new PriorityQueue<>();
//            TreeMap<Long, Long> map = new TreeMap<>();
//
//            int k = Integer.parseInt(br.readLine());
//            for (int o = 0; o < k; o++) {
//                st = new StringTokenizer(br.readLine());
//                String order = st.nextToken();
//                long value = Long.parseLong(st.nextToken());
//
//                if (order.equals("I")) {
//                    pqB.offer(value);
//                    pqS.offer(value);
//                    map.put(value, map.getOrDefault(value, 0L) + 1); // 있다면 해당 값 + 1 / 없다면 0을 반환시켜 +1
//                } else {
//                    if (map.isEmpty()) continue;
//
//                    long count = 0;
//                    if (value == 1) {
//                        count = map.lastKey();
//                    } else {
//                        count = map.firstKey();
//                    }
//                    map.put(count, map.get(count) - 1);
//                    if (map.get(count) == 0) {
//                        map.remove(count);
//                    }
////                } if (value == 1) {
////                    if (!pqB.isEmpty() && !removed.contains(pqB.peek())) {
//////                        pqS.remove(big);
////                        removed.add(pqB.poll());
////                    }
////                } else {
////                    if (!pqS.isEmpty() && !removed.contains(pqS.peek())) {
//////                        pqB.remove(small);
////// 이것의 시간 복잡도는 O(N) -> 3중 반복문이므로 시간 초과
////// 삭제된 값을 저장해서 추적하는 방식으로 가자
////                        removed.add(pqS.poll());
////                    }
////                }
//                }
//
////            while(!pqB.isEmpty() && removed.contains(pqB.peek())){
////                pqB.poll();
////            }
////            while(!pqS.isEmpty() && removed.contains(pqS.peek())){
////                pqS.poll();
////            }
////
////            if (pqB.isEmpty() || pqS.isEmpty()) sb.append("EMPTY");
////            else sb.append(pqB.poll()).append(" ").append(pqS.poll());
////            sb.append("\n");
//            }
//            if (map.isEmpty()) sb.append("EMPTY");
//            else sb.append(map.lastKey()).append(" ").append(map.firstKey());
//            sb.append("\n");
        }
        System.out.print(sb);
    }
}
