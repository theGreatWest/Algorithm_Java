package 그래프.벨만포드;

import java.io.*;
import java.util.*;

public class 백준_1219_오민식의고민 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 입력
        Target[] arr = new Target[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());

            arr[i] = new Target(s, e, cost);
        }

        long[] earnMax = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        // 처리
        final long INF_NEGATIVE = Long.MIN_VALUE;
        final long INF_POSITIVE = Long.MAX_VALUE;

        long[] cost = new long[n];
        for (int i = 0; i < n; i++) {
            cost[i] = INF_NEGATIVE;
        }
//        cost[startCity] = 0;
        cost[startCity] = earnMax[startCity]; // 0이 아니라 자기 자신의 값으로 지정해 주기 ⭐️

        for (int i = 0; i < n + 100; i++) { // 양수 사이클이 퍼지도록 충분히 많이 반복하기
            for (int j = 0; j < m; j++) {
                Target target = arr[j];

                // 출발 노드가 방문하지 않은 노드이면 skip ⭐️
                if (cost[target.start] == INF_NEGATIVE) continue;

                // 출발 노드가 양수 사이클에 연결된 노드라면 종료 노드도 이 사이클에 연결시키기 ⭐️
                if(cost[target.start]== INF_POSITIVE) cost[target.end] = INF_POSITIVE;
                else{ // 더 많은 돈을 벌 수 있는 새로운 경로가 발견 되었다면 업데이트
                    long tmpCost = cost[target.start] - target.cost + earnMax[target.end];
                    if(tmpCost > cost[target.end]){
                        // n -1 반복 이후 업데이트 되는 종료 노드는 양수 사이클 연결 노드로 변경 ⭐️
                        cost[target.end] = (i >= n-1)? INF_POSITIVE : tmpCost;
                    }
                }

//                long tmpCost = cost[target.start] - target.cost + earnMax[target.end]; // 여기가 틀린듯??
//                if (tmpCost > cost[target.end]) {
//                    cost[target.end] = tmpCost;
//                }
            }
        }

        if(cost[endCity]== INF_NEGATIVE) System.out.println("gg");
        else if(cost[endCity]==INF_POSITIVE) System.out.println("Gee");
        else System.out.println(cost[endCity]);

//        System.out.println(Arrays.toString(cost));

        // 사이클이 있는지 판단 -> 도착 불가능
//        boolean cycle = false;
//        for (int i = 0; i < m; i++) {
//            Target target = arr[i];
//
//            // 시작 도시가 INF일 경우, 해당 도로는 건너뛰기
//            if (cost[target.start] == INF) continue;
//
//            long tmpCost = cost[target.start] - target.cost + earnMax[target.end]; // 여기가 틀린듯??
//            if (tmpCost > cost[target.end]) {
//                cycle = true;
//                break;
//            }
//        }
//
//        // 도착 지점의 비용이 INF와 같다면 도착 지점에 도착할 수 없다는 뜻 : gg
//        // 사이클이 있다면 돈을 무한히 많이 가질 수 있음 : Gee
//        // 나머지는 그냥 출력
//        if(cost[endCity]==INF) System.out.println("gg");
//        else if(cycle) System.out.println("Gee");
//        else System.out.println(cost[endCity]);
    }

    static class Target {
        int start;
        int end;
        long cost;

        public Target(int start, int end, long cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
