package DailyCheckUp.Date_25_04_N.D28;

import java.util.*;
import java.io.*;

public class SWEA_12100_로봇조종프로그래밍언어 {
    static final int MAX = 4500;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, -1, 0, 1};
    static final Map<String, Integer> strToInt = new HashMap<>();
    static {
        strToInt.put("n", 0);
        strToInt.put("w", 1);
        strToInt.put("s", 2);
        strToInt.put("e", 3);
    }
    static final Map<Integer, Character> intToChar = new HashMap<>();
    static {
        intToChar.put(0, 'n');
        intToChar.put(1, 'w');
        intToChar.put(2, 's');
        intToChar.put(3, 'e');
    }

    static int N, M, d, e;
    static int x, y, h;
    static char[][] map;
    static Map<String, String> proxy;
    static int trialNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            map = new char[N][M];
            for (int i = 0; i < N; i++) {
                int j = 0;
                for (char c : br.readLine().toCharArray()) {
                    map[i][j++] = c;
                }
            }

            proxy = new HashMap<>();
            for (int i = 0; i < d; i++) {
                String[] tmp = br.readLine().split("=");
                proxy.put(tmp[0], tmp[1]);
            }

            sb.append("#").append(t);
            for (int o = 0; o < e; o++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken()) - 1;
                y = Integer.parseInt(st.nextToken()) - 1;
                h = strToInt.get(st.nextToken());

                trialNum = 0;
                start(br.readLine());

                sb.append(" ");
                if (trialNum >= MAX) sb.append("inf");
                else sb.append(x + 1).append(" ").append(y + 1).append(" ").append(intToChar.get(h));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void start(String order) {
        if (trialNum >= MAX) return;

        Queue<Character> q = new LinkedList<>();
        for (char c : order.toCharArray()) {
            q.offer(c);
        }

        while (!q.isEmpty()) {
            char cmd = q.poll();
            if (++trialNum >= MAX) return;

            if (Character.isUpperCase(cmd)) start(String.valueOf(proxy.get(String.valueOf(cmd))));
            else if (cmd == 'm') m();
            else if (cmd == 'l') l();
            else if (cmd == 'i') {
                char condition = q.poll();
                String[] programs = i(q);
                if (selectCond(condition)) start(programs[0]);
                else start(programs[1]);
            } else if (cmd == 'u') {
                char condition = q.poll();
                String program = getProgram(q);

                while (!selectCond(condition)) {
                    start(program);
                    if (++trialNum >= MAX) return;
                }
            }
        }
    }

    // command
    // 현재 시선 방향으로 한 칸 전진
    // 전진하려는 칸에 장애물이 있거나, 격자 밖이면 아무 효과 없다.
    static void m() {
        int nx = x + dx[h];
        int ny = y + dy[h];

        if (!ior(nx, ny) && map[nx][ny] == '.') {
            x = nx;
            y = ny;
        }
    }

    // 왼쪽으로 90도 회전
    static void l() { //
        h = (h + 1) % 4;
    }

    // 조건1, 프로그램2
    // true -> 첫 번째 프로그램
    // false -> 두 번째 프로그램
    static String[] i(Queue<Character> q) {
        String[] programs = new String[2];

        for (int i = 0; i < 2; i++) {
            programs[i] = getProgram(q);
        }

        return programs;
    }

    static String getProgram(Queue<Character> q) {
        StringBuilder program = new StringBuilder();
        int leftCnt = 0;
        q.poll();
        while (true) {
            char curr = q.poll();
            if (curr == '(') leftCnt++;
            else if (curr == ')') {
                if (leftCnt == 0) break;
                else leftCnt--;
            }
            program.append(curr);
        }
        return program.toString();
    }

    // condition
    static boolean selectCond(char c) {
        if (c == 'b') return b();
        if (c == 'n') return n();
        if (c == 'w') return w();
        if (c == 's') return s();
        return e();
    }

    // b
    // 시선 방향의 다음 칸이 격자 밖이거나, 장애물이 있을 때 true
    static boolean b() {
        int nx = x + dx[h];
        int ny = y + dy[h];

        return ior(nx, ny) || map[nx][ny] == '#';
    }

    // e
    // 시선 방향이 동쪽일 때 참
    static boolean e() {
        return h == 3;
    }

    // w
    // 시선 방향이 서쪽을 때 참
    static boolean w() {
        return h == 1;
    }

    // s
    // 시선 방향이 남쪽일 때 참
    static boolean s() {
        return h == 2;
    }

    // n
    //시선 방향이 북쪽일 때 참
    static boolean n() {
        return h == 0;
    }

    static boolean ior(int i, int j) {
        return i < 0 || i >= N || j < 0 || j >= M;
    }
}