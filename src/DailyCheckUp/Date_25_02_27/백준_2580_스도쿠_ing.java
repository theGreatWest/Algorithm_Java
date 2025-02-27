package DailyCheckUp.Date_25_02_27;

import java.util.*;
import java.io.*;

public class 백준_2580_스도쿠_ing {
    static int[][] board = new int[9][9];
    static List<int[]> blanks = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 스도쿠 입력 받기
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) {
                    blanks.add(new int[]{i, j});
                }
            }
        }

        // 백트래킹 시작
        solve(0);
    }

    static void solve(int idx) {
        if (idx == blanks.size()) { // 빈 칸을 모두 채웠다면 출력 후 종료
            printBoard();
            System.exit(0);
        }

        int[] pos = blanks.get(idx);
        int x = pos[0], y = pos[1];

        for (int num = 1; num <= 9; num++) {
            if (isValid(x, y, num)) {
                board[x][y] = num;
                solve(idx + 1);
                board[x][y] = 0; // 백트래킹 (원상복구) // 모든 경우를 탐색하는 경우엔 백트레킹 필수
            }
        }
    }

    static boolean isValid(int x, int y, int num) {
        // 가로(행) 확인
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == num) return false;
        }
        // 세로(열) 확인
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == num) return false;
        }
        // 3x3 박스 확인
        int sx = (x / 3) * 3;
        int sy = (y / 3) * 3;
        for (int i = sx; i < sx + 3; i++) {
            for (int j = sy; j < sy + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }

    static void printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
