package 그래프.MST_최소신장트리;

import java.util.*;
import java.io.*;

public class 백준_1197_최소스패닝트리 {
    static int v, e;
    static PriorityQueue<Edge> pq;
    static int[] unionFindArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        // 가중치 기준 오름차순으로 배열 생성
        pq = new PriorityQueue<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.offer(new Edge(v1, v2, cost));
        }

        // 유니온 파인드 배열 생성 및 초기화
        unionFindArr = new int[v+1];
        for(int i=1;i<=v;i++){
            unionFindArr[i] = i;
        }

        // 모든 정점을 연결하는 부분 그래프 중 가중치 합이 최소인 트리 구하기
        int answer = 0;
        while(!pq.isEmpty()){
            Edge current = pq.poll();

            if(!isSameRepresentative(current.v1, current.v2)){
                union(current.v1, current.v2);
                answer += current.cost;
            }
        }

        System.out.println(answer);
    }

// 최소 신장 트리


// 유니온 파인드

    // 집합 합치기
    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b){
            unionFindArr[b] = a;
        }
    }

    // 대표 노드 찾기
    static int find(int x) {
        if(unionFindArr[x] == x)
            return x;

        return unionFindArr[x] = find(unionFindArr[x]);
    }

    // 같은 대표값을 갖는지 확인
    static boolean isSameRepresentative(int a, int b) {
        return find(a) == find(b);
    }

    // 에지 정보 저장
    static class Edge implements Comparable<Edge> {
        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge other){
            return this.cost - other.cost;
        }
    }
}
