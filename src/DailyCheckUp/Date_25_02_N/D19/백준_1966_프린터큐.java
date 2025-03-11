package DailyCheckUp.Date_25_02_N.D19;

import java.util.*;
import java.io.*;

public class 백준_1966_프린터큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());    // 테스트 케이스

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Deque<int[]> list = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 중요도를 저장하는 우선순위 큐

            for (int i = 0; i < n; i++) {
                int priority = Integer.parseInt(st.nextToken());
                list.add(new int[]{priority, i});
                pq.add(priority);
            }

            int cnt = 0;
            while (!list.isEmpty()) {
                int[] current = list.poll(); // 현재 문서

                if (current[0] == pq.peek()) { // 현재 문서가 가장 높은 중요도를 가지는 경우
                    pq.poll(); // 가장 높은 중요도 제거
                    cnt++;

                    if (current[1] == m) { // 찾고자 하는 문서라면 종료
                        sb.append(cnt).append("\n");
                        break;
                    }
                } else { // 중요도가 더 높은 문서가 있으면 다시 큐에 넣음
                    list.offer(current);
                }
            }
        }

        System.out.print(sb);
    }
}