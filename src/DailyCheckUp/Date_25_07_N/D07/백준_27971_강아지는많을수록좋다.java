package DailyCheckUp.Date_25_07_N.D07;

import java.util.*;
import java.io.*;

public class 백준_27971_강아지는많을수록좋다 {
    static int N, M, A, B;
//    static List<int[]> limits;

    static boolean[] visited;
    static int res;

    static boolean[] limits;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

//        limits = new ArrayList<>();
//        for (int m = 0; m < M; m++) {
//            st = new StringTokenizer(br.readLine());
//            int l = Integer.parseInt(st.nextToken());
//            int r = Integer.parseInt(st.nextToken());
//
//            limits.add(new int[]{l, r});
//        }

//        BFS
//        int res = bfs();
//
//        System.out.println(res);

//        DFS
//        visited = new boolean[N + 1];
//        res = Integer.MAX_VALUE;
//
//        visited[0] = true;
//        dfs(0, 0);
//
//        System.out.println((res == Integer.MAX_VALUE) ? -1 : res);

//        DP
        limits = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            for (int j = l; j <= r && j <= N; j++) {
                limits[j] = true;
            }
        }

        int res = dp();

        System.out.println(res);
    }

    // DP
    static int dp() {
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            if (limits[i]) continue;

            if (i - A >= 0 && dp[i - A] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - A] + 1);
            }
            if (i - B >= 0 && dp[i - B] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - B] + 1);
            }
        }

        return (dp[N] == Integer.MAX_VALUE) ? -1 : dp[N];
    }
//
//    // 정답
//    static int bfs() {
//        boolean[] visited = new boolean[N + 1];
//        Queue<int[]> queue = new LinkedList<>();
//
//        queue.offer(new int[]{0, 0}); // 현재 강아지 수, 수행 횟수
//        visited[0] = true;
//
//        while (!queue.isEmpty()) {
//            int[] now = queue.poll();
//            int dogs = now[0];
//            int cnt = now[1];
//
//            if (dogs == N) return cnt; // 최소 수행 횟수이므로 return cnt
//
//            for (int next : new int[]{dogs + A, dogs + B}) {
//                if (next <= N && !visited[next] && !containLimit(next)) {
//                    visited[next] = true;
//                    queue.offer(new int[]{next, cnt + 1});
//                }
//            }
//        }
//
//        return -1;
//    }
//
//    // 시간 초과
//    static void dfs(int currentDogsNum, int cnt) {
//        if (cnt > res) return;
//
//        if(currentDogsNum == N){
//            res = cnt;
//            return;
//        }
//
//        int nextCnt = cnt + 1;
//        for (int nextNum : new int[]{currentDogsNum + A, currentDogsNum + B}) {
//            if (nextNum<=N && !visited[nextNum] && !containLimit(nextNum)) {
//                visited[nextNum] = true;
//                dfs(nextNum, nextCnt);
//                visited[nextNum] = false;
//            }
//        }
//    }

//    static boolean containLimit(int currentDogsNum) {
//        for (int[] limit : limits) {
//            if (limit[0] <= currentDogsNum && currentDogsNum <= limit[1]) {
//                return true;
//            }
//        }
//        return false;
//    }
}