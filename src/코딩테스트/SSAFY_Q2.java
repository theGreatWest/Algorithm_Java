package 코딩테스트;

import java.util.*;
import java.io.*;

// 문제2
// 원 위에 M개의 칸이 있다. 각 칸은 시계 방향으로 1번부터 M번까지 번호가 붙어 있다.
//
//정수 수열 A[1], A[2], …, A[N]이 주어진다. 각 A[i]는 방문해야 할 칸의 번호이다.
//
//철수는 이 칸들을 순서대로 방문해야 한다.
//
//단, 한 칸에서 다른 칸으로 이동할 때 반드시 시계 방향으로만 이동해야 한다.
//
//그리고 철수는 수열 A에서 하나의 원소를 제외할 수 있다.
//
//철수가 이동하는 최소 이동 거리를 계산하라. 인접한 칸의 거리는 모두 1이다.
//
//
//
//아래 입력 예의 첫 번째 테스트 케이스를 확인해보자.
//
//칸 제외 없이는 1번 칸 → 5번 칸 → 2번 칸 → 8번 칸으로 이동하고, 총 이동 거리는 17이 된다.
//
//
//
//칸을 제외 했을 시, 아래와 같다.
//
//1번 칸 제외 : 5번 칸 → 2번 칸 → 8번 칸, 총 이동 거리 13
//
//2번 칸 제외 : 1번 칸 → 5번 칸 → 8번 칸, 총 이동 거리 7
//
//5번 칸 제외 : 1번 칸 → 2번 칸 → 8번 칸, 총 이동 거리 7
//
//8번 칸 제외 : 1번 칸 → 5번 칸 → 2번 칸, 총 이동 거리 11
//
//최소 이동 거리는 7이다.
//
//[제약사항]
//
//1.	N은 3 이상 20,000 이하의 정수이다. (3 ≤ N ≤ 20,000)
//
//2.	M은 3 이상 10,000 이하의 정수이다. (3 ≤ M ≤ 10,000)
//
//3.	초기 입력 A[1], A[2], …, A[N]에서 인접한 값은 항상 다르다.
//
//
//
//[입력]
//
//가장 첫 줄에는 테스트 케이스의 총 수가 주어진다.
//
//그 다음 줄부터 각 테스트 케이스가 주어지며, 각 테스트 케이스는 2줄로 구성된다.
//
//각 테스트 케이스의 첫 줄에는 N, M의 값이 공백을 사이에 두고 주어진다.
//
//다음 줄에 N개의 칸 번호가 주어진다.
//
//
//
//[출력]
//
//출력의 각 줄은 최소 거리를 출력한다.

public class SSAFY_Q2 {

    static int N, M;
    static int[] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            long[] dp = new long[N];
            for (int i = 1; i < N; i++) {
                int from = A[i - 1];
                int to = A[i];

                dp[i] = dp[i - 1] + ((from > to) ? (M - from + to) : (to - from));
            }

            long minDist = Math.min(dp[N - 2], Math.min(dp[N - 1], dp[N - 1] - dp[1]));
            for (int visited = 1; visited < N - 1; visited++) {
                int from = A[visited - 1];
                int to = A[visited + 1];

                long tmp = (dp[N - 1] - dp[visited + 1]) + ((from > to) ? (M - from + to) : (to - from)) + (dp[visited - 1]);

                minDist = Math.min(minDist, tmp);
            }

            System.out.println("#" + t + " " + minDist);
        }
    }
}
