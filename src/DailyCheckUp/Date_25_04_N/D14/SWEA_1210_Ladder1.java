package DailyCheckUp.Date_25_04_N.D14;

import java.util.*;
import java.io.*;

public class SWEA_1210_Ladder1 {
    static int[][] arr;
    static boolean[][] visited;
    static boolean find;

    // DFS 사용하는 방법
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int c = 0; c < 10; c++) {
            int t = Integer.parseInt(br.readLine());
            arr = new int[100][100];

            List<Integer> js = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());

                    if (i == 0 && arr[i][j] == 1) js.add(j);
                }
            }

            find = false;
            for(int j : js){
                visited = new boolean[100][100];

                dfs(0, j);

                if(find) {
                    sb.append("#").append(t).append(" ").append(j).append("\n");
                    break;
                }
            }
        }

        System.out.print(sb);
    }

    static void dfs(int i, int j) {
        visited[i][j] = true;

        if (i == 99) {
            if (arr[i][j] == 2) {
                find = true;
            }
            return;
        }

        if (j - 1 >= 0 && arr[i][j - 1] == 1 && !visited[i][j - 1]) {
            while (j - 1 >= 0 && arr[i][j - 1] == 1) { // 같은 방향으로 쭉 이어져야 하기 때문에 끝점까지 while 문을 통해 반복문 처리
                j--;
                visited[i][j] = true;
            }
        } else if (j + 1 < 100 && arr[i][j + 1] == 1 && !visited[i][j + 1]) {
            while (j + 1 < 100 && arr[i][j + 1] == 1) {
                j++;
                visited[i][j] = true;
            }
        }

        dfs(i + 1, j);
    }

// While 문 사용하는 방법
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        for (int c = 0; c < 10; c++) {
//            int t = Integer.parseInt(br.readLine());
//            arr = new int[100][100];
//
//            List<Integer> js = new ArrayList<>();
//            for (int i = 0; i < 100; i++) {
//                StringTokenizer st = new StringTokenizer(br.readLine());
//                for (int j = 0; j < 100; j++) {
//                    arr[i][j] = Integer.parseInt(st.nextToken());
//
//                    if (i == 0 && arr[i][j] == 1) js.add(j);
//                }
//            }
//
//            for (int j : js) {
//                visited = new boolean[100][100];
//                int ni = 0, nj = j;
//                boolean found = false;
//
//                while (ni < 100) {
//                    visited[ni][nj] = true;
//
//                    if (arr[ni][nj] == 2) {
//                        sb.append("#").append(t).append(" ").append(j).append("\n");
//                        found = true;
//                        break;
//                    }
//
//                    if (nj - 1 >= 0 && arr[ni][nj - 1] == 1 && !visited[ni][nj - 1]) {
//                        nj--;
//                    } else if (nj + 1 < 100 && arr[ni][nj + 1] == 1 && !visited[ni][nj + 1]) {
//                        nj++;
//                    } else {
//                        ni++;
//                    }
//                }
//
//                if (found) break;
//            }
//        }
//
//        System.out.print(sb);
//    }
}