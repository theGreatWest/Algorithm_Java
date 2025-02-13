package 그래프.그래프의표현;

import java.util.*;
import java.io.*;

public class 백준_2251_물통 {
    static boolean[][] visited; // (A, B) 상태 방문 여부
    static int A, B, C;
    static TreeSet<Integer> result = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        br.close();

        visited = new boolean[A + 1][B + 1];

        bfs();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int res : result) {
            bw.write(res + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, C}); // 초기 상태 (A=0, B=0, C=C)
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int a = cur[0], b = cur[1], c = cur[2];

            // A가 0일 때 C의 값을 저장
            if (a == 0) result.add(c);

            // 물을 옮기는 6가지 경우
            moveWater(q,    a, b, c);
        }
    }

    static void moveWater(Queue<int[]> q,   int fromA, int fromB, int fromC) {
        int[] nextA = {fromA - Math.min(fromA, B - fromB), fromB + Math.min(fromA, B - fromB), fromC}; // A → B
        int[] nextB = {fromA - Math.min(fromA, C - fromC), fromB, fromC + Math.min(fromA, C - fromC)}; // A → C
        int[] nextC = {fromA + Math.min(fromB, A - fromA), fromB - Math.min(fromB, A - fromA), fromC}; // B → A
        int[] nextD = {fromA, fromB - Math.min(fromB, C - fromC), fromC + Math.min(fromB, C - fromC)}; // B → C
        int[] nextE = {fromA + Math.min(fromC, A - fromA), fromB, fromC - Math.min(fromC, A - fromA)}; // C → A
        int[] nextF = {fromA, fromB + Math.min(fromC, B - fromB), fromC - Math.min(fromC, B - fromB)}; // C → B

        int[][] moves = {nextA, nextB, nextC, nextD, nextE, nextF};

        for (int[] next : moves) {
            int na = next[0], nb = next[1], nc = next[2];

            if (!visited[na][nb]) {
                visited[na][nb] = true;
                q.add(new int[]{na, nb, nc});
            }
        }
    }
}