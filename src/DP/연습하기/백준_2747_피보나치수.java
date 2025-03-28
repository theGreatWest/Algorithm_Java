package DP.연습하기;

import java.io.*;

public class 백준_2747_피보나치수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] fibo = new long[n+1];
        fibo[0] = 0;
        fibo[1] = 1;
        for(int i=2;i<=n;i++){
            fibo[i] = fibo[i-1] + fibo[i-2];
        }

        System.out.println(fibo[n]);
    }
}
