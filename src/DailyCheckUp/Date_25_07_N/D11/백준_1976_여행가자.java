package DailyCheckUp.Date_25_07_N.D11;

import java.io.*;
import java.util.*;

public class 백준_1976_여행가자 {
    static int[] parentInfo;

    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시의 수
        int m = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시 수

        parentInfo = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parentInfo[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int isConnect = Integer.parseInt(st.nextToken());
                if (isConnect == 0) continue;
                union(i, j); // 같은 도시를 여러번 방문하는 것이 가능하기 때문에 Union-Find(집합 만들기)를 이용하는 풀이가 유리
            }
        }

        int[] visit = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int base = find(visit[0]);
        for (int i = 1; i < visit.length; i++) {
            int comp = find(visit[i]);

            if (base != comp) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    static int find(int city) {
        if (parentInfo[city] == city) return city;

        return parentInfo[city] = find(parentInfo[city]);
    }

    static void union(int city1, int city2) {
        city1 = find(city1);
        city2 = find(city2);

        // 수가 작은 Node를 부모 Node로 설정 -> 나중에 연결된 도시인지 다시 업데이트 필요 X
        int big = Math.max(city1, city2);
        int small = Math.min(city1, city2);

        if (big != small) parentInfo[big] = small;

        // 집합 정보 바로 저장 -> 나중에 연결된 도시인지 다시 업데이트 필요 O
        if (city1 != city2) parentInfo[city2] = city1;
    }

}
