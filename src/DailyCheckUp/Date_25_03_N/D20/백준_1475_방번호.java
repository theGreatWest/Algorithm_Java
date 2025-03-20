package DailyCheckUp.Date_25_03_N.D20;

import java.io.*;
import java.util.*;

public class 백준_1475_방번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] num = new int[10];
//        for (String s : br.readLine().split("")){
//            num[Integer.parseInt(s)]++;
//        }
        for (char c : br.readLine().toCharArray()){
            num[c - '0']++; // character -> int 형 변환을 위해 [ char - '0' ] 을 사용할 수 있다.
        }

        System.out.println(Arrays.toString(num));

//        int sum69 = num[6] + num[9];
//        int max = sum69/2 + sum69%2;
//        for(int i=0;i<9;i++){
//            if(i==6) continue;
//
//            max = Math.max(max, num[i]);
//        }

        num[6] = (num[6] + num[9] + 1) / 2; // 어차피 2로 나눠주면 나머지가 0 또는 1이기 때문에 1을 더한 후 2로 나눠 준, 몫과 동일하다.
        // 최댓값 찾기
        // 0 ~ 8 까지만 탐색
        // Stream 을 쓰든, for 문을 쓰든 시간 차이는 없었다.
        System.out.println(Arrays.stream(num, 0, 9).max().getAsInt());
    }
}
