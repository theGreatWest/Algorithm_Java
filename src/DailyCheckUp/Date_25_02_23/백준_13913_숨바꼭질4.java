package DailyCheckUp.Date_25_02_23;

import java.util.*;
import java.io.*;

public class 백준_13913_숨바꼭질4 {
    static int n, k;
    static boolean[] visited;
    static int[] parent; // 각 노드의 부모를 추적

    static int count = 0;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        parent = new int[100001];

        BFS();

        BufferedWriter sw = new BufferedWriter(new OutputStreamWriter(System.out));
        sw.write(count + "\n");

        // 역추적해서 부모 찾기
        List<Integer> path = new ArrayList<>();
        for (int i = k; i != n; i = parent[i]) {
            path.add(0, i);
        }
        path.add(0, n);
        for (int i : path) {
            sw.write(i + " ");
        }
        sw.write("\n");
        sw.flush();
    }

    static void BFS() {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(n, 0));
        visited[n] = true;

        while (!q.isEmpty()) {
            Node current = q.poll();

            if (current.num == k) {
                count = current.depth;
                return;
            }

            for (int next : new int[]{current.num - 1, current.num + 1, 2 * current.num}) {
                if (next < 0 || next > 100000 || visited[next]) continue;

                visited[next] = true;
                parent[next] = current.num; // 자신의 값에 부모 노드가 무엇이었는지 기록
                q.offer(new Node(next, current.depth + 1));
            }
        }
    }

    static class Node {
        int num;
        int depth;

        public Node(int num, int depth) {
            this.num = num;
            this.depth = depth;
        }
    }
}
