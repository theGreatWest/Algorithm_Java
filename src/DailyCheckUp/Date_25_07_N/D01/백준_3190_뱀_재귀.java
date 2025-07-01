package DailyCheckUp.Date_25_07_N.D01;

import java.util.*;
import java.io.*;

public class 백준_3190_뱀_재귀 {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    static Deque<int[]> snake = new ArrayDeque<>();
    static Map<Integer, Character> dirs = new HashMap<>();
    static int N, K, L, currSec = 0, currDir = 1;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 보드의 크기
        board = new int[N][N];

        K = Integer.parseInt(br.readLine()); // 사과의 개수
        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken())-1;
            int j = Integer.parseInt(st.nextToken())-1;

            board[i][j] = 1;
        }

        L = Integer.parseInt(br.readLine()); // 뱀의 방향 변환 정보
        for (int l = 0; l < L; l++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            dirs.put(x, c);
        }

        // process
        snake.offer(new int[]{0, 0});
        board[0][0] = 2;
        gameStart();

        // output
        System.out.println(currSec);
    }

    static void gameStart(){
        currSec++;

        int[] currHead = snake.peekFirst();
        int nextHeadX = currHead[0] + dx[currDir];
        int nextHeadY = currHead[1] + dy[currDir];

        if (!isValidPos(nextHeadX, nextHeadY)) return;

        snake.offerFirst(new int[]{nextHeadX, nextHeadY});
        if (board[nextHeadX][nextHeadY] != 1) {
            int[] currTail = snake.pollLast();
            board[currTail[0]][currTail[1]] = 0;
        }
        board[nextHeadX][nextHeadY] = 2;

        if(dirs.containsKey(currSec)){
            currDir = (dirs.get(currSec) == 'L') ? (currDir + 3) % 4 : (currDir + 1) % 4;
        }

        gameStart();
    }

    static boolean isValidPos(int i, int j) {
        return (i >= 0 && i < N && j >= 0 && j < N) && (board[i][j] != 2);
    }
}
