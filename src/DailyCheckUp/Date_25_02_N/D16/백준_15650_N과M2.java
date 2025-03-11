package DailyCheckUp.Date_25_02_N.D16;

import java.util.*;
import java.io.*;

public class 백준_15650_N과M2 {
    static int n, m;
    static List<Integer> list = new ArrayList<>();
    static List<String> res = new ArrayList<>();
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        br.close();

        visited = new boolean[n + 1];

        dfs(0);

        for (String s : res)
            bw.write(s);
        bw.flush();
        bw.close();
    }

    static void dfs(int length) throws IOException {
        if (length == m) {
            List<Integer> tmp = new ArrayList<>(list);
            Collections.sort(tmp);

            StringBuilder sb = new StringBuilder();
            for(int num : tmp){
                sb.append(num).append(" ");
            }sb.append("\n");

            if(!res.contains(sb.toString())) res.add(sb.toString());

            return;
        }

        for (int k = 1; k <= n; k++) {
            if (!visited[k]) {
                visited[k] = true;
                list.add(k);

                dfs(length + 1);

                visited[k] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
