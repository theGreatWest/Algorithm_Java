package DailyCheckUp.Date_25_02_24;

import java.util.*;
import java.io.*;

public class 백준_13549_숨바꼭질3 {
    static int n, k;

    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];

        System.out.println(bfs());
    }

    static int bfs() {
//        Queue<Node> q = new LinkedList<>();
//        덱을 사용해서 2*N 을 맨 앞에 넣어 먼저 수행될 수 있도록 하면 시간 단축
        Deque<Node> q = new ArrayDeque<>();

        q.offer(new Node(n, 0));
        visited[n] = true;

        while (!q.isEmpty()) {
            Node current = q.poll();

            if (current.num == k) return current.depth;

            int teleportingNum = 2 * current.num;
            if(!isOutOfRange(teleportingNum) && !visited[teleportingNum]) {
//                덱의 맨 앞에 넣어주기: 비용이 0이니까 앞에 넣어주기
                q.offerFirst(new Node(teleportingNum, current.depth));
//                q.offer(new Node(teleportingNum, current.depth));
//                visited 를 체크해 주지 않음
                visited[teleportingNum] = true;
            }

            for (int nextNum : new int[]{current.num - 1, current.num + 1}) {
                if (!isOutOfRange(nextNum) && !visited[nextNum]) {
//                    q.offer(new Node(nextNum, current.depth + 1));
//                    deque 변경 시 offerFirst, offerLast 로 구분됨
                    q.offerLast(new Node(nextNum, current.depth + 1)); // 비용이 1이니까 뒤에 넣어주기
                    visited[nextNum] = true;
                }
            }
        }

        return -1;
    }

    static boolean isOutOfRange(int num) {
        return num < 0 || num > 100000;
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
