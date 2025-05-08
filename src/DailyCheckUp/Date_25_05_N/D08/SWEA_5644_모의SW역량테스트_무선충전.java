package DailyCheckUp.Date_25_05_N.D08;

import java.io.*;
import java.util.*;

public class SWEA_5644_모의SW역량테스트_무선충전 {
    static final int[] dx = {0, 0, 1, 0, -1};
    static final int[] dy = {0, -1, 0, 1, 0};

    static int ax, ay, bx, by;
    static int M, A;
    static int sum;
    static int[] aMove, bMove;
    static BC[] bcs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            aMove = new int[M + 1];
            for (int i = 1; i <= M; i++) {
                aMove[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            bMove = new int[M + 1];
            for (int i = 1; i <= M; i++) {
                bMove[i] = Integer.parseInt(st.nextToken());
            }

            bcs = new BC[A];
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());

                bcs[i] = new BC(x, y, c, p);
            }

            ax = ay = 1;
            bx = by = 10;
            sum = 0;
            for (int t = 0; t <= M; t++) {
                ax += dx[aMove[t]];
                ay += dy[aMove[t]];
                List<Integer> aBC = getAvailableBCS(ax, ay);

                bx += dx[bMove[t]];
                by += dy[bMove[t]];
                List<Integer> bBC = getAvailableBCS(bx, by);

                calculation(aBC, bBC);
            }

            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }

        System.out.print(sb);
    }

    static ArrayList<Integer> getAvailableBCS(int x, int y) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            int d = Math.abs(x - bcs[i].x) + Math.abs(y - bcs[i].y);
            if (d <= bcs[i].c) res.add(i);
        }
        return res;
    }

    static void calculation(List<Integer> aBC, List<Integer> bBC) {
        if(aBC.isEmpty()){
            if(!bBC.isEmpty()) {
                int max = 0;
                for(int bi : bBC){
                    if(bcs[bi].p > max) max = bcs[bi].p;
                }
                sum += max;
            }
        }else{
            if(bBC.isEmpty()) {
                int max = 0;
                for(int ai : aBC){
                    if(bcs[ai].p > max) max = bcs[ai].p;
                }
                sum += max;
            }else{
                int max = 0;
                for(int ai : aBC){
                    for(int bi : bBC){
                        int tmp = bcs[ai].p + ((ai == bi) ? 0 : bcs[bi].p);
                        if(tmp > max) max = tmp;
                    }
                }
                sum += max;
            }
        }
    }

    static class BC{
        int x, y;
        int c;
        int p;

        public BC(int x, int y, int c, int p) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }
    }
}
