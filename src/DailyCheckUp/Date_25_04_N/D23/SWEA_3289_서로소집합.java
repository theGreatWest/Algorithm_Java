package DailyCheckUp.Date_25_04_N.D23;

import java.util.*;
import java.io.*;

public class SWEA_3289_서로소집합 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[N+1];
            for(int i=1;i<=N;i++){
                arr[i] = i;
            }

            makeSet(N);

            sb.append("#").append(t).append(" ");
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int order = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(order==0) union2(a,b);//union(a, b);
                else if(isSameSet(a, b)) sb.append(1);
                else sb.append(0);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static int find(int a) {
        if (arr[a] == a) return a;

        return arr[a] = find(arr[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) arr[b] = a;
    }

    static boolean isSameParents(int a, int b) {
        return find(a) == find(b);
    }

    // Union-by-Rank + path compression 적용된 코드
    static int[] parent;
    static int[] rank; // 각 집합의 트리높이||랭크(우선순위) 저장

    // 초기화 함수: 자기 자신을 부모로 설정 + 랭크 초기화
    static void makeSet(int n){
        parent = new int[n+1];
        rank = new int[n+1];

        for(int i=1;i<=n;i++){
            parent[i] = i; // 처음에 자기 자신이 대표자
            rank[i] = 0; // 모든 집합의 초기 높이는 0
        }
    }

    // find 연사나 : 대표(루트) 노트 찾기
    // path compression 적용 : 찾으면서 경로 압축
    static int find2(int a){
        if(a != parent[a])
            parent[a] = find2(parent[a]); // 경로 압축: 대표 노드를 직접 가리키게 함

        return parent[a]; // 루트 노트 반환
    }

    static void union2(int a, int b){
        int rootA = find2(a);
        int rootB = find2(b);

        if(rootA==rootB) return; // 이미 같은 집합이면 종료

        // rank 기준으로 합치기
        // rank 가 낮은 것(깊이가 적은 것)의 루트노드 = 높은 것의 루트노드
        // 즉, 높이가 낮은 트리의 루트를, 높이가 더 높은 트리의 자식으로 붙이는 방법
        if(rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB; // 대가리를 B루트로!
            /*
                   rootB
                   /
               rootA
            */
        } else{
            parent[rootB] = rootA; // 대가리를 A루트로!
            /*
                   rootA
                   /
               rootB
            */
            if(rank[rootA] == rank[rootB]){ // 두 트리의 높이가 같다면
                rank[rootA]++; // 자식이 하나 더 늘어난 노드의 rank 증가시키기
                // rootA는 rootB 까지 포함하는 새로운 서브트리의 루트니까 트리의 높이가 1 증가한 것과 같다.
            }
        }
    }

    static boolean isSameSet(int a, int b){
        return find2(a) == find2(b);
    }
}
