package DailyCheckUp.Date_25_04_N.D24;

import java.util.*;
import java.io.*;

public class SWEA_2001_파리퇴치 {
    static int N, M, max;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            max = Integer.MIN_VALUE;

            int leftEnd = N - M;
            for (int i = 0; i <= leftEnd; i++) {
                for (int j = 0; j <= leftEnd; j++) {
                    int sum = 0;
                    for (int x = i; x < i + M; x++) {
                        for (int y = j; y < j + M; y++) {
                            sum += arr[x][y];
                        }
                    }
                    max = Math.max(max, sum);
                }
            }

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }
}
