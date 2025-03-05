package DailyCheckUp.Date_25_03_05;

import java.util.*;
import java.io.*;

public class 백준_9019_DSLR {
    static final int MAX = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[MAX]; // BFS 탐색의 방문 여부 체크
            String[] command = new String[MAX]; // 정답 명령어를 담는 배열


            q.add(a); // a를 큐에 담고
            visited[a] = true; // 방문 표시한다
            Arrays.fill(command,  ""); // 꼭 넣어야하나? 안넣으면 틀림


            while (!q.isEmpty() && !visited[b]) {
                int now = q.poll(); // 큐에서 값을 뺀다 = 현재 탐색 위치

                int D = (2 * now) % MAX; // n을 두배로 바꾸고 10000으로 나눈 나머지
                int S = now == 0 ? 9999 : now - 1; // 0일 때, 9999, 아니면 1을 빼준다
                int L = (now % 1000) * 10 + now / 1000; // 1234 -> 2341 : 1234를 1000으로 나눈 나머지(234)에 10을 곱함=2340, 1234를 1000으로 나누면 1, 2340+1=2341
                int R = (now % 10) * 1000 + now / 10; // 1234 -> 4123 : 1234를 10으로 나눈 나머지에 1000 곱합 = 4000, 1234를 10으로 나누면 123, 4000+123=4123

                if (!visited[D]) {
                    q.add(D); // 큐에 넣는다
                    visited[D] = true; // 방문처리한다
                    command[D] = command[now] + "D"; // 명령어를 추가한다
                }

                if (!visited[S]) {
                    q.add(S);
                    visited[S] = true;
                    command[S] = command[now] + "S";
                }

                if (!visited[L]) {
                    q.add(L);
                    visited[L] = true;
                    command[L] = command[now] + "L";
                }

                if (!visited[R]) {
                    q.add(R);
                    visited[R] = true;
                    command[R] = command[now] + "R";
                }
            }
            System.out.println(command[b]);
        }
    }

/*
    static final int D = 0, S = 1, L = 2, R = 3, MAX = 10000;

    static int a, b;
    static String[] str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            str = new String[MAX];

            bfs();

            sb.append(str[b]).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        q.offer(a);
        str[a] = "";

        while (!q.isEmpty()) {
            int current = q.poll();

            if (current == b) return;

            int[] tmp = dslr(current);
            for (int i = 0; i < 4; i++) {
                int next = tmp[i];
                if(!isOOB(next) && str[next]==null) {
                    q.offer(next);
                    str[next] = str[current] + order(i);
                }
            }
        }
    }

    static int[] dslr(int x) {
        int[] result = new int[4];

        int d = 2 * x;
        d = (d >= MAX) ? d % MAX : d;
        result[D] = d;

        int s = x - 1;
        s = (s == 0) ? 9999 : s;
        result[S] = s;

        String str = String.format("%04d", x);
        String x1 = str.substring(0,1);
        String x2 = str.substring(1,2);
        String x3 = str.substring(2,3);
        String x4 = str.substring(3,4);

        result[L] = Integer.parseInt(x2 + x3 + x4 + x1);
        result[R] = Integer.parseInt(x4 + x1 + x2 + x3);

        return result;
    }

    static String order(int idx) {
        if (idx == D) return "D";
        if (idx == S) return "S";
        if (idx == L) return "L";
        return "R";
    }

    static boolean isOOB(int x){
        return x<0 || x>=MAX;
    }

 */
}
