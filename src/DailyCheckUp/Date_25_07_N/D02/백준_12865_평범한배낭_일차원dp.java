package DailyCheckUp.Date_25_07_N.D02;

import java.io.*;
import java.util.*;

// N개의 물건
// 각 물건은 무게(W), 가치(V)를 갖는다.
// 최대 K만큼의 무게만 넣을 수 있다.
// 가치의 최댓값 출력

public class 백준_12865_평범한배낭_일차원dp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물품의 수
        int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게

        int[] dp = new int[K + 1]; // 무게 == idx일 때의 value 값 최대치로 갱신
        for (int objIdx = 0; objIdx < N; objIdx++) {
            st = new StringTokenizer(br.readLine());
            int objWeight = Integer.parseInt(st.nextToken()); // 물건의 무게
            int objValue = Integer.parseInt(st.nextToken()); // 물건의 가치

            // 거꾸로 해야 숫자가 중복되는 일이 생기지 않음
            // Ex. IDX_3번 물건(W:3, V:6) 전 DP 상태 => 0 0 0 0 8 8 13 13
            // 정방향 순회 -> 0 0 0 6 8 8 13( vs (6 + 6) ) 13
            // 역방향 순회 -> 0 0 0 6 8 8 13( vs (0 + 6) ) 13
            // 정방향으로 햐는 것은 정확하지 않음
            // dp[6]의 경우 이미 해당 물체의 값으로 업데이트 된 ( dp[3]=6 )의 값이 반영된 값이 비교값으로 사용되는 것을 확인할 수 있음 == 같은 물건 중복 사용
            // ▶️ DP 구현시 역순으로 값을 업데이트해 주는 이유
            for(int w = K; w>= objWeight; w--){
                dp[w] = Math.max(dp[w], dp[w-objWeight] + objValue);
            }
        }

        System.out.println(dp[K]);
    }
}
