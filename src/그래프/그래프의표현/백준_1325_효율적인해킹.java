// BFS 를 사용한 방식

package 그래프.그래프의표현;

import java.io.*;
import java.util.*;

public class 백준_1325_효율적인해킹 {
    static int n, m;
    static boolean[] visited;
    static int[] answer;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = new int[n + 1];

        arr = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b); // 정방향 그래프 입력
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            bfs(i);
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, answer[i]); // 이렇게 실행 결과를 answer 배열에 저장해 두고 비교한다.
        }

        for (int i = 1; i <= n; i++) {
            if (answer[i] == max) System.out.println(i);
        }
    }

    static void bfs(int currNode) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(currNode);
        visited[currNode] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int next : arr[curr]) {
                if (!visited[next]) {
                    visited[next] = true;
                    answer[next]++;
                    q.add(next);
                }
            }
        }
    }
}


// DFS 를 사용한 방식

//package 그래프.그래프의표현;
//
//import java.io.*;
//import java.util.*;
//
//public class 백준_1325_효율적인해킹 {
//    static int n, m, process;
//    static ArrayList<Integer>[] arr;
//    static boolean[] visited;
//    static int[] result;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//
//        visited = new boolean[n + 1];
//
//        arr = new ArrayList[n + 1];
//        for (int i = 0; i <= n; i++) {
//            arr[i] = new ArrayList<>();
//        }
//
//        for (int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            arr[b].add(a); // 역방향 그래프 입력
//        }
//
//        result = new int[n + 1];
//
//        for (int startNum = 1; startNum <= n; startNum++) { // dfs/bfs 를 수행할 땐 dfs/bfs 만 수행하도록 한다. 수행 결과는 따로 List나 Array에 저장해서 나중에 판단하기! 안 그러면 시간 초과 가능!!
//            visited = new boolean[n + 1];
//// dfs
//            process = 0;
//            dfs(startNum);
//            result[startNum] = process;
//// dfs2
//// 재귀호출이 모두 끝난 후에 그 값이 result에 들어가므로 시간 초과가 날 수 있음
////            result[startNum] = dfs2(startNum);
////            System.out.println("startNum = " + startNum+" / 실행결과 = "+ result[startNum]);
//        }
//
//        int max = 0;
//        for (int i = 1; i <= n; i++) {
//            max = Math.max(max, result[i]);
//        }
//
//        List<Integer> computers = new ArrayList<>();
//        for (int i = 1; i <= n; i++) {
//            if (max == result[i]) computers.add(i);
//        }
//
//        Collections.sort(computers);
//
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        for (Integer num : computers) {
//            bw.write(num + "\n");
//        }
//        bw.flush();
//        bw.close();
//    }
//
//    // 전역변수에서 바로 바로 값을 반영해주는 쪽이 시간이 덜 걸린다.
//    static void dfs(int startNum) {
//        if(visited[startNum]) return; // 이렇게 해줘야 시간 초과 X
//
//        visited[startNum] = true;
//
//        for (int nextNum : arr[startNum]) {
//            if (!visited[nextNum]) dfs(nextNum);
//        }
//
//        process++;
//    }
//
//    // 수행 횟수를 나타내는 dfs 형식
//    static int dfs2(int startNum) {
//        visited[startNum] = true;
//
//        int totProcess = 1;
//        for (int nextNum : arr[startNum]) {
//            if (!visited[nextNum]) totProcess += dfs2(nextNum);
//        }
//
//        return totProcess;
//    }
//}
