package DailyCheckUp.Date_25_05_N.D16;

import java.util.*;
import java.io.*;

public class SWEA_1258_SW문제해결응용_7일차_행렬찾기 {
    static final int[] di = {-1, 0, 1, 0};
    static final int[] dj = {0, 1, 0, -1};

    static int N;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            PriorityQueue<Matrix> pq = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] != 0) {
                        int lastI = i, lastJ = j;
                        while (lastI < N && arr[lastI][j] != 0) lastI++;
                        while (lastJ < N && arr[i][lastJ] != 0) lastJ++;

                        pq.offer(new Matrix(lastI - i, lastJ - j));

                        for (int x = i; x < lastI; x++) {
                            for (int y = j; y < lastJ; y++) {
                                arr[x][y] = 0;
                            }
                        }
                    }
                }
            }

// 만약, 결과값을 리스트에 저장해서 정렬한다면?
// list에 들어있는 int[] 요소 두 개(a, b)를 꺼내와서 비교한다는 의미
//            Collections.sort(list, (a, b) -> {
//                if (a[2] != b[2]) return Integer.compare(a[2], b[2]); // 면적 기준 오름차순(작은 것 부터)
//                return Integer.compare(a[0], b[0]); // 면적이 같으면 행 크기 오름차순(작은 것 부터)
//            });

            sb.append("#").append(t).append(" ").append(pq.size()).append(" ");
            StringBuilder res = new StringBuilder();
            while (!pq.isEmpty()) {
                Matrix curr = pq.poll();
                res.append(curr.getResult());
            }
            sb.append(res).append("\n");

//            PriorityQueue<Matrix> pq = new PriorityQueue<>();
//            visited = new boolean[N][N];
//            for(int i=0;i<N;i++){
//                for(int j=0;j<N;j++){
//                    if(arr[i][j]!=0 && !visited[i][j]){
//                        dfs(i, j);
//                        pq.offer(getRes(i, j));
//                    }
//                }
//            }
//
//            sb.append("#").append(t).append(" ").append(pq.size()).append(" ");
//            StringBuilder res = new StringBuilder();
//            while (!pq.isEmpty()){
//                Matrix curr = pq.poll();
//                res.append(curr.getResult());
//            }
//            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int i, int j) {
        visited[i][j] = true;

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if (isValidPosition(ni, nj) && arr[ni][nj] != 0 && !visited[ni][nj]) {
                dfs(ni, nj);
            }
        }
    }

    static Matrix getRes(int startI, int startJ) {
        int xLen = 0, yLen = 0;

        int x = startI;
        while (true) {
            x++;
            if (isValidPosition(x, startJ) && visited[x][startJ]) xLen++;
            else break;
        }

        int y = startJ;
        while (true) {
            y++;
            if (isValidPosition(startI, y) && visited[startI][y]) yLen++;
            else break;
        }

        return new Matrix(++xLen, ++yLen);
    }

    static boolean isValidPosition(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < N;
    }

    static class Matrix implements Comparable<Matrix> {
        int row;
        int column;
        int size;

        public Matrix(int row, int column) {
            this.row = row;
            this.column = column;
            this.size = row * column;
        }

        public String getResult() {
            return row + " " + column + " ";
        }

        @Override
        public int compareTo(Matrix o) {
            if (this.size == o.size) return this.row - o.row;
            return this.size - o.size;
        }
    }
}
