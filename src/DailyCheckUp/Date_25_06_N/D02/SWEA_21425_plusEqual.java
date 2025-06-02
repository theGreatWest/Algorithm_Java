package DailyCheckUp.Date_25_06_N.D02;

import java.util.*;
import java.io.*;

public class SWEA_21425_plusEqual {
    static long N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long T = Long.parseLong(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            N = Long.parseLong(st.nextToken());

            sb.append(solve(A, B)).append("\n");
        }

        System.out.print(sb);
    }

    // 완전 탐색보다 더 빠른 해결책(최적해를 보장하는 규칙(Greedy))이 있을 수 있다!
    // ---> 탐색 문제를 모두 BFS, DFS로 풀 필요는 없다.
    // ---> 문제 구조를 보면 더 효율적인 수학적 해법 또는 그리디가 존재할 수 있다.

    // 문제 속 규칙성(패턴)을 찾아 일반화 할 줄 아는 능력 필요
    // ---> 문제에서 반복되는 값의 증가 패턴을 관찰하면, 일반화된 규칙을 발견할 수 있다.

    // 단순 규칙 기반으로, 상태가 한 방향으로만 진행될 때는 그리가 최적해가 되는 경우가 많다.
    static long solve(long a, long b) {
        long cnt = 0;
        while (a <= N && b <= N) {
            if (a < b) a += b;
            else b += a;
            cnt++;
        }
        return cnt;
    }

    // 제한시간 초과
    static long bfs(long x, long y) {
        Queue<long[]> q = new LinkedList<>();
        Set<Long> visited = new HashSet<>();
        q.offer(new long[]{x, y, 0});

        long size = N + 1;

        while (!q.isEmpty()) {
            long[] curr = q.poll();
            long a = curr[0];
            long b = curr[1];
            long depth = curr[2];

            if (a > N || b > N) return depth;

            long key = a * size + b;
            if (visited.contains(key)) continue;
            visited.add(key);

            long sum = a + b;
            if (sum > N) return depth + 1;

            q.offer(new long[]{sum, b, depth + 1}); // x += y
            q.offer(new long[]{a, sum, depth + 1}); // y += x
        }

        return 0;
    }
}
