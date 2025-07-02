package DailyCheckUp.Date_25_07_N.D02;

import java.util.*;
import java.io.*;

// N개의 물건
// 각 물건은 무게(W), 가치(V)를 갖는다.
// 최대 K만큼의 무게만 넣을 수 있다.
// 가치의 최댓값 출력

public class 백준_12865_평범한배낭_dfs {
    static List<Object> objects;
    static int maxValue;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 물품의 수
        K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게

        objects = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken()); // 물건의 무게
            int v = Integer.parseInt(st.nextToken()); // 물건의 가치

            objects.add(new Object(w, v));
        }

        maxValue = Integer.MIN_VALUE;
        dfs(0, 0, 0);

        System.out.println(maxValue);
    }

    // 중복된 케이스가 다수 발생해서 시간 초과 => DP
    static void dfs(int idx, int weightSum, int valueSum) {
        if (idx >= N) {
            maxValue = Math.max(maxValue, valueSum);
            return;
        }

        int nextIdx = idx + 1;

        // 해당 idx의 물건을 선택 X
        dfs(nextIdx, weightSum, valueSum);

        // 해당 idx의 물건을 선택할 때
        Object currentObj = objects.get(idx);
        int weightTmp = weightSum + currentObj.weight;
        // 무게 합이 K보다 클 경우, 현재 가치가 가장 큰 값인지 비교
        if(weightTmp > K) {
            maxValue = Math.max(maxValue, valueSum);
        } else { // 무게의 합이 K 이하일 경우 해당 idx의 물건 선택 O
            int valueTmp = valueSum + currentObj.value;
            dfs(nextIdx, weightTmp, valueTmp);
        }
    }

    static class Object {
        int weight;
        int value;

        public Object(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
