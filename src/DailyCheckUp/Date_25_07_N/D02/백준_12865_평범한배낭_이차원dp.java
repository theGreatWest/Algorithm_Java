package DailyCheckUp.Date_25_07_N.D02;

import java.io.*;
import java.util.*;

// N개의 물건
// 각 물건은 무게(W), 가치(V)를 갖는다.
// 최대 K만큼의 무게만 넣을 수 있다.
// 가치의 최댓값 출력

public class 백준_12865_평범한배낭_이차원dp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물품의 수
        int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게

        int[][] dp = new int[N + 1][K + 1]; // dp[물건의 IDX][무게 W일 때 얻을 수 있는 최대 가치]
        for (int objIdx = 1; objIdx <= N; objIdx++) {
            st = new StringTokenizer(br.readLine());
            int objWeight = Integer.parseInt(st.nextToken()); // 물건의 무게
            int objValue = Integer.parseInt(st.nextToken()); // 물건의 가치

            // 이차원 DP는 정방향 순회 가능
            for (int w = 0; w <= K; w++) {
                int prevObj = objIdx - 1;
                dp[objIdx][w] = (objWeight > w) ? dp[prevObj][w] : Math.max(dp[prevObj][w], dp[prevObj][w - objWeight] + objValue);

//                // 삼항 연산자 설명
//                if (objWeight > w) { // ( 현재 고려 중인 무게 최대치(w) < 물건의 무게 )인 경우
//                    dp[objIdx][w] = dp[prevObj][w]; // 해당 물건을 담을 수 없음 => 이전 무게 값 그대로 가져오기
//                } else{
//                    dp[objIdx][w] = Math.max(
//                            dp[prevObj][w], // 해당 물건 선택 X => 이전 값 그대로
//                            dp[prevObj][w - objWeight] + objValue // 해당 물건 선택 O
//                    );
//                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
