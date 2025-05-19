package DailyCheckUp.Date_25_05_N.D19;

import java.util.*;
import java.io.*;

public class SWEA_2382_모의SW역량테스트_미생물격리 {
    static final int[] dx = {0, -1, 1, 0, 0};
    static final int[] dy = {0, 0, 0, -1, 1};

    static int N, M, K;
    static List<Cluster> clusters;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 한 변의 셀의 개수
            M = Integer.parseInt(st.nextToken()); // 격리 시간
            K = Integer.parseInt(st.nextToken()); // 군집 개수

            // 군집 정보
            clusters = new ArrayList<>();
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());

                Cluster input = new Cluster(x, y, num, dir);
                clusters.add(input);
            }

            // M 시간 동안 방치
            for (int time = 0; time < M; time++) {
                Cluster[][] arr = new Cluster[N][N];

                // 미생물 이동
                for(Cluster cluster : clusters){
                    cluster.move();

                    if(cluster.microNum==0) continue;

                    if(arr[cluster.x][cluster.y]==null) {
                        cluster.maxMicroNum = cluster.microNum;
                        arr[cluster.x][cluster.y] = cluster;

                    } else { // 이미 존재하는 군집과 합치기
                        Cluster a = arr[cluster.x][cluster.y];

                        a.microNum += cluster.microNum;
                        if(cluster.microNum > a.maxMicroNum){
                            a.maxMicroNum = cluster.microNum;
                            a.dir = cluster.dir;
                        }
                    }
                }

                // clusters 정보 초기화
                clusters = new ArrayList<>();
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                        if(arr[i][j]!=null){
                            clusters.add(arr[i][j]);
                        }
                    }
                }
            }

            // 남아있는 미생물 수 총합
            long sum = 0;
            for(Cluster c : clusters){
                sum += c.microNum;
            }

            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }

        System.out.print(sb);
    }

    static boolean isMedicine(int i, int j) {
        int lastIdx = N - 1;
        return i == 0 || i == lastIdx || j == 0 || j == lastIdx;
    }

    static class Cluster {
        int x;
        int y;
        long microNum;
        int dir;
        long maxMicroNum;

        public Cluster(int x, int y, long microNum, int dir) {
            this.x = x;
            this.y = y;
            this.microNum = microNum;
            this.dir = dir;
        }

        // 군집 이동
        void move(){
            x += dx[dir];
            y += dy[dir];

            if(isMedicine(x, y)) {
                if(microNum%2==0) microNum/=2;
                else microNum = (long)Math.floor(microNum / 2.0);

                dir = newDir();
            }
        }

        private int newDir(){
            if(dir==1) return 2;
            if(dir==2) return 1;
            if(dir==3) return 4;
            return 3;
        }
    }
}
