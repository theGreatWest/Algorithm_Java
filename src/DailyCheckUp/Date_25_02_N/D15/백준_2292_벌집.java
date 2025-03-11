package DailyCheckUp.Date_25_02_N.D15;

import java.io.*;
import java.util.*;

public class 백준_2292_벌집 {
    static long n;
    static Map<Long, Set<Long>> map;
    static Map<Long, Boolean> visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
        br.close();

// < Sol 1 > 단순히 규칙을 찾아 층 수를 파악하는 방법
        long lastNum = 1;
        long depth = 1;
        while(true){
            lastNum += (depth - 1)*6;

            if(n <= lastNum) break;
            else depth++;
        }

        System.out.println(depth);

// < Sol 2: ~ING > 벌집을 인접 리스트로 구현해 BFS 를 이용해 depth 를 알아내는 방법
//        // 1. 인접 리스트와 방문 조회 Map 초기 세팅
//        map = new HashMap<>();
//        visited = new HashMap<>();
//        for (long i = 1; i <= n; i++) {
//            map.put(i, new HashSet<>());
//            visited.put(i, false);
//        }
//
//        // 2. 인접 리스트 만들기
//        long currNum = 1;
//        // n의 수가 1이 아니라면 2번부터 연결 관계 만들기
//        if (n == 1) System.out.println(n);
//        else {
//            long num = 2; // 1번 노드부터 시작, 그 다음 숫자부터 연결
//            for (long layer = 1; num <= n; layer++) {
//                long start = num; // 이번 층의 첫 번째 숫자
//                long count = 6 * layer; // 이번 층의 숫자 개수
//                long end = start + count - 1; // 이번 층의 마지막 숫자
//
//                // 이번 층의 숫자들 연결
//                for (long i = start; i <= end && i <= n; i++) {
//                    // i와 i+1 연결 (인접한 숫자들끼리 연결)
//                    if (i < end && i + 1 <= n) {
//                        map.get(i).add(i + 1);
//                        map.get(i + 1).add(i);
//                    }
//
//                    // 이전 층의 마지막 숫자와 현재 층 첫 번째 숫자 연결
//                    if (i == start) {
//                        long prevLayerLast = start - (layer - 1) * 6;
//                        if (i != prevLayerLast) {  // 예외 방지
//                            map.get(i).add(prevLayerLast);
//                            map.get(prevLayerLast).add(i);
//                        }
//                    }
//
//                    // 마지막 숫자는 첫 번째 숫자와 연결
//                    if (i == end && end + 1 <= n) {
//                        map.get(i).add(start);
//                        map.get(start).add(i);
//                    }
//                }
//
//                num = end + 1; // 다음 층의 시작 숫자
//            }
//
//            // 1번 노드와 그 연결된 노드들 연결
//            for (long i = 2; i <= n; i++) {
//                map.get(1L).add(i);
//                map.get(i).add(1L);
//            }
//        }
//
//        // 3. 저장 결과 확인하기
//        for (long i = 1; i <= n; i++) {
//            System.out.println("Node: " + i + " / " + map.get(i).toString());
//        }
//
//        System.out.println(BFS(1));
    }

    static long BFS(long startNode) {
        Queue<long[]> q = new LinkedList<>();

        q.offer(new long[]{startNode, 0});
        visited.replace(startNode, true);

        while (!q.isEmpty()) {
            long[] tmp = q.poll();
            long currNode = tmp[0];
            long currDepth = tmp[1];

            if (currNode == n) return currDepth;

            for (Long nextNode : map.get(currNode)) {
                if (!visited.get(nextNode)) {
                    visited.replace(nextNode, true);
                    q.offer(new long[]{nextNode, currDepth + 1});
                }
            }
        }

        return -1;
    }

    static boolean isOutOfRange(long i) {
        return i < 0 || i > n;
    }
}
