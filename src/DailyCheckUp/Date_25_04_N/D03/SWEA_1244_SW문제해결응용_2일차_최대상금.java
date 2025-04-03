package DailyCheckUp.Date_25_04_N.D03;

import java.io.*;
import java.util.*;

public class SWEA_1244_SW문제해결응용_2일차_최대상금 {
    static int maxPrize;
    static int swapCount;
    static String number;
    static HashSet<String> visited; // 방문 체크 (숫자 + 남은 교환횟수)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            number = st.nextToken(); // 초기 숫자판
            swapCount = Integer.parseInt(st.nextToken()); // 교환 횟수
            maxPrize = 0;
            visited = new HashSet<>(); // 방문 체크 초기화

            // DFS 탐색 시작
            dfs(0, number.toCharArray());

            sb.append("#").append(t).append(" ").append(maxPrize).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int depth, char[] arr) {
        if (depth == swapCount) { // 교환 횟수를 모두 사용하면 최댓값 갱신
            maxPrize = Math.max(maxPrize, Integer.parseInt(new String(arr)));
            return;
        }

        // 방문 체크 (현재 상태 + 남은 교환 횟수)
        String state = new String(arr) + depth;
        if (visited.contains(state)) return;
        visited.add(state);

        // 모든 가능한 위치에서 교환 시도
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                swap(arr, i, j);  // 교환
                dfs(depth + 1, arr); // 다음 단계 탐색
                swap(arr, i, j);  // 원상 복구 (백트래킹)
            }
        }
    }

    // 두 자리의 값을 교환하는 함수
    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
