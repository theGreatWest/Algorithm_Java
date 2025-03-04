package DailyCheckUp.Date_25_03_04;

import java.util.*;
import java.io.*;

public class 백준_12851_숨바꼭질2 {
    static final int MAX = 100001;

    static int n, k;
    static boolean[] visited;
    static int way = 0, minSec = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[MAX];

        // depth 배열을 이용한 방법 : 메모리 사용량을 아껴야 할 때
        depth = new int[MAX];
        Arrays.fill(depth, -1);

//        bfs();

        BFS();
        minSec = depth[k];
        List<List<Integer>> paths = new ArrayList<>();

        backTrace(k, new ArrayList<>(), paths);

        System.out.println(minSec);
        for (List<Integer> path : paths) {
            System.out.println(path);
        }

//        StringBuilder sb = new StringBuilder();
//        sb.append(minSec).append("\n");
//        sb.append(way);
//        System.out.println(sb);
    }


    // 역추적을 통한 경로 찾기용 BFS
    static int[] depth;
    static List<Integer>[] prevNode;

    static void BFS() {
        depth = new int[MAX];
        Arrays.fill(depth, -1); // int[], double[] 일 때만 사용 가능. 자료형이 객체일 때 사용하면 절대 NO!!

        prevNode = new ArrayList[MAX]; // 경로 추적을 위한 리스트. 최단 경로가 여러개일 수 있으므로 List 형으로 배열을 지정한다.
        for (int i = 0; i < MAX; i++) {
            prevNode[i] = new ArrayList<>();
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        depth[n] = 0;

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int next : new int[]{current - 1, current + 1, current * 2}) {
                if (isOutOfRange(next)) continue;

                if (depth[next] == -1) { // 아직 방문하지 않은 노드
                    depth[next] = depth[current] + 1; // depth +1 증가시키기
                    prevNode[next].add(current); // next 의 이전 노드가 current 임을 저장
                    q.offer(next);
                } else if (depth[next] == depth[current] + 1)
                    prevNode[next].add(current); // 이미 방문한 노드인 경우, 다음 노드의 깊이가 현재 노드의 깊이 + 1과 같을 때, 바로 이전 노드라고 판단할 수 있다.
            }
        }
    }

    static void backTrace(int current, List<Integer> path, List<List<Integer>> paths) {
        path.add(current);

        if (depth[current] == 0) { // 시작 노드 도착
            Collections.reverse(path); // 거꾸로 뒤집기: 거꾸로 저장되어 있으니까
            paths.add(new ArrayList<>(path)); // path 는 백트래킹으로 인해 가변값이기 때문에, 새롭게 객체를 만들어 저장하지 않을 경우, 참조값만 저장되어 빈 리스트가 저장된다.
            Collections.reverse(path); // 원상복구: 해당 메서드가 재귀적으로 탐색하므로, path 리스트를 다른 경로에서도 공유한다. 따라서 다시 원상 복구 시켜줘야 한다.
        } else {
            for (int prevNode : prevNode[current]) {
                backTrace(prevNode, path, paths);
            }
        }

        path.remove(path.size() - 1); // 백트래킹
    }

// 경로의 가짓수 찾기
    static int[] ways;

    static void bfs_cnt() {
        depth = new int[MAX];
        Arrays.fill(depth, -1); // int[], double[] 일 때만 사용 가능. 자료형이 객체일 때 사용하면 절대 NO!!

        ways = new int[MAX];

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        depth[n] = 0;
        ways[n] = 1;

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int next : new int[]{current - 1, current + 1, current * 2}) {
                if (isOutOfRange(next)) continue;

                if (depth[next] == -1) { // 아직 방문하지 않은 노드
                    depth[next] = depth[current] + 1; // depth +1 증가시키기
                    ways[next] = ways[current]; // next 의 이전 노드가 current 임을 저장
                    q.offer(next);
                } else if (depth[next] == depth[current] + 1) ways[next] += ways[current]; // 이전의 모든 노드들의 경로 값을 더해줘야 하기 때문에
            }
        }
    }


    // 내장 Class 를 이용한 방법 : 최단 거리(최단 depth)만 구할 수 있다.
    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(n, 0));
        visited[n] = true;

        while (!q.isEmpty()) {
            Node curr = q.poll();
            int currNum = curr.num, currDepth = curr.depth;

            for (int next : new int[]{currNum - 1, currNum + 1, 2 * currNum}) {
                if (!isOutOfRange(next) && !visited[next]) {
                    q.offer(new Node(next, currDepth + 1));
                    visited[next] = true;
                }
            }
        }
    }

    static boolean isOutOfRange(int x) {
        return x < 0 || x >= MAX;
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
