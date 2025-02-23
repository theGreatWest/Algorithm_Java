package 그래프.다익스트라;

import java.util.*;
import java.io.*;

public class 백준_1854_K번째최단경로찾기 {
    static int citiesNum, roadsNum, k;

    static int[][] timeInfo;
    static PriorityQueue<Integer>[] pqs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        citiesNum = Integer.parseInt(st.nextToken());
        roadsNum = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()); // index

// 각 도시마다 우선순위 큐를 저장할 배열 생성
        pqs = new PriorityQueue[citiesNum + 1];
        // 오름차순으로 정렬 기준 선택
        Comparator<Integer> cp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : -1; // 큰 값이 우선 반환됨 ( == o2 - o1 )
                // return o1-o2; // o1이 o2보다 작으면 음수가 반환됨. 더 작은 값인 o1이 반환되는 것.
            }
        };
        // 각 도시마다 크기가 k인 우선순위 큐 초기화
        for (int i = 1; i <= citiesNum; i++) {
            pqs[i] = new PriorityQueue<>(k, cp);
        }

// 인접 행렬에 데이터 저장
        timeInfo = new int[citiesNum + 1][citiesNum + 1];
        for (int i = 0; i < roadsNum; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt((st.nextToken()));

            timeInfo[a][b] = time;
        }

// 다익스트라 알고리즘
        dijkstra();

// k 번째 경로 출력
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=citiesNum;i++){
            sb.append((pqs[i].size()==k) ? pqs[i].peek() : -1).append("\n");
        }
        System.out.print(sb);
    }

// Dijkstra
    static void dijkstra() {
        pqs[1].add(0);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            // 연결된 모든 노드 검색(시간 복잡도 측면에서 인접 행렬이 불리함)
            for (int nextNode = 1; nextNode <= citiesNum; nextNode++) {
                if(timeInfo[current.node][nextNode] != 0){
                    int nextCost = current.cost + timeInfo[current.node][nextNode];

                    // 저장된 경로가 k개가 안 될 때
                    if(pqs[nextNode].size() < k){
                        pqs[nextNode].add(nextCost);
                        pq.add(new Node(nextNode, nextCost));
                    }else{ // 저장된 경로가 이미 k 개이고, 현재 가장 큰 값보다 작을 때만 추가
                        if(nextCost < pqs[nextNode].peek()){
                            pqs[nextNode].poll(); // 기존 큐에서 Max값 먼저 삭제
                            pqs[nextNode].add(nextCost);
                            pq.add(new Node(nextNode, nextCost));
                        }
                    }
                }
            }
        }
    }

// Node
    static class Node implements Comparable<Node> {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }
}
