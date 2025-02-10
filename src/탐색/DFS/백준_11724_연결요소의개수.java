package 탐색.DFS;

import java.io.*;
import java.util.*;

public class 백준_11724_연결요소의개수 {
    static ArrayList<Node>[] nodes;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
// input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            nodes[i] = new ArrayList<>(); // 각 인덱스에 ArrayList 할당
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int sNode = Integer.parseInt(st.nextToken()), eNode = Integer.parseInt(st.nextToken());
            nodes[sNode].add(new Node(eNode, 1));
            nodes[eNode].add(new Node(sNode, 1)); // 방향이 없으니까 두 개 다 넣어주기
            // 방향이 정해져 있지 않은 경우, 무조건 두 노드에 연결 정보를 모두 넣어줘야 정확히 탐색함
        }
        br.close();

// process
        visit = new boolean[n + 1];
        visit[0] = true;
        for (int i = 1; i <= n; i++) {
            visit[i] = false;
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                res++;
                dfs(i);
            }
        }

// output
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(res + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int sNode) {
        // 방문 처리
        if (visit[sNode]) return; // 이미 방문한 곳이라면 반환

        visit[sNode] = true;

        // 다음 노트로 연결
        List<Node> nextNodes = nodes[sNode];
        for (Node nextNode : nextNodes) {
            if (!visit[nextNode.num]) dfs(nextNode.num); // 연결된 노드 중 방문한 적이 없는 노드만 dfs 다시 수행
        }
    }

    static class Node {
        int num;
        int value;

        public Node(int next, int value) {
            this.num = next;
            this.value = value;
        }
    }
}
