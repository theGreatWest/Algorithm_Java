package DailyCheckUp.Date_25_04_N.D10;

import java.util.*;
import java.io.*;

public class SWEA_3307_최장증가부분수열 {
    static int n, length;
    static long[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            n = Integer.parseInt(br.readLine());

            long[] tmp = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            arr = new long[n+1];
            for(int i=1;i<=n;i++){
                arr[i] = tmp[i-1];
            }

//            for(int startIdx = 0; startIdx<n; startIdx++){
//                long[] result = new long[n];
//                result[startIdx] = arr[startIdx];
//                dfs(startIdx, result, 1);
//            }

//            for(int startIdx=n; startIdx>=1; startIdx--){
//                int[] dp = new int[n+1];
//                dp[startIdx] = 1;
//                for(int i=startIdx-1; i>=1; i--){
//                    dp[i] = (arr[i] <= arr[i+1]) ? dp[i+1] + 1 : dp[i+1];
//                }
//                length = Math.max(dp[1], length);
//                System.out.println(Arrays.toString(dp));
//            }
//            System.out.println();

// ⭐️ LIS : 최장 증가 부분 수열
// 기본적인 DP, O(N²)
//            int[] dp = new int[n+1];
//            Arrays.fill(dp, 1);  // 최소 길이 1
//            System.out.println("초기 dp = " + Arrays.toString(dp));
//
//            for (int end = 1; end <= n; end++) {
//                for (int j = 1; j < end; j++) { // 건너뛸 수 있는 경우 이렇게 풀어주기
                                                    // 모든 이전 값을 확인해 주는 풀이 방식
//                    if (arr[j] < arr[end]) {
//                        dp[end] = Math.max(dp[end], dp[j] + 1);
//                    }
//                    System.out.print("i = " + end);
//                    System.out.print(", j = " + j);
//                    System.out.println(" -> dp = " + Arrays.toString(dp));
//                }
//            }
//            length = Arrays.stream(dp).max().getAsInt();

// ⭐️ LIS : 최장 증가 부분 수열
// 고급 풀이, O(NlogN)
            List<Long> list = new ArrayList<>(); // 현재까지 만들어진 LIS 후보들 저장
            for(int i=1; i<=n;i++){
                int idx = Collections.binarySearch(list, arr[i]); // LIS 후보들 중, arr[i] 의 index 를 이진 탐색으로 찾는다.
                // 값을 찾지 못 하면 -1이 아닌 꽤 의미있는 값을 반환한다.
                // 값이 삽입될 수 있는 위치(오름차순 정렬 기준) --> [ -(삽입할 위치 + 1) ] 이 반환된다.
                // 내림차순 정렬된 배열의 값을 찾을 때 --> Collections.binarySearch(list, target, Comparator.reverseOrder());
                // 이진 탐색을 반드시 이미 정렬된 배열/리스트일 때만 사용 가능하다.
                if(idx < 0) idx = -(idx+1); // 원소를 못 찾는다면 idx(arr[i]의 위치) 를 -(idx+1)으로 변경
//                list = [1, 3, 5]
//                arr[i] = 4
//                → 4는 2번째 인덱스에 들어가야 하므로
//                → idx = 2

                if(idx==list.size()) list.add(arr[i]); // 지금 숫자를 LIS 끝에 붙일 수 있다면 LIS 연장
                else list.set(idx, arr[i]); // 아니라면 기존 값 교체
            }
            System.out.println(list.size());

            sb.append("#").append(t).append(" ").append(length).append("\n");
        }

        System.out.print(sb);
    }

    // 제한시간 초과 -> DP 방식 고민할 것
    static void dfs(int idx, long[] result, int cnt){
//        System.out.print("idx = " + idx);
//        System.out.print(" / result = " + Arrays.toString(result));
//        System.out.println(" / cnt = " + cnt);

        if(idx == n-1) {
            length = Math.max(length, cnt);
            return;
        }

        int nextIdx = idx + 1;
        if(nextIdx<n){
            if(result[idx] <= arr[nextIdx]){
                long[] tmp = Arrays.copyOf(result, result.length);
                tmp[nextIdx] = arr[nextIdx];
                dfs(nextIdx, tmp, cnt+1);
            }

            dfs(nextIdx, result, cnt);
        }
    }
}
