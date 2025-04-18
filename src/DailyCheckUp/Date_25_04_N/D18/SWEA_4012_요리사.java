package DailyCheckUp.Date_25_04_N.D18;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class SWEA_4012_요리사 {
    static int N, A, B, min;
    static int[][] arr;
    static int[] tmp;
    static List<List<Integer>> cases;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            cases = new ArrayList<>();
            tmp = new int[N / 2];
            for (int i = 0; i < N; i++) {
                dfs(i, 0);
            }

            min = Integer.MAX_VALUE;
            for (List<Integer> a : cases) {
                A = 0;
                for(int i=0; i<N/2; i++){
                    int idx1 = a.get(i);
                    for(int j=i+1; j<N/2; j++){
                        int idx2 = a.get(j);
                        A += arr[idx1][idx2] + arr[idx2][idx1];
                    }
                }

                B = 0;
                for(int i=0;i<N;i++){
                    if(a.contains(i)) continue;
                    for(int j=i+1; j<N; j++){
                        if(a.contains(j)) continue;
                        B += arr[i][j] + arr[j][i];
                    }
                }

                int diff = Math.abs(A-B);
                if(diff < min) min = diff;
            }

            sb.append("#").append(t).append(" ").append(min).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int currIdx, int length) {
        tmp[length] = currIdx;

        if (length == N / 2 - 1) {
            cases.add(Arrays.stream(tmp).boxed().collect(Collectors.toList()));
            return;
        }

        for (int i = currIdx + 1; i < N; i++) {
            dfs(i, length + 1);
        }
    }

    static boolean oor(int i, int j) {
        return i < 0 || j < 0 || i >= N || j >= N;
    }
}
