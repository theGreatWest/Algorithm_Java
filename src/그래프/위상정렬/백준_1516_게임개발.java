package 그래프.위상정렬;

import java.util.*;
import java.io.*;

public class 백준_1516_게임개발 {
    static int n;
    static ArrayList<Integer>[] arr;
    static int[] selfHours; // 해당 건물의 건설 시간
    static int[] indegree; // 진입 차수 배열
    static int[] result; // 결과 저장 배열

    // 어떤 건물을 짓기 전에 다른 건물을 먼저 지어야 할 수도 있기 때문에 dfs/bfs 사용은 안 된다

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        indegree = new int[n + 1];
        selfHours = new int[n + 1];

        for (int buildingNum = 1; buildingNum <= n; buildingNum++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            selfHours[buildingNum] = Integer.parseInt(st.nextToken()); // 해당 건물 건축 시간 저장

            while (true) {
                int preBuildingNum = Integer.parseInt(st.nextToken());

                if (preBuildingNum == -1)
                    break;

                arr[preBuildingNum].add(buildingNum); // 연결 관계
                indegree[buildingNum]++; // 진입 차수
            }
        }

// 위상 정렬
        result = new int[n + 1];

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();

//            result[curr] += selfHours[curr];

            for (int next : arr[curr]) {
//                result[next] += selfHours[curr];
                // 시간 업데이트
                result[next] = Math.max(result[next], result[curr] + selfHours[curr]);
                // 여러개의 pre가 next를 가리킴 == 하나의 작업은 여러개의 선행 작업을 가짐
                // 모든 선행 작업이 끝나야 지금 작업을 진행할 수 있기 때문에, 선행 작업들 중 가장 오래 걸리는 작업을 따라가야 함

                if (--indegree[next] == 0) q.offer(next);
            }
        }

// 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
//            sb.append(result[i]).append("\n");
            sb.append(result[i]+selfHours[i]).append("\n");
        }
        System.out.print(sb);
    }
}