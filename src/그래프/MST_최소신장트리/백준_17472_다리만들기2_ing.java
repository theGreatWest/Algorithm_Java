package 그래프.MST_최소신장트리;

import java.util.*;
import java.io.*;

// 연관 문제 : 2146, 1774, 4386

public class 백준_17472_다리만들기2_ing {
    static final int[] di = {0, 0, 1, -1};
    static final int[] dj = {1, -1, 0, 0};

    static int[] parent;
    static int[][] arr;

    static int N, M, sNum;
    static boolean[][] visited;

    static ArrayList<ArrayList<int[]>> sumList;
    static ArrayList<int[]> mList;

    static PriorityQueue<Edge> pq;

    static int[] unionArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // BFS 탐색으로 섬 분리하기
        sNum = 1; // 섬에 부여할 번호
        sumList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] > 0 && !visited[i][j]) {
                    BFS(i, j);
                    sNum++;
                    sumList.add(mList); // [[], [], [], ...] 이런식으로 들어간다.
//                    System.out.println(mList.size());
                }
            }
        }
//
//        // 분리 확인하기
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }

//        // 확인용
//        for (int i = 0; i < sumList.size(); i++) {
//            for (int[] tmp : sumList.get(i)) {
//                System.out.println(Arrays.toString(tmp));
//            }
//            System.out.println();
//        }

        // 연결 정보 저장하기
        pq = new PriorityQueue<>();
        for (int s = 0; s < sumList.size(); s++) {
            ArrayList<int[]> now = sumList.get(s); // 하나의 섬에 포함된 모든 [i, j]

            for (int m = 0; m < now.size(); m++) { // 해당 섬의 요소 하나씩 처리
                int nowI = now.get(m)[0];
                int nowJ = now.get(m)[1];
                int nowValue = arr[nowI][nowJ];

                for (int d = 0; d < 4; d++) { // 4 방향 검색하기
                    int nextI = nowI + di[d];
                    int nextJ = nowJ + dj[d];
                    int bridgeLength = 0;

                    while (!isOutOfRange(nextI, nextJ)) {
                        int nextValue = arr[nextI][nextJ];

                        if (nextValue == nowValue) break; // 같은 섬이면 길 찾기 중지
                        else if (nextValue != 0) { // 같은 섬이 아닌데 바다도 아니다(다른 섬이다) => 길 연장 종료
                            if (bridgeLength > 1) {
                                pq.offer(new Edge(nowValue, nextValue, bridgeLength)); // 시작 섬 번호, 끝 섬 번호, 다리 길이
//                                System.out.println("now: "+nowI+", "+nowJ);
//                                System.out.println("next: "+nextI+", "+nextJ);
                            }
                            break;
                        } else bridgeLength++; // 바다이면 다리 길이 연장

                        nextI += di[d];
                        nextJ += dj[d];
                    }
                }
            }
        }

//        // Pq 꺼내서 확인해보기
//        while(!pq.isEmpty()){
//            System.out.println(pq.poll().toString());
//        }

        // 섬의 개수대로 유니온-파인드 배열 초기화
        unionArr = new int[sNum];
        for (int i = 1; i < sNum; i++) {
            unionArr[i] = i;
        }

        // 다리의 최소 길이 구하기
        int minCost = 0;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (sNum == 2) break;

            if (find(now.s) != find(now.e)) { // 아직 두 개의 섬이 연결되지 않았다면
//                System.out.println(now.toString());
                union(now.s, now.e); // 연결시키고,
                minCost += now.len; // 다리 길이 더해주기
                sNum--;
            }
        }

//        System.out.println(Arrays.toString(unionArr));

        // 다리 길이 출력해주기
        System.out.println((sNum == 2) ? minCost : -1);
    }

    static int find(int num) {
        if (unionArr[num] == num) return num;

        return unionArr[num] = find(unionArr[num]);
    }

    static void union(int s, int e) {
        s = find(s);
        e = find(e);

        unionArr[e] = s;
    }

    static void BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        mList = new ArrayList<>();

        // 섬의 시작 점 초기화
        q.offer(new int[]{i, j});
        visited[i][j] = true; // 방문 여부 체크
        mList.add(new int[]{i, j}); // 해당 섬에 해당하는 인덱스 저장
        arr[i][j] = sNum; // 섬 번호 저장하기

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int d = 0; d < 4; d++) {
                int nI = curr[0] + di[d], nJ = curr[1] + dj[d];

                if (!isOutOfRange(nI, nJ) && arr[nI][nJ] > 0 && !visited[nI][nJ]) {
                    q.offer(new int[]{nI, nJ});
                    visited[nI][nJ] = true;
                    arr[nI][nJ] = sNum;
                    mList.add(new int[]{nI, nJ});
                }
            }
        }
    }

    static boolean isOutOfRange(int i, int j) {
        return i < 0 || j < 0 || i >= N || j >= M;
    }

    static class Edge implements Comparable<Edge> {
        int s, e, len;

        public Edge(int s, int e, int len) {
            this.s = s;
            this.e = e;
            this.len = len;
        }

        @Override
        public int compareTo(Edge o) {
            return this.len - o.len;
        }
//
//        @Override
//        public String toString() {
//            return "Edge{" +
//                    "s=" + s +
//                    ", e=" + e +
//                    ", v=" + len +
//                    '}';
//        }
    }
}
