package DailyCheckUp.Date_25_03_N.D16;

import java.util.*;
import java.io.*;

public class 백준_11060_점프점프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[] visited = new boolean[n];

        Queue<int[]> q = new LinkedList<>(); // BFS 에 Priority Queue 를 사용하면 순서가 뒤죽박죽돼서 틀린 값이 나온다.
//        q.offer(new Node(0, 0));
        q.offer(new int[]{0, 0});
        visited[0] = true;
        int result = -1;

        while(!q.isEmpty()){
//            Node curr = q.poll();
            int[] curr = q.poll();

//            if(curr.idx == n-1){
//                result = curr.depth;
//                break;
//            }
            if(curr[0] == n-1){
                result = curr[1];
                break;
            }

//            int start = curr.idx + 1;
//            int end = Math.min(n-1, curr.idx + arr[curr.idx]);
            int start = curr[0] + 1;
            int end = Math.min(n-1, curr[0] + arr[curr[0]]);

            for(int nextIdx = start; nextIdx <= end; nextIdx++){
                if(!visited[nextIdx]){
//                    q.offer(new Node(nextIdx, curr.depth+1));
                    q.offer(new int[] {nextIdx, curr[1]+1});
                    visited[nextIdx] = true;
                }
            }
        }

        System.out.println(result);
    }

    static class Node {
        int idx;
        int depth;

        public Node(int idx, int depth) {
            this.idx = idx;
            this.depth = depth;
        }
    }
}
