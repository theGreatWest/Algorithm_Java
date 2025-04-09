package DailyCheckUp.Date_25_04_N.D09;

import java.io.*;
import java.util.*;

public class SWEA_2805_농작물수확하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] field = new int[n][n];

            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < n; j++) {
                    field[i][j] = line.charAt(j) - '0';
                }
            }

            int sum = 0;
            int mid = n/2;
            for (int i = 0; i < n; i++) {
                int start = Math.abs(mid - i);
                int end = n - start;
                for (int j = start; j < end; j++) {
                    sum += field[i][j];
                }
            }

            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }

        System.out.print(sb);
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        int T = Integer.parseInt(br.readLine());
//        for(int t=1;t<=T;t++){
//            int n = Integer.parseInt(br.readLine());
//            int[][] arr = new int[n][n];
//            for(int r = 0; r <n; r++){
//                arr[r] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
//            }
//
//            int mid = n/2, diff = 0;
//            boolean increase = true;
//            int value = 0;
//            for(int r=0;r<n;r++){
////                System.out.println("diff = " + diff);
//                int startCol = Math.abs(mid-diff);
//                int endCol = Math.abs(mid+diff);
////                System.out.print("startCol = " + startCol);
////                System.out.println(", endCol = " + endCol);
//                for(int i=startCol; i<=endCol; i++){
//                    value += arr[r][i];
//                }
//
//                if(diff==mid) increase = false;
//
//                if(increase) diff++;
//                else diff--;
//            }
//
//            sb.append("#").append(t).append(" ").append(value).append("\n");
//        }
//
//        System.out.print(sb);
//    }
}
