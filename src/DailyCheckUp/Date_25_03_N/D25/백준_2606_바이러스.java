package DailyCheckUp.Date_25_03_N.D25;

import java.util.*;
import java.io.*;

public class 백준_2606_바이러스 {
    static int n, connection, cnt;
    static List<Integer>[] arr;
    static boolean[] visited;

    static int[] unionArr;

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        n = Integer.parseInt(br.readLine());
//        connection = Integer.parseInt(br.readLine());
//
//        arr = new ArrayList[n + 1];
//        for (int i = 1; i <= n; i++) {
//            arr[i] = new ArrayList<>();
//        }
//
//        for (int c = 0; c < connection; c++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//
//            arr[a].add(b);
//            arr[b].add(a);
//        }
//
//        visited = new boolean[n + 1];
//
//        dfs(1);
//
//        System.out.println((cnt == 0) ? 0 : --cnt);
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        connection = Integer.parseInt(br.readLine());

        unionArr = new int[n+1];
        for(int i=1;i<=n;i++){
            unionArr[i] = i;
        }

        for(int c=0;c<connection;c++){
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            union(tmp[0], tmp[1]);
        }

//        System.out.println(Arrays.toString(unionArr));

        int res = 0;
        for(int i=2;i<=n;i++){
            if(find(1) == find(i)) res++; // find() 결과를 가지고 비교했어야 하는데, 하지 않아서 틀렸던 것!
        }

        System.out.println(res);
    }

    static void dfs(int n) {
        for (int next : arr[n]) {
            if (!visited[next]) {
                visited[next] = true;
                cnt++;
                dfs(next);
            }
        }
    }

    static int find(int a) {
        if (unionArr[a] == a) return a;

        return unionArr[a] = find(unionArr[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) unionArr[b] = a;
//        {
//            if(a < b) unionArr[b] = a;
//            else unionArr[a] = b;
//        }
    }
}
