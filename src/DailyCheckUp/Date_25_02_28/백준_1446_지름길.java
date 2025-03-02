package DailyCheckUp.Date_25_02_28;

import java.util.*;
import java.io.*;

public class 백준_1446_지름길 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 지름길 개수
        int D = Integer.parseInt(st.nextToken());  // 도착 지점

        // 최단 거리 저장 배열
        int[] dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        // 그래프 초기화
        ArrayList<Node>[] graph = new ArrayList[D + 1];
        for (int i = 0; i <= D; i++) {
            graph[i] = new ArrayList<>();
        }

        // 일반 도로 추가 (1씩 이동하는 간선) : 아.. 지름길이 아닌 노드를 추가해서 그래프로 만들어준다! 수평선 관련 문제는 이런식으로 그래프 만들어서 이용하자
        // 최단 거리 문제 : 다익스트라 이용 전 무조건 그래프 형태로 만들어주기
        for (int i = 0; i < D; i++) {
            graph[i].add(new Node(i + 1, 1));
        }

        // 지름길 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (end > D) continue;  // 도착 지점보다 먼 지름길은 무시
            graph[start].add(new Node(end, cost));
        }

        // 다익스트라 알고리즘
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.cost > dist[now.pos]) continue;

            for (Node next : graph[now.pos]) {
                int nDist = now.cost + next.cost;
                if (nDist < dist[next.pos]) {
                    dist[next.pos] = nDist;
                    pq.add(new Node(next.pos, nDist));
                }
            }
        }

        // 도착 지점까지의 최단 거리 출력
        System.out.println(dist[D]);
    }

    static class Node implements Comparable<Node> {
        int pos, cost;

        public Node(int pos, int cost) {
            this.pos = pos;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
