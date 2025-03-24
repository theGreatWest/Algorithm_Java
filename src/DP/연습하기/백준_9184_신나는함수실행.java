package DP.연습하기;

import java.util.*;
import java.io.*;

public class 백준_9184_신나는함수실행 {
    static int[][][] dp = new int[21][21][21]; // 0~20

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        while (!line.equals("-1 -1 -1")) {
            sb.append("w(").append(line.replaceAll(" ", ", ")).append(") = ");

            int[] tmp = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            sb.append(solution(tmp[0], tmp[1], tmp[2])).append("\n");

            line = br.readLine();
        }

        System.out.print(sb);
    }

    //w(a, b, c)값을찾는 메소드
    // 근데 이건 dp 라고 보기 좀 애매한데...
    static int solution(int a, int b, int c) {

        //범위 내 값에 있으면서 이미 값을 가진 배열 인덱스일 경우(=>빠르게 값을 받아옴(미리 저장))
        if (valid(a, b, c) && dp[a][b][c] != 0)  return dp[a][b][c];

        else if (a <= 0 || b <= 0 || c <= 0) return 1;

        else if (a > 20 || b > 20 || c > 20) return dp[20][20][20] = solution(20, 20, 20);

        else if (a < b && b < c) return dp[a][b][c] = solution(a, b, c - 1) + solution(a, b - 1, c - 1) - solution(a, b - 1, c);

        return dp[a][b][c] = solution(a - 1, b, c) + solution(a - 1, b - 1, c) + solution(a - 1, b, c - 1) - solution(a - 1, b - 1, c - 1);

    }

    //배열 범위 내의 값인지 유효성 검사하는 메소드
    static boolean valid(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }
}
