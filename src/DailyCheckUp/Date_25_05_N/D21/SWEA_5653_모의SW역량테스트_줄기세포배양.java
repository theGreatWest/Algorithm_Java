package DailyCheckUp.Date_25_05_N.D21;

import java.util.*;
import java.io.*;

// Map을 이용한 방법도 존재
public class SWEA_5653_모의SW역량테스트_줄기세포배양 {
    static final int[] di = {0, 0, -1, 1};
    static final int[] dj = {-1, 1, 0, 0};

    static int N, M, K;
    static Cell[][] cell;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
// input
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            int imax = K * 2 + N, jmax = K * 2 + M;
            cell = new Cell[imax][jmax];
            List<Cell> list = new ArrayList<>();
            for (int i = K + 1; i < K + 1 + N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = K + 1; j < K + 1 + M; j++) {
                    int x = Integer.parseInt(st.nextToken());
                    if (x == 0) continue;
                    cell[i][j] = new Cell(i, j, x, 1, 0);
                    list.add(cell[i][j]);
                }
            }

// solve
            for (int hour = 1; hour <= K; hour++) {
                List<Cell> tmp = new ArrayList<>();

                for (Cell c : list) {
                    tmp.add(c);

                    if (c.activeHour == hour) {
                        c.status = 2;
                    }
                    if (c.cultureHour == hour) {
                        for (int d = 0; d < 4; d++) {
                            int ni = c.i + di[d];
                            int nj = c.j + dj[d];
                            Cell nc = cell[ni][nj];

                            if (nc == null) {
                                cell[ni][nj] = new Cell(ni, nj, c.x, 1, hour);
                                tmp.add(cell[ni][nj]);
                            } else if (nc.bornHour == hour
                                    && c.x > nc.x) {
                                tmp.remove(nc);
                                cell[ni][nj] = new Cell(ni, nj, c.x, 1, hour);
                                tmp.add(cell[ni][nj]);
                            }
                        }
                    }
                    if (c.disappearHour == hour) {
                        c.status=3;
                        tmp.remove(c);
                    }
                }

                list = new ArrayList<>(tmp);
            }

// output
            sb.append("#").append(t).append(" ").append(list.size()).append("\n");
        }

        System.out.print(sb);
    }

    static class Cell {
        int i, j;

        int x;
        int status; // 1(비활성화), 2(활성화), 3(소멸)
        int activeHour;
        int disappearHour;
        int cultureHour;
        int bornHour;

        public Cell(int i, int j, int x, int status, int currentHour) {
            this.i = i;
            this.j = j;

            this.x = x;
            this.status = status;
            this.bornHour = currentHour;
            this.activeHour = currentHour + this.x;
            this.disappearHour = this.activeHour + this.x;
            this.cultureHour = this.activeHour + 1;
        }
    }
}