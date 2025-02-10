package 탐색.BFS;

import java.util.*;
import java.io.*;

public class 백준_1260_DFS와BFS프로그램 {
    static List<String> dfs = new ArrayList<>();
    static List<String> bfs = new ArrayList<>();

    static List<Integer>[] arr;
    static boolean[] visitedDfs;
    static boolean[] visitedBfs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        // 노드 연결 관계 저장할 배열 초기화
        arr = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        // 방문 정보 저장할 배열 초기화 : 선언과 동시에 각 요소가 false로 지정된다.
        visitedDfs = new boolean[n + 1];
//        for (int i = 1; i <= n; i++) {
//            visitedDfs[i] = false;
//        }
        visitedBfs = new boolean[n + 1];
//        for (int i = 1; i <= n; i++) {
//            visitedBfs[i] = false;
//        }

        // 연결 관계 집어넣기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            arr[n1].add(n2);
            arr[n2].add(n1);
        }

        // dfs 결과 저장( m부터 봐야되는데... )
        DFS(v);

        // bfs 결과 저장
        BFS(v);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.join(" ", dfs)+"\n");
        bw.write(String.join(" ", bfs)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void DFS(int currNum) {
        if (visitedDfs[currNum]) return;

        visitedDfs[currNum] = true;
        dfs.add(String.valueOf(currNum));

        List<Integer> nextNumbers = arr[currNum];
        Collections.sort(nextNumbers);
        for (int nextNum : nextNumbers) {
            if (!visitedDfs[nextNum]) DFS(nextNum);
        }
    }

    static void BFS(int startNum) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(startNum);
        visitedBfs[startNum] = true;
        bfs.add(String.valueOf(startNum));

        while (!q.isEmpty()) {
            int currNum = q.poll();

            List<Integer> nextNumbers = arr[currNum];
            Collections.sort(nextNumbers);
            for (int nextNum : nextNumbers) {
                if (!visitedBfs[nextNum]) {
                    visitedBfs[nextNum] = true;
                    q.offer(nextNum);
                    bfs.add(String.valueOf(nextNum));
                }
            }
        }
    }
}
