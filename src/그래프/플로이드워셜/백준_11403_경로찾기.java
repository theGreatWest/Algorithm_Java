package 그래프.플로이드워셜;

import java.util.*;
import java.io.*;

public class 백준_11403_경로찾기 {
    static final int[] di = {0, 0, 1, -1};
    static final int[] dj = {1, -1, 0, 0};

    static int n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    // 문제 이해
                    // i -> j 로 가는 길이 있는지 없는지
                    // 중간에 k를 거쳐 가는 길( i->k , k->j 길이 모두 존재해야 i->j로 갈 수 있음 )이 있는지 판단
                    if(arr[i][j]==1) continue;

                    if(arr[i][k]==1 && arr[k][j]==1){
                        arr[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append((arr[i][j] > 0) ? 1 : 0).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
