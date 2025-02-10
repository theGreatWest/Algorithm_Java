package 탐색.DFS;

import java.io.*;
import java.util.*;

public class 백준_2023_신기한소수 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        br.close();

        // process : 한 자리 소수로 시작
        dfs(2,1);
        dfs(3,1);
        dfs(5,1);
        dfs(7,1);

        // output
        bw.flush();
        bw.close();

        // process & output
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int sNum = (int) Math.pow(10, n - 1), eNum = (int) Math.pow(10, n) - 1;
//        for (int i = sNum; i <= eNum; i++) {
//            if(dec(i)) bw.write(i+"\n");
//        }
//        bw.flush();
//        bw.close();


    }

    static void dfs(int num, int length) throws IOException {
        // 길이가 n이면 출력 후 종료
        if (length == n) {
            bw.write(num + "\n");
            return;
        }

        // 다음 숫자 만들기
        for (int i = 1; i <= 9; i += 2) { // 짝수는 소수가 아닐 가능성이 높기 때문에 제외
            int nextNum = num * 10 + i;
            if (isPrime(nextNum))
                dfs(nextNum, length + 1);
        }
    }

//    static boolean dec(int n){
//        String str = String.valueOf(n);
//        for(int i=1;i<str.length()+1;i++){
//            String tmp = str.substring(0,i);
//            if(!isPrime(Integer.parseInt(tmp))) return false;
//        }
//        return true;
//    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) { // 3부터 √N까지 홀수만 검사
            if (n % i == 0) return false;
        }
        return true;
    }
}
