package 탐색.DFS;

import java.io.*;
import java.util.*;

public class 백준_13023_ABCDE {
    static int n, m;
    static ArrayList<Node>[] nodes;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new ArrayList<>();
        }

        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }

        // process
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken()), num2 = Integer.parseInt(st.nextToken());
            nodes[num1].add(new Node(num2, 1));
            nodes[num2].add(new Node(num1, 1));
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) dfs(i, 1);
            if (found) break;
        }
        System.out.println((found) ? 1 : 0);
    }

    static boolean found = false;

    static void dfs(int i, int depth) {
        if (depth == 5) {
            found = true;
            return;
        }

        visited[i] = true;

        for (Node friend : nodes[i]) {
            if (!visited[friend.num]) { // 아 여기서 갈라지는 구나
                dfs(friend.num, depth + 1);
                if (found) return; // 찾는 즉시 종료
            }
        }

        visited[i] = false;
    }

    static class Node {
        int num;
        int value;

        public Node(int num, int value) {
            this.num = num;
            this.value = value;
        }
    }
}
