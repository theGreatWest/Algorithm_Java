package 매일.Date_25_02_12;

import java.util.*;
import java.io.*;

public class 백준_1697_숨바꼭질 {
    static boolean[] visited;
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];

        System.out.println(BFS());
    }

    static int BFS() {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{n, 0});
        visited[n] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int current = tmp[0];
            int depth = tmp[1];

            if (current == k) return depth;

            for (int next : new int[]{current - 1, current + 1, 2 * current}) {
                if (!isOutOfRange(next) && !visited[next]) {
                    q.offer(new int[]{next, depth + 1});
                    visited[next] = true;
                }
            }
        }
        return -1;
    }

    static boolean isOutOfRange(int i) {
        return i < 0 || i > 100000;
    }
}
