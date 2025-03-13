package DailyCheckUp.Date_25_03_N.D13;

import java.io.*;

// 선발 명단 작성
// 성의 첫글자가 같은 선수 5명 선발
// 5명보다 적다면 기권
// 뽑을 수 있는 성의 첫글자 모두 구하기

public class 백준_1159_농구경기 {
    static int n;

    static int[] countTable;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        countTable = new int[26];
        for(int i=0;i<n;i++){
            int idx = (int)br.readLine().charAt(0) - 97;
            countTable[idx]++;
        }

        boolean able = false;
        for(int i=0;i<26;i++){
            if(countTable[i] >= 5){
                sb.append((char)(i+97));
                able = true;
            }
        }

        if(able) System.out.println(sb);
        else System.out.println("PREDAJA");
    }
}
