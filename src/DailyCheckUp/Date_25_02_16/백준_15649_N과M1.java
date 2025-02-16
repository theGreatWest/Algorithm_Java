package DailyCheckUp.Date_25_02_16;

import java.util.*;
import java.io.*;

public class 백준_15649_N과M1 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Integer> list = new ArrayList<>();
    static boolean[] visited;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        br.close();

        visited = new boolean[n + 1];

        DFS(0);

        bw.flush();
        bw.close();
    }

    static void DFS(int cnt) throws IOException {
        if (cnt == m) {
            for (int num : list) {
                bw.write(num + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) { // 방문하지 않은 숫자만 선택
                visited[i] = true;
                list.add(i);

                DFS(cnt + 1); // 재귀호출

                list.remove(list.size() - 1); // 백트래킹
                visited[i] = false;
            }
        }
    }
}
