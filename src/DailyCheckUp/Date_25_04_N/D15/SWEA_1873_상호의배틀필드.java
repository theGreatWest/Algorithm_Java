package DailyCheckUp.Date_25_04_N.D15;

import java.util.*;
import java.io.*;

public class SWEA_1873_상호의배틀필드 {
    static final int[] DX = {-1, 1, 0, 0}; // U, D, L, R
    static final int[] DY = {0, 0, -1, 1};

    static final Map<Character, Integer> DIR_MAP = new HashMap<>();
    static {
        DIR_MAP.put('^', 0);
        DIR_MAP.put('v', 1);
        DIR_MAP.put('<', 2);
        DIR_MAP.put('>', 3);
    }

    static final Map<Character, Character> CMD_TO_DIR = new HashMap<>();
    static {
        CMD_TO_DIR.put('U', '^');
        CMD_TO_DIR.put('D', 'v');
        CMD_TO_DIR.put('L', '<');
        CMD_TO_DIR.put('R', '>');
    }

    static int H, W, x, y;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new char[H][W];
            for (int i = 0; i < H; i++) {
                String line = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = line.charAt(j);
                    if (DIR_MAP.containsKey(map[i][j])) {
                        x = i;
                        y = j;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine());
            String commands = br.readLine();

            for (char cmd : commands.toCharArray()) {
                if (cmd == 'S') shoot();
                else move(cmd);
            }

            sb.append("#").append(t).append("\n").append(printMap());
        }

        System.out.print(sb);
    }

    static void shoot() {
        int d = DIR_MAP.get(map[x][y]);
        int nx = x, ny = y;
        while (true) {
            nx += DX[d];
            ny += DY[d];
            if (oor(nx, ny) || map[nx][ny] == '#') break;
            if (map[nx][ny] == '*') {
                map[nx][ny] = '.';
                break;
            }
        }
    }

    static void move(char cmd) {
        int d = DIR_MAP.get(CMD_TO_DIR.get(cmd));
        map[x][y] = CMD_TO_DIR.get(cmd);
        int nx = x + DX[d], ny = y + DY[d];
        if (!oor(nx, ny) && map[nx][ny] == '.') {
            map[x][y] = '.';
            map[nx][ny] = CMD_TO_DIR.get(cmd);
            x = nx;
            y = ny;
        }
    }

    static boolean oor(int i, int j) {
        return i < 0 || j < 0 || i >= H || j >= W;
    }

    static String printMap() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
