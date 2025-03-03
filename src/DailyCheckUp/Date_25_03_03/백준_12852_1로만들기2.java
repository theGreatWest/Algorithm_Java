package DailyCheckUp.Date_25_03_03;

import java.util.*;
import java.io.*;

// BFS + 최적화

public class 백준_12852_1로만들기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] prev = new int[n + 1];  // 이전 숫자 저장
        int[] depth = new int[n + 1]; // 연산 횟수 저장
        boolean[] visited = new boolean[n + 1]; // 방문 체크

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visited[n] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == 1) break;  // 1에 도달하면 종료

            // 연산 가능한 경우의 수 체크
            for (int next : new int[]{cur - 1, (cur % 2 == 0) ? cur / 2 : -1, (cur % 3 == 0) ? cur / 3 : -1}) {
                if (next > 0 && !visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    prev[next] = cur;   // 이전 숫자 저장 (경로 복원용)
                    depth[next] = depth[cur] + 1; // 연산 횟수 증가
                }
            }
        }

        // 결과 출력
        System.out.println(depth[1]);

        // 역추적을 위한 스택 사용 - 출력 순서를 반대로 하기 위함
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i != 0; i = prev[i]) {
            stack.push(i);
        }

        // 올바른 순서대로 출력
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}
