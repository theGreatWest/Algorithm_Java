package DailyCheckUp.Date_25_03_N.D22;

import java.io.*;
import java.util.*;

public class 백준_15989_123더하기4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[][] dp = new int[100001][4]; //  dp[n][합을 나타내는 수]

        /*

        1) n이 1일 때,  dp[1][1] = 1
        2) n이 2일 때, dp[2][1]  = 1 (1+1) , dp[2][2] = 1
        3) n이 3일 때, dp[3][1] = 1 (1+1+1), dp[3][2] = 1 (1+2), dp[3][3] = 1 (3)

        위의 초기값 설정을 토대로 3을 주기로 점화식을 도출해 볼 수 있다.

        num = num-1 + 1;
        num = (num-2) + 2 or (num-2) + (1+1);
        num = (num-3) + 3 or (num-2) + (2+1) or (num-3) + (1+1+1);

        */

        dp[1][1] =1;
        dp[2][1] =1;
        dp[2][2] =1;
        dp[3][1] =1;
        dp[3][2] =1;
        dp[3][3] =1;

        for(int i=4; i<10001; i++) {
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1]+ dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int res = dp[n][1] + dp[n][2] + dp[n][3];

            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }
// 시간 초과
    static int BFS(int n) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, 1));
        q.offer(new Node(2, 2));
        q.offer(new Node(3, 3));

        int cnt = 0;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            for(int next=curr.prev; next<=3; next++){
                int nextValue = curr.num + next;

                if (nextValue < n) {
                    q.offer(new Node(nextValue, next));
                }if(nextValue == n){
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static class Node {
        int num;
        int prev;

        public Node(int num, int prev) {
            this.num = num;
            this.prev = prev;
        }
    }
}
